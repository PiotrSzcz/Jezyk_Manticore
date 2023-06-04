import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

enum VarType{ INT, FLOAT }

enum Precision{FLOAT32, FLOAT64, DM}

class Value {
    public String name;
    public VarType type;
    public Precision precision;
    public Value( String name, VarType type, Precision precision ){
        this.name = name;
        this.type = type;
        this.precision = precision;
    }
    public Precision getPrecision() {
        return precision;
    }
    public VarType getType() {
        return type;
    }
}

class Structure {
    public String name;
    public String type;
    public List<Value> listOFValues;
    public Structure (String name, String type, List<Value> listOFValues) {
        this.name = name;
        this.type = type;
        this.listOFValues = listOFValues;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public List<Value> getListOFValues() {
        return listOFValues;
    }
}

class Classes extends Structure {
    public List<String> listOfFunctions;
    public Classes(String name, String type, List<Value> listOFValues, List<String> listOfFunctions) {
        super(name, type, listOFValues);
        this.listOfFunctions = listOfFunctions;
    }
    public List<String> getListOfFunctions() {
        return listOfFunctions;
    }
}

public class LLVMActions extends MantricoreBaseListener {

    private final String parameter;

    public LLVMActions(String outputFileName) {
        this.parameter = outputFileName;
    }

    HashMap<String, Value> variables = new HashMap<String, Value>();
    HashMap<String, List<Value>> structuresDeclaration = new HashMap<String, List<Value>>();
    HashMap<String, List<Value>> classDeclaration = new HashMap<String, List<Value>>();
    HashMap<String, Structure> structures = new HashMap<String, Structure>();
    HashMap<String, Classes> classes = new HashMap<String, Classes>();
    Stack<Value> stack = new Stack<Value>();

    Stack<Value> strucStack = new Stack<Value>();
    Boolean enteredStuc = false;
    HashSet<String> functions = new HashSet<String>();
    HashSet<String> localnames = new HashSet<String>();
    HashSet<String> globalnames = new HashSet<String>();
    String logicalVal,function;
    Boolean global = true;

    void error(int line, String msg){
        System.err.println("Error, line "+line+", "+msg);
        System.exit(1);
    }

