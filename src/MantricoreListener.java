// Generated from .\gramatyka\Mantricore.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MantricoreParser}.
 */
public interface MantricoreListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MantricoreParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MantricoreParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MantricoreParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MantricoreParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterIf(MantricoreParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitIf(MantricoreParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loop}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterLoop(MantricoreParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitLoop(MantricoreParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fuCall}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterFuCall(MantricoreParser.FuCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fuCall}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitFuCall(MantricoreParser.FuCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printId}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterPrintId(MantricoreParser.PrintIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printId}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitPrintId(MantricoreParser.PrintIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExp}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterPrintExp(MantricoreParser.PrintExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExp}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitPrintExp(MantricoreParser.PrintExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStruc}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterPrintStruc(MantricoreParser.PrintStrucContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStruc}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitPrintStruc(MantricoreParser.PrintStrucContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readId}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterReadId(MantricoreParser.ReadIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readId}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitReadId(MantricoreParser.ReadIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MantricoreParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MantricoreParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structure}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterStructure(MantricoreParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structure}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitStructure(MantricoreParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strucAssign}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void enterStrucAssign(MantricoreParser.StrucAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strucAssign}
	 * labeled alternative in {@link MantricoreParser#program}.
	 * @param ctx the parse tree
	 */
	void exitStrucAssign(MantricoreParser.StrucAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MantricoreParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MantricoreParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comp}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterComp(MantricoreParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comp}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitComp(MantricoreParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterNot(MantricoreParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitNot(MantricoreParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterOr(MantricoreParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitOr(MantricoreParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(MantricoreParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(MantricoreParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logical}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogical(MantricoreParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logical}
	 * labeled alternative in {@link MantricoreParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogical(MantricoreParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link MantricoreParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(MantricoreParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link MantricoreParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(MantricoreParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subt}
	 * labeled alternative in {@link MantricoreParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubt(MantricoreParser.SubtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subt}
	 * labeled alternative in {@link MantricoreParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubt(MantricoreParser.SubtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link MantricoreParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(MantricoreParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link MantricoreParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(MantricoreParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termVal}
	 * labeled alternative in {@link MantricoreParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermVal(MantricoreParser.TermValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termVal}
	 * labeled alternative in {@link MantricoreParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermVal(MantricoreParser.TermValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link MantricoreParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDiv(MantricoreParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link MantricoreParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDiv(MantricoreParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link MantricoreParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMult(MantricoreParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link MantricoreParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMult(MantricoreParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void enterId(MantricoreParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void exitId(MantricoreParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumber(MantricoreParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumber(MantricoreParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(MantricoreParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(MantricoreParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayVal}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void enterArrayVal(MantricoreParser.ArrayValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayVal}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void exitArrayVal(MantricoreParser.ArrayValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matrixVal}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void enterMatrixVal(MantricoreParser.MatrixValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matrixVal}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void exitMatrixVal(MantricoreParser.MatrixValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code btrue}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBtrue(MantricoreParser.BtrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code btrue}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBtrue(MantricoreParser.BtrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bfals}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBfals(MantricoreParser.BfalsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bfals}
	 * labeled alternative in {@link MantricoreParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBfals(MantricoreParser.BfalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MantricoreParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MantricoreParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#loopParam}.
	 * @param ctx the parse tree
	 */
	void enterLoopParam(MantricoreParser.LoopParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#loopParam}.
	 * @param ctx the parse tree
	 */
	void exitLoopParam(MantricoreParser.LoopParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#ifParam}.
	 * @param ctx the parse tree
	 */
	void enterIfParam(MantricoreParser.IfParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#ifParam}.
	 * @param ctx the parse tree
	 */
	void exitIfParam(MantricoreParser.IfParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(MantricoreParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(MantricoreParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(MantricoreParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(MantricoreParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#matrixRow}.
	 * @param ctx the parse tree
	 */
	void enterMatrixRow(MantricoreParser.MatrixRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#matrixRow}.
	 * @param ctx the parse tree
	 */
	void exitMatrixRow(MantricoreParser.MatrixRowContext ctx);
	/**
	 * Enter a parse tree produced by {@link MantricoreParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MantricoreParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MantricoreParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MantricoreParser.ExpressionListContext ctx);
}