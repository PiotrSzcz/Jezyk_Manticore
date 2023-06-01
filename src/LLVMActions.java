import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Stack;

enum VarType{ INT, FLOAT }

enum Precision{FLOAT32, FLOAT64, DM}

class Value{
    public String name;
    public VarType type;

    public Precision precision;
    public Value( String name, VarType type, Precision precision ){
        this.name = name;
        this.type = type;
        this.precision = precision;
    }
}

public class LLVMActions extends MantricoreBaseListener {

    private final String parameter;

    public LLVMActions(String outputFileName) {
        this.parameter = outputFileName;
    }

    HashMap<String, Value> variables = new HashMap<String, Value>();
    Stack<Value> stack = new Stack<Value>();

    void error(int line, String msg){
        System.err.println("Error, line "+line+", "+msg);
        System.exit(1);
    }

    @Override
    public void enterStart(MantricoreParser.StartContext ctx) {
        super.enterStart(ctx);
    }

    @Override
    public void exitStart(MantricoreParser.StartContext ctx) {
        LLVMGenerator.close_main();
        try {
            Files.writeString(Paths.get(parameter + ".ll"), LLVMGenerator.generate());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void exitPrintId(MantricoreParser.PrintIdContext ctx) {
        String ID = ctx.ID().getText();
        VarType type = variables.get(ID).type;
        if (VarType.INT.equals(type)) {
            LLVMGenerator.printf_int(ID);
        } else if (VarType.FLOAT.equals(type)) {
            LLVMGenerator.printf_float(ID, variables.get(ID).precision.toString());
        } else {
            ctx.getStart().getLine();
            System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
        }
    }

    @Override
    public void exitPrintExp(MantricoreParser.PrintExpContext ctx) {
        super.exitPrintExp(ctx);
    }

    @Override
    public void exitReadId(MantricoreParser.ReadIdContext ctx) {
        String ID = ctx.ID().getText();

        if (!( variables.containsKey( ID ))){
            LLVMGenerator.declare_int(ID);
            variables.put(ID, new Value(ID, VarType.INT, Precision.DM));
        } else {
            if (VarType.FLOAT.equals(variables.get(ID).type)){
                variables.put(ID, new Value(ID, VarType.INT, Precision.DM));
            }
        }
        LLVMGenerator.scantf_int(ID);
    }

    @Override
    public void exitAssignExpr(MantricoreParser.AssignExprContext ctx) {
        String ID = ctx.ID().getText();
        Value v = stack.pop();
        variables.put(ID, new Value(ID, v.type, v.precision));
        if (VarType.INT.equals(v.type)) {
            LLVMGenerator.declare_int(ID);
            LLVMGenerator.assign_int(ID, v.name);
        } else if (VarType.FLOAT.equals(v.type)) {
            LLVMGenerator.declare_float(ID, v.name, v.precision.toString());
            LLVMGenerator.assign_float(ID, v.name, v.precision.toString());
        } else {
            System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
        }
    }

    @Override
    public void exitExpression(MantricoreParser.ExpressionContext ctx) {
        super.exitExpression(ctx);
    }

    @Override
    public void exitNot(MantricoreParser.NotContext ctx) {
        Value v1 = stack.pop();
        if (VarType.INT.equals(v1.type)) {
            LLVMGenerator.not_int(v1.name);
            stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
        } else {
            error(ctx.getStart().getLine(), "and operattion type not handled.");
        }
    }

    @Override
    public void exitOr(MantricoreParser.OrContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        if (VarType.INT.equals(v1.type)) {
            LLVMGenerator.or_int(v1.name, v2.name);
            stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
        } else {
            error(ctx.getStart().getLine(), "or operattion type not handled.");
        }
    }

    @Override
    public void exitAnd(MantricoreParser.AndContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        if (VarType.INT.equals(v1.type)) {
            LLVMGenerator.and_int(v1.name, v2.name);
            stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
        } else {
            error(ctx.getStart().getLine(), "and operattion type not handled.");
        }
    }

    @Override
    public void exitLogical(MantricoreParser.LogicalContext ctx) {
        super.exitLogical(ctx);
    }

    @Override
    public void exitAdd(MantricoreParser.AddContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();

        if( v1.type == v2.type && v1.precision == v2.precision ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.add_int(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
            }
            if( v1.type == VarType.FLOAT ){
                LLVMGenerator.add_float(v1.name, v2.name, v1.precision.toString());
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.FLOAT, v1.precision) );
            }
        } else {
            error(ctx.getStart().getLine(), "add operattion type mismatch.");
        }
    }