    @Override
    public void enterStart(MantricoreParser.StartContext ctx) {
        global = true;
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
    public void exitBlock(MantricoreParser.BlockContext ctx) {
        if (ctx.getParent() instanceof MantricoreParser.LoopContext) {
            LLVMGenerator.repeatend();
            global = true;
        } else if (ctx.getParent() instanceof MantricoreParser.FunctionContext) {
            LLVMGenerator.function_end();
            global = true;
        } else if (ctx.getParent() instanceof MantricoreParser.IfContext) {
            LLVMGenerator.ifend();
            global = true;
        }
    }

    @Override
    public void enterIf(MantricoreParser.IfContext ctx) {
        global = true;
    }

    @Override
    public void exitPrintId(MantricoreParser.PrintIdContext ctx) {
        String ID = ctx.ID().getText();
        VarType type = variables.get(ID).type;
        if (!global || globalnames.contains(ID)) {
            if (VarType.INT.equals(type)) {
                LLVMGenerator.printf_int(ID, globalnames);
            } else if (VarType.FLOAT.equals(type)) {
                LLVMGenerator.printf_float(ID, variables.get(ID).precision.toString(), globalnames);
            } else {
                ctx.getStart().getLine();
                System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
            }
        } else {
            System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
        }
    }

    @Override
    public void exitPrintExp(MantricoreParser.PrintExpContext ctx) {
        super.exitPrintExp(ctx);
    }

    @Override
    public void exitPrintStruc(MantricoreParser.PrintStrucContext ctx) {
        String ID = ctx.ID().getText();
        if (structures.containsKey(ID)) {
            Structure structure = structures.get(ID);
            LLVMGenerator.print_struc(structure.type, structure.name, structure.listOFValues);
        } else {
            System.err.println("Line "+ ctx.getStart().getLine()+", unknown structure: "+ID);
        }

    }

    @Override
    public void exitReadId(MantricoreParser.ReadIdContext ctx) {
        String ID = ctx.ID().getText();

        if (!( variables.containsKey(ID))){
            LLVMGenerator.declare_int(ID, global);
            variables.put(ID, new Value(ID, VarType.INT, Precision.DM));
        } else {
            if (VarType.FLOAT.equals(variables.get(ID).type)){
                variables.put(ID, new Value(ID, VarType.INT, Precision.DM));
            }
        }
        LLVMGenerator.scantf_int(ID, globalnames);
    }

    @Override
    public void exitAssignExpr(MantricoreParser.AssignExprContext ctx) {
        String ID = ctx.ID().getText();
        Value v = stack.pop();
        variables.put(ID, new Value(ID, v.type, v.precision));
        if (VarType.INT.equals(v.type)) {
            LLVMGenerator.declare_int(ID, global);
            if (global) {
                globalnames.add(ID);
            } else if (!globalnames.contains(ID)) {
                localnames.add(ID);
            }
            LLVMGenerator.assign_int(ID, v.name, globalnames);
        } else if (VarType.FLOAT.equals(v.type)) {
            LLVMGenerator.declare_float(ID, v.precision.toString(), global);
            if (global) {
                globalnames.add(ID);
            } else if (!globalnames.contains(ID)) {
                localnames.add(ID);
            }
            LLVMGenerator.assign_float(ID, v.name, v.precision.toString(), globalnames);
        } else {
            System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
        }
    }

    @Override
    public void enterStructure(MantricoreParser.StructureContext ctx) {
        enteredStuc= true;
    }

    @Override
    public void exitStructure(MantricoreParser.StructureContext ctx) {
        String name = ctx.ID().toString();
        enteredStuc= false;
        List<Value> listOfValues = getValuesFromStrucStack();
        List<String> listOfTypes = listOfValues.stream()
                .map(Value::getPrecision)
                .map(Objects::toString)
                .map(value -> {
                    return switch (value) {
                        case "DM" -> "i32";
                        case "FLOAT32" -> "float";
                        case "FLOAT64" -> "double";
                        default -> throw new IllegalStateException("Unexpected value: " + value);
                    };
                })
                .map(Objects::toString)
                .collect(Collectors.toList());
        LLVMGenerator.declare_struc(name, listOfTypes);
        structuresDeclaration.put(name, listOfValues);
    }

    private List<Value> getValuesFromStrucStack() {
        List<Value> lista = new ArrayList<>();
        while (!strucStack.isEmpty()) {
            lista.add(strucStack.pop());
        }
        Collections.reverse(lista);
        return lista;
    }

    @Override
    public void enterStrucAssign(MantricoreParser.StrucAssignContext ctx) {
        enteredStuc= true;
    }

    @Override
    public void exitStrucAssign(MantricoreParser.StrucAssignContext ctx) {
        String name = ctx.ID(1).toString();
        String type = ctx.ID(0).toString();
        enteredStuc= false;
        List<Value> listOfValues = getValuesFromStrucStack();
        if (structuresDeclaration.containsKey(type)) {
            List<Value> listOfTypes = structuresDeclaration.get(type);
            boolean areListsEqual = listOfValues.stream()
                    .allMatch(value1 -> listOfTypes.stream()
                            .anyMatch(value2 -> value1.getType().equals(value2.getType()) && value1.getPrecision().equals(value2.getPrecision())));
            if (areListsEqual) {
                LLVMGenerator.assign_struc(type, name, listOfValues);
                structures.put(name, new Structure(name, type, listOfValues));
            } else {
                error(ctx.getStart().getLine(), "structure type mismatch.");
            }
        } else {
            error(ctx.getStart().getLine(), "structure name not recognized");
        }
    }

    @Override
    public void enterClassDeclaration(MantricoreParser.ClassDeclarationContext ctx) {
        enteredStuc= true;
    }

    @Override
    public void exitClassDeclaration(MantricoreParser.ClassDeclarationContext ctx) {
        String name = ctx.ID().toString();
        enteredStuc= false;
        List<Value> listOfValues = getValuesFromStrucStack();
        List<String> listOfTypes = listOfValues.stream()
                .map(Value::getPrecision)
                .map(Objects::toString)
                .map(value -> {
                    return switch (value) {
                        case "DM" -> "i32";
                        case "FLOAT32" -> "float";
                        case "FLOAT64" -> "double";
                        default -> throw new IllegalStateException("Unexpected value: " + value);
                    };
                })
                .map(Objects::toString)
                .collect(Collectors.toList());
        LLVMGenerator.declare_class(name, listOfTypes);
        classDeclaration.put(name, listOfValues);
    }

    @Override
    public void enterClassAssign(MantricoreParser.ClassAssignContext ctx) {
        enteredStuc= true;
    }

    @Override
    public void exitClassAssign(MantricoreParser.ClassAssignContext ctx) {
        String name = ctx.ID(1).toString();
        String type = ctx.ID(0).toString();
        enteredStuc= false;
        List<Value> listOfValues = getValuesFromStrucStack();
        if (classDeclaration.containsKey(type)) {
            List<Value> listOfTypes = classDeclaration.get(type);
            boolean areListsEqual = listOfValues.stream()
                    .allMatch(value1 -> listOfTypes.stream()
                            .anyMatch(value2 -> value1.getType().equals(value2.getType()) && value1.getPrecision().equals(value2.getPrecision())));
            if (areListsEqual) {
                LLVMGenerator.assign_class(name, type, listOfValues);
                List<String> list = List.of();
                classes.put(name, new Classes(name, type, listOfValues, list));
            } else {
                error(ctx.getStart().getLine(), "structure type mismatch.");
            }
        } else {
            error(ctx.getStart().getLine(), "structure name not recognized");
        }
    }

    @Override
    public void exitFuCall(MantricoreParser.FuCallContext ctx) {
        String ID = ctx.ID().getText();
        LLVMGenerator.call(ID);
    }

    @Override
    public void exitIf(MantricoreParser.IfContext ctx) {
        super.exitIf(ctx);
    }

    @Override
    public void exitExpression(MantricoreParser.ExpressionContext ctx) {
        if (enteredStuc) {
            strucStack.push(stack.pop());
        }
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
    public void enterFunction(MantricoreParser.FunctionContext ctx) {
        global = false;
        function = ctx.ID().getText();
        functions.add(function);
        LLVMGenerator.function_start(function);
    }

    @Override
    public void exitFunction(MantricoreParser.FunctionContext ctx) {
        super.exitFunction(ctx);
    }

    @Override
    public void exitLoopParam(MantricoreParser.LoopParamContext ctx) {
        global = false;
        if (stack.empty()) {
            error(ctx.getStart().getLine(), "loop param can not be handled");
        }
        Value value = stack.pop();
        if (VarType.INT.equals(value.type)) {
            LLVMGenerator.repeatstart(value.name);
        } else {
            error(ctx.getStart().getLine(), "loop param can't be FLOAT type");
        }

    }

    @Override
    public void exitIfParam(MantricoreParser.IfParamContext ctx) {
        Value poped = stack.pop();
        stack.push(poped);

        if (VarType.INT.equals(poped.type)) {
            LLVMGenerator.int_to_i1(poped.name);
        } else if (VarType.FLOAT.equals(poped.type)) {
            error(ctx.getStart().getLine(), "if statment param can't be FLOAT type");
        }
        global = true;
        LLVMGenerator.ifstart();
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