    @Override
    public void exitSubt(MantricoreParser.SubtContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();

        if( v1.type == v2.type && v1.precision == v2.precision ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.sub_int(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
            }
            if( v1.type == VarType.FLOAT ){
                LLVMGenerator.sub_float(v1.name, v2.name, v1.precision.toString());
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.FLOAT, v1.precision) );
            }
        } else {
            error(ctx.getStart().getLine(), "add operattion type mismatch.");
        }
    }

    @Override
    public void exitArithmetic(MantricoreParser.ArithmeticContext ctx) {
        super.exitArithmetic(ctx);
    }

    @Override
    public void exitTermVal(MantricoreParser.TermValContext ctx) {
        super.exitTermVal(ctx);
    }
    @Override
    public void exitDiv(MantricoreParser.DivContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();

        if( v1.type == v2.type && v1.precision == v2.precision ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.div_int(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
            }
            if( v1.type == VarType.FLOAT ){
                LLVMGenerator.div_float(v1.name, v2.name, v1.precision.toString());
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.FLOAT, v1.precision) );
            }
        } else {
            error(ctx.getStart().getLine(), "add operattion type mismatch.");
        }
    }

    @Override
    public void exitMult(MantricoreParser.MultContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();

        if( v1.type == v2.type && v1.precision == v2.precision ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.mult_int(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
            }
            if( v1.type == VarType.FLOAT ){
                LLVMGenerator.mult_float(v1.name, v2.name, v1.precision.toString());
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.FLOAT, v1.precision) );
            }
        } else {
            error(ctx.getStart().getLine(), "add operattion type mismatch.");
        }
    }

    @Override
    public void exitComp(MantricoreParser.CompContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();

        if( v1.type == v2.type && v1.precision == v2.precision ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.comp_int(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT, Precision.DM) );
            }
            if( v1.type == VarType.FLOAT ){
                LLVMGenerator.comp_float(v1.name, v2.name, v1.precision.toString());
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.FLOAT, v1.precision) );
            }
        } else {
            error(ctx.getStart().getLine(), "add operattion type mismatch.");
        }
    }


    @Override
    public void exitId(MantricoreParser.IdContext ctx) {
        super.exitId(ctx);
    }


    @Override
    public void exitNumber(MantricoreParser.NumberContext ctx) {
        VarType type = ctx.NUMBER().getText().contains(".") ? VarType.FLOAT : VarType.INT;
        Precision precision = Precision.DM;
        if (VarType.FLOAT.equals(type)) {
            precision = ctx.NUMBER().getText().contains("f") ? Precision.FLOAT32 : Precision.FLOAT64;
        }
        stack.push( new Value(ctx.NUMBER().getText(), type, precision) );
    }

    @Override
    public void enterString(MantricoreParser.StringContext ctx) {
        super.enterString(ctx);
    }

    @Override
    public void exitString(MantricoreParser.StringContext ctx) {
        super.exitString(ctx);
    }

    @Override
    public void enterArrayVal(MantricoreParser.ArrayValContext ctx) {
        super.enterArrayVal(ctx);
    }

    @Override
    public void exitArrayVal(MantricoreParser.ArrayValContext ctx) {
        super.exitArrayVal(ctx);
    }

    @Override
    public void enterMatrixVal(MantricoreParser.MatrixValContext ctx) {
        super.enterMatrixVal(ctx);
    }

    @Override
    public void exitMatrixVal(MantricoreParser.MatrixValContext ctx) {
        super.exitMatrixVal(ctx);
    }

    @Override
    public void enterBtrue(MantricoreParser.BtrueContext ctx) {
        super.enterBtrue(ctx);
    }

    @Override
    public void exitBtrue(MantricoreParser.BtrueContext ctx) {
        super.exitBtrue(ctx);
    }

    @Override
    public void enterBfals(MantricoreParser.BfalsContext ctx) {
        super.enterBfals(ctx);
    }

    @Override
    public void exitBfals(MantricoreParser.BfalsContext ctx) {
        super.exitBfals(ctx);
    }

    @Override
    public void enterArray(MantricoreParser.ArrayContext ctx) {
        super.enterArray(ctx);
    }

    @Override
    public void exitArray(MantricoreParser.ArrayContext ctx) {
        super.exitArray(ctx);
    }

    @Override
    public void enterMatrix(MantricoreParser.MatrixContext ctx) {
        super.enterMatrix(ctx);
    }

    @Override
    public void exitMatrix(MantricoreParser.MatrixContext ctx) {
        super.exitMatrix(ctx);
    }

    @Override
    public void enterMatrixRow(MantricoreParser.MatrixRowContext ctx) {
        super.enterMatrixRow(ctx);
    }

    @Override
    public void exitMatrixRow(MantricoreParser.MatrixRowContext ctx) {
        super.exitMatrixRow(ctx);
    }

    @Override
    public void enterExpressionList(MantricoreParser.ExpressionListContext ctx) {
        super.enterExpressionList(ctx);
    }

    @Override
    public void exitExpressionList(MantricoreParser.ExpressionListContext ctx) {
        super.exitExpressionList(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }
}