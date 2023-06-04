// Generated from .\gramatyka\Mantricore.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MantricoreParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, CLASS=15, IF=16, LOOP=17, 
		FUNCTION=18, STRUC=19, BEGIN=20, END=21, ASSIGN=22, ADD=23, SUBTRACT=24, 
		MULT=25, DIVIDE=26, PRINT=27, READ=28, NUMBER=29, INT=30, FLOAT=31, FLOAT32=32, 
		FLOAT64=33, STRING=34, ID=35, NEWLINE=36, WS=37;
	public static final int
		RULE_start = 0, RULE_block = 1, RULE_program = 2, RULE_expression = 3, 
		RULE_logicalExpression = 4, RULE_arithmeticExpression = 5, RULE_term = 6, 
		RULE_value = 7, RULE_function = 8, RULE_classfunc = 9, RULE_loopParam = 10, 
		RULE_ifParam = 11, RULE_array = 12, RULE_matrix = 13, RULE_matrixRow = 14, 
		RULE_expressionList = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "block", "program", "expression", "logicalExpression", "arithmeticExpression", 
			"term", "value", "function", "classfunc", "loopParam", "ifParam", "array", 
			"matrix", "matrixRow", "expressionList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'()'", "'&&'", "'||'", "'=='", "'!'", "'true'", 
			"'false'", "'array'", "'['", "']'", "'matrix'", "','", "'class'", "'whatif'", 
			"'repeat'", "'fthis'", "'struc'", "'{'", "'}'", "'='", "'+'", "'-'", 
			"'*'", "'/'", "'print'", "'read'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "CLASS", "IF", "LOOP", "FUNCTION", "STRUC", "BEGIN", 
			"END", "ASSIGN", "ADD", "SUBTRACT", "MULT", "DIVIDE", "PRINT", "READ", 
			"NUMBER", "INT", "FLOAT", "FLOAT32", "FLOAT64", "STRING", "ID", "NEWLINE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mantricore.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MantricoreParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MantricoreParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(MantricoreParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MantricoreParser.NEWLINE, i);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<ClassfuncContext> classfunc() {
			return getRuleContexts(ClassfuncContext.class);
		}
		public ClassfuncContext classfunc(int i) {
			return getRuleContext(ClassfuncContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103482884096L) != 0)) {
				{
				{
				setState(35);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(32);
					program();
					}
					break;
				case 2:
					{
					setState(33);
					function();
					}
					break;
				case 3:
					{
					setState(34);
					classfunc();
					}
					break;
				}
				setState(37);
				match(NEWLINE);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(MantricoreParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MantricoreParser.NEWLINE, i);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103482621952L) != 0)) {
				{
				{
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34763145216L) != 0)) {
					{
					setState(45);
					program();
					}
				}

				setState(48);
				match(NEWLINE);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassAssignContext extends ProgramContext {
		public List<TerminalNode> ID() { return getTokens(MantricoreParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MantricoreParser.ID, i);
		}
		public TerminalNode CLASS() { return getToken(MantricoreParser.CLASS, 0); }
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ClassAssignContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterClassAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitClassAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintExpContext extends ProgramContext {
		public TerminalNode PRINT() { return getToken(MantricoreParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintExpContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterPrintExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitPrintExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StrucAssignContext extends ProgramContext {
		public List<TerminalNode> ID() { return getTokens(MantricoreParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MantricoreParser.ID, i);
		}
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StrucAssignContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterStrucAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitStrucAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStrucContext extends ProgramContext {
		public TerminalNode PRINT() { return getToken(MantricoreParser.PRINT, 0); }
		public TerminalNode STRUC() { return getToken(MantricoreParser.STRUC, 0); }
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public PrintStrucContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterPrintStruc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitPrintStruc(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructureContext extends ProgramContext {
		public TerminalNode STRUC() { return getToken(MantricoreParser.STRUC, 0); }
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StructureContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitStructure(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ProgramContext {
		public TerminalNode CLASS() { return getToken(MantricoreParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ClassDeclarationContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitClassDeclaration(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuCallContext extends ProgramContext {
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public FuCallContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterFuCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitFuCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadIdContext extends ProgramContext {
		public TerminalNode READ() { return getToken(MantricoreParser.READ, 0); }
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public ReadIdContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterReadId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitReadId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintIdContext extends ProgramContext {
		public TerminalNode PRINT() { return getToken(MantricoreParser.PRINT, 0); }
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public PrintIdContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterPrintId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitPrintId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ProgramContext {
		public TerminalNode LOOP() { return getToken(MantricoreParser.LOOP, 0); }
		public LoopParamContext loopParam() {
			return getRuleContext(LoopParamContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public LoopContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitLoop(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassFuCallContext extends ProgramContext {
		public List<TerminalNode> ID() { return getTokens(MantricoreParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MantricoreParser.ID, i);
		}
		public ClassFuCallContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterClassFuCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitClassFuCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ProgramContext {
		public TerminalNode IF() { return getToken(MantricoreParser.IF, 0); }
		public IfParamContext ifParam() {
			return getRuleContext(IfParamContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public IfContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitIf(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignExprContext extends ProgramContext {
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MantricoreParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignExprContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitAssignExpr(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(IF);
				setState(55);
				match(T__0);
				setState(56);
				ifParam();
				setState(57);
				match(T__1);
				setState(58);
				match(BEGIN);
				setState(59);
				block();
				setState(60);
				match(END);
				}
				break;
			case 2:
				_localctx = new LoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(LOOP);
				setState(63);
				match(T__0);
				setState(64);
				loopParam();
				setState(65);
				match(T__1);
				setState(66);
				match(BEGIN);
				setState(67);
				block();
				setState(68);
				match(END);
				}
				break;
			case 3:
				_localctx = new FuCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				match(ID);
				setState(71);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new ClassFuCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				match(ID);
				setState(73);
				match(ID);
				setState(74);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new PrintIdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				match(PRINT);
				setState(76);
				match(T__0);
				setState(77);
				match(ID);
				setState(78);
				match(T__1);
				}
				break;
			case 6:
				_localctx = new PrintExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				match(PRINT);
				setState(80);
				match(T__0);
				setState(81);
				expression();
				setState(82);
				match(T__1);
				}
				break;
			case 7:
				_localctx = new PrintStrucContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				match(PRINT);
				setState(85);
				match(T__0);
				setState(86);
				match(STRUC);
				setState(87);
				match(ID);
				setState(88);
				match(T__1);
				}
				break;
			case 8:
				_localctx = new ReadIdContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(89);
				match(READ);
				setState(90);
				match(T__0);
				setState(91);
				match(ID);
				setState(92);
				match(T__1);
				}
				break;
			case 9:
				_localctx = new AssignExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(93);
				match(ID);
				setState(94);
				match(ASSIGN);
				setState(95);
				expression();
				}
				break;
			case 10:
				_localctx = new StructureContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(96);
				match(STRUC);
				setState(97);
				match(ID);
				setState(98);
				match(BEGIN);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52076488576L) != 0)) {
					{
					{
					setState(99);
					expression();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(END);
				}
				break;
			case 11:
				_localctx = new StrucAssignContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(106);
				match(ID);
				setState(107);
				match(ID);
				setState(108);
				match(BEGIN);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52076488576L) != 0)) {
					{
					{
					setState(109);
					expression();
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(115);
				match(END);
				}
				break;
			case 12:
				_localctx = new ClassDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(116);
				match(CLASS);
				setState(117);
				match(ID);
				setState(118);
				match(BEGIN);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52076488576L) != 0)) {
					{
					{
					setState(119);
					expression();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(END);
				}
				break;
			case 13:
				_localctx = new ClassAssignContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(126);
				match(ID);
				setState(127);
				match(ID);
				setState(128);
				match(CLASS);
				setState(129);
				match(BEGIN);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52076488576L) != 0)) {
					{
					{
					setState(130);
					expression();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(END);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			logicalExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
	 
		public LogicalExpressionContext() { }
		public void copyFrom(LogicalExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompContext extends LogicalExpressionContext {
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public CompContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitComp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends LogicalExpressionContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public NotContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends LogicalExpressionContext {
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public OrContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitOr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends LogicalExpressionContext {
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public AndContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitAnd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends LogicalExpressionContext {
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public LogicalContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitLogical(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		return logicalExpression(0);
	}

	private LogicalExpressionContext logicalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, _parentState);
		LogicalExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_logicalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
			case T__9:
			case T__12:
			case NUMBER:
			case STRING:
			case ID:
				{
				_localctx = new LogicalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(142);
				arithmeticExpression(0);
				}
				break;
			case T__6:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(T__6);
				setState(144);
				logicalExpression(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new LogicalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(147);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(148);
						match(T__3);
						setState(149);
						logicalExpression(5);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new LogicalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(150);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(151);
						match(T__4);
						setState(152);
						logicalExpression(4);
						}
						break;
					case 3:
						{
						_localctx = new CompContext(new LogicalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(153);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(154);
						match(T__5);
						setState(155);
						logicalExpression(3);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
	 
		public ArithmeticExpressionContext() { }
		public void copyFrom(ArithmeticExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends ArithmeticExpressionContext {
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(MantricoreParser.ADD, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AddContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitAdd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtContext extends ArithmeticExpressionContext {
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode SUBTRACT() { return getToken(MantricoreParser.SUBTRACT, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SubtContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterSubt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitSubt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticContext extends ArithmeticExpressionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ArithmeticContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitArithmetic(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		return arithmeticExpression(0);
	}

	private ArithmeticExpressionContext arithmeticExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, _parentState);
		ArithmeticExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_arithmeticExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArithmeticContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(162);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new AddContext(new ArithmeticExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						match(ADD);
						setState(166);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new SubtContext(new ArithmeticExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(167);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(168);
						match(SUBTRACT);
						setState(169);
						term(0);
						}
						break;
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TermValContext extends TermContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TermValContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterTermVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitTermVal(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode DIVIDE() { return getToken(MantricoreParser.DIVIDE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DivContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitDiv(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULT() { return getToken(MantricoreParser.MULT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MultContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitMult(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TermValContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(176);
			value();
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(178);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(179);
						match(MULT);
						setState(180);
						value();
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(181);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(182);
						match(DIVIDE);
						setState(183);
						value();
						}
						break;
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatrixValContext extends ValueContext {
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public MatrixValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterMatrixVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitMatrixVal(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BfalsContext extends ValueContext {
		public BfalsContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterBfals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitBfals(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(MantricoreParser.NUMBER, 0); }
		public NumberContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ValueContext {
		public TerminalNode STRING() { return getToken(MantricoreParser.STRING, 0); }
		public StringContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValContext extends ValueContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterArrayVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitArrayVal(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ValueContext {
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public IdContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BtrueContext extends ValueContext {
		public BtrueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterBtrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitBtrue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(ID);
				}
				break;
			case NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(STRING);
				}
				break;
			case T__9:
				_localctx = new ArrayValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				array();
				}
				break;
			case T__12:
				_localctx = new MatrixValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				matrix();
				}
				break;
			case T__7:
				_localctx = new BtrueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new BfalsContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(195);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MantricoreParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(MantricoreParser.ID, 0); }
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(FUNCTION);
			setState(199);
			match(ID);
			setState(200);
			match(T__2);
			setState(201);
			match(BEGIN);
			setState(202);
			block();
			setState(203);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassfuncContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MantricoreParser.FUNCTION, 0); }
		public List<TerminalNode> ID() { return getTokens(MantricoreParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MantricoreParser.ID, i);
		}
		public TerminalNode BEGIN() { return getToken(MantricoreParser.BEGIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(MantricoreParser.END, 0); }
		public ClassfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classfunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterClassfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitClassfunc(this);
		}
	}

	public final ClassfuncContext classfunc() throws RecognitionException {
		ClassfuncContext _localctx = new ClassfuncContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classfunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(FUNCTION);
			setState(206);
			match(ID);
			setState(207);
			match(T__0);
			setState(208);
			match(ID);
			setState(209);
			match(T__1);
			setState(210);
			match(BEGIN);
			setState(211);
			block();
			setState(212);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopParamContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterLoopParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitLoopParam(this);
		}
	}

	public final LoopParamContext loopParam() throws RecognitionException {
		LoopParamContext _localctx = new LoopParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loopParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfParamContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public IfParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterIfParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitIfParam(this);
		}
	}

	public final IfParamContext ifParam() throws RecognitionException {
		IfParamContext _localctx = new IfParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			logicalExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__9);
			setState(219);
			match(T__10);
			setState(220);
			expressionList();
			setState(221);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatrixContext extends ParserRuleContext {
		public List<MatrixRowContext> matrixRow() {
			return getRuleContexts(MatrixRowContext.class);
		}
		public MatrixRowContext matrixRow(int i) {
			return getRuleContext(MatrixRowContext.class,i);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitMatrix(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__12);
			setState(224);
			match(T__10);
			setState(225);
			matrixRow();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(226);
				match(T__13);
				setState(227);
				matrixRow();
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatrixRowContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MatrixRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixRow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterMatrixRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitMatrixRow(this);
		}
	}

	public final MatrixRowContext matrixRow() throws RecognitionException {
		MatrixRowContext _localctx = new MatrixRowContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_matrixRow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__10);
			setState(236);
			expressionList();
			setState(237);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MantricoreListener ) ((MantricoreListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			value();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(240);
				match(T__13);
				setState(241);
				value();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return logicalExpression_sempred((LogicalExpressionContext)_localctx, predIndex);
		case 5:
			return arithmeticExpression_sempred((ArithmeticExpressionContext)_localctx, predIndex);
		case 6:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicalExpression_sempred(LogicalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arithmeticExpression_sempred(ArithmeticExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000$\b\u0000\u0001\u0000"+
		"\u0005\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0001\u0005\u00012\b\u0001\n\u0001"+
		"\f\u00015\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002e\b\u0002\n\u0002\f\u0002h\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002o\b\u0002\n\u0002\f\u0002r\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002y\b\u0002\n\u0002\f\u0002|\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0084\b\u0002\n"+
		"\u0002\f\u0002\u0087\t\u0002\u0001\u0002\u0003\u0002\u008a\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u0092\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u009d"+
		"\b\u0004\n\u0004\f\u0004\u00a0\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u00ab\b\u0005\n\u0005\f\u0005\u00ae\t\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u00b9\b\u0006\n\u0006\f\u0006\u00bc\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00c5\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00e5\b\r\n\r\f\r\u00e8\t\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u00f3\b\u000f\n\u000f\f\u000f\u00f6\t\u000f\u0001\u000f\u0000\u0003"+
		"\b\n\f\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e\u0000\u0000\u010d\u0000(\u0001\u0000\u0000\u0000"+
		"\u00023\u0001\u0000\u0000\u0000\u0004\u0089\u0001\u0000\u0000\u0000\u0006"+
		"\u008b\u0001\u0000\u0000\u0000\b\u0091\u0001\u0000\u0000\u0000\n\u00a1"+
		"\u0001\u0000\u0000\u0000\f\u00af\u0001\u0000\u0000\u0000\u000e\u00c4\u0001"+
		"\u0000\u0000\u0000\u0010\u00c6\u0001\u0000\u0000\u0000\u0012\u00cd\u0001"+
		"\u0000\u0000\u0000\u0014\u00d6\u0001\u0000\u0000\u0000\u0016\u00d8\u0001"+
		"\u0000\u0000\u0000\u0018\u00da\u0001\u0000\u0000\u0000\u001a\u00df\u0001"+
		"\u0000\u0000\u0000\u001c\u00eb\u0001\u0000\u0000\u0000\u001e\u00ef\u0001"+
		"\u0000\u0000\u0000 $\u0003\u0004\u0002\u0000!$\u0003\u0010\b\u0000\"$"+
		"\u0003\u0012\t\u0000# \u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000"+
		"#\"\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%\'\u0005$\u0000\u0000&#\u0001\u0000\u0000\u0000\'*\u0001\u0000"+
		"\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)+\u0001"+
		"\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000+,\u0005\u0000\u0000\u0001"+
		",\u0001\u0001\u0000\u0000\u0000-/\u0003\u0004\u0002\u0000.-\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0005"+
		"$\u0000\u00001.\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u00004\u0003\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000067\u0005\u0010\u0000\u000078\u0005\u0001"+
		"\u0000\u000089\u0003\u0016\u000b\u00009:\u0005\u0002\u0000\u0000:;\u0005"+
		"\u0014\u0000\u0000;<\u0003\u0002\u0001\u0000<=\u0005\u0015\u0000\u0000"+
		"=\u008a\u0001\u0000\u0000\u0000>?\u0005\u0011\u0000\u0000?@\u0005\u0001"+
		"\u0000\u0000@A\u0003\u0014\n\u0000AB\u0005\u0002\u0000\u0000BC\u0005\u0014"+
		"\u0000\u0000CD\u0003\u0002\u0001\u0000DE\u0005\u0015\u0000\u0000E\u008a"+
		"\u0001\u0000\u0000\u0000FG\u0005#\u0000\u0000G\u008a\u0005\u0003\u0000"+
		"\u0000HI\u0005#\u0000\u0000IJ\u0005#\u0000\u0000J\u008a\u0005\u0003\u0000"+
		"\u0000KL\u0005\u001b\u0000\u0000LM\u0005\u0001\u0000\u0000MN\u0005#\u0000"+
		"\u0000N\u008a\u0005\u0002\u0000\u0000OP\u0005\u001b\u0000\u0000PQ\u0005"+
		"\u0001\u0000\u0000QR\u0003\u0006\u0003\u0000RS\u0005\u0002\u0000\u0000"+
		"S\u008a\u0001\u0000\u0000\u0000TU\u0005\u001b\u0000\u0000UV\u0005\u0001"+
		"\u0000\u0000VW\u0005\u0013\u0000\u0000WX\u0005#\u0000\u0000X\u008a\u0005"+
		"\u0002\u0000\u0000YZ\u0005\u001c\u0000\u0000Z[\u0005\u0001\u0000\u0000"+
		"[\\\u0005#\u0000\u0000\\\u008a\u0005\u0002\u0000\u0000]^\u0005#\u0000"+
		"\u0000^_\u0005\u0016\u0000\u0000_\u008a\u0003\u0006\u0003\u0000`a\u0005"+
		"\u0013\u0000\u0000ab\u0005#\u0000\u0000bf\u0005\u0014\u0000\u0000ce\u0003"+
		"\u0006\u0003\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000i\u008a\u0005\u0015\u0000\u0000jk\u0005"+
		"#\u0000\u0000kl\u0005#\u0000\u0000lp\u0005\u0014\u0000\u0000mo\u0003\u0006"+
		"\u0003\u0000nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000s\u008a\u0005\u0015\u0000\u0000tu\u0005\u000f"+
		"\u0000\u0000uv\u0005#\u0000\u0000vz\u0005\u0014\u0000\u0000wy\u0003\u0006"+
		"\u0003\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000}\u008a\u0005\u0015\u0000\u0000~\u007f\u0005"+
		"#\u0000\u0000\u007f\u0080\u0005#\u0000\u0000\u0080\u0081\u0005\u000f\u0000"+
		"\u0000\u0081\u0085\u0005\u0014\u0000\u0000\u0082\u0084\u0003\u0006\u0003"+
		"\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000"+
		"\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0005\u0015\u0000\u0000\u00896\u0001\u0000\u0000\u0000"+
		"\u0089>\u0001\u0000\u0000\u0000\u0089F\u0001\u0000\u0000\u0000\u0089H"+
		"\u0001\u0000\u0000\u0000\u0089K\u0001\u0000\u0000\u0000\u0089O\u0001\u0000"+
		"\u0000\u0000\u0089T\u0001\u0000\u0000\u0000\u0089Y\u0001\u0000\u0000\u0000"+
		"\u0089]\u0001\u0000\u0000\u0000\u0089`\u0001\u0000\u0000\u0000\u0089j"+
		"\u0001\u0000\u0000\u0000\u0089t\u0001\u0000\u0000\u0000\u0089~\u0001\u0000"+
		"\u0000\u0000\u008a\u0005\u0001\u0000\u0000\u0000\u008b\u008c\u0003\b\u0004"+
		"\u0000\u008c\u0007\u0001\u0000\u0000\u0000\u008d\u008e\u0006\u0004\uffff"+
		"\uffff\u0000\u008e\u0092\u0003\n\u0005\u0000\u008f\u0090\u0005\u0007\u0000"+
		"\u0000\u0090\u0092\u0003\b\u0004\u0001\u0091\u008d\u0001\u0000\u0000\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u009e\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\n\u0004\u0000\u0000\u0094\u0095\u0005\u0004\u0000\u0000\u0095"+
		"\u009d\u0003\b\u0004\u0005\u0096\u0097\n\u0003\u0000\u0000\u0097\u0098"+
		"\u0005\u0005\u0000\u0000\u0098\u009d\u0003\b\u0004\u0004\u0099\u009a\n"+
		"\u0002\u0000\u0000\u009a\u009b\u0005\u0006\u0000\u0000\u009b\u009d\u0003"+
		"\b\u0004\u0003\u009c\u0093\u0001\u0000\u0000\u0000\u009c\u0096\u0001\u0000"+
		"\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000"+
		"\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000"+
		"\u0000\u0000\u009f\t\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0006\u0005\uffff\uffff\u0000\u00a2\u00a3\u0003\f\u0006"+
		"\u0000\u00a3\u00ac\u0001\u0000\u0000\u0000\u00a4\u00a5\n\u0002\u0000\u0000"+
		"\u00a5\u00a6\u0005\u0017\u0000\u0000\u00a6\u00ab\u0003\f\u0006\u0000\u00a7"+
		"\u00a8\n\u0001\u0000\u0000\u00a8\u00a9\u0005\u0018\u0000\u0000\u00a9\u00ab"+
		"\u0003\f\u0006\u0000\u00aa\u00a4\u0001\u0000\u0000\u0000\u00aa\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u000b\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b0\u0006"+
		"\u0006\uffff\uffff\u0000\u00b0\u00b1\u0003\u000e\u0007\u0000\u00b1\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\n\u0002\u0000\u0000\u00b3\u00b4\u0005"+
		"\u0019\u0000\u0000\u00b4\u00b9\u0003\u000e\u0007\u0000\u00b5\u00b6\n\u0001"+
		"\u0000\u0000\u00b6\u00b7\u0005\u001a\u0000\u0000\u00b7\u00b9\u0003\u000e"+
		"\u0007\u0000\u00b8\u00b2\u0001\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\r\u0001\u0000\u0000"+
		"\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c5\u0005#\u0000\u0000"+
		"\u00be\u00c5\u0005\u001d\u0000\u0000\u00bf\u00c5\u0005\"\u0000\u0000\u00c0"+
		"\u00c5\u0003\u0018\f\u0000\u00c1\u00c5\u0003\u001a\r\u0000\u00c2\u00c5"+
		"\u0005\b\u0000\u0000\u00c3\u00c5\u0005\t\u0000\u0000\u00c4\u00bd\u0001"+
		"\u0000\u0000\u0000\u00c4\u00be\u0001\u0000\u0000\u0000\u00c4\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c0\u0001\u0000\u0000\u0000\u00c4\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c5\u000f\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005"+
		"\u0012\u0000\u0000\u00c7\u00c8\u0005#\u0000\u0000\u00c8\u00c9\u0005\u0003"+
		"\u0000\u0000\u00c9\u00ca\u0005\u0014\u0000\u0000\u00ca\u00cb\u0003\u0002"+
		"\u0001\u0000\u00cb\u00cc\u0005\u0015\u0000\u0000\u00cc\u0011\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0005\u0012\u0000\u0000\u00ce\u00cf\u0005#\u0000"+
		"\u0000\u00cf\u00d0\u0005\u0001\u0000\u0000\u00d0\u00d1\u0005#\u0000\u0000"+
		"\u00d1\u00d2\u0005\u0002\u0000\u0000\u00d2\u00d3\u0005\u0014\u0000\u0000"+
		"\u00d3\u00d4\u0003\u0002\u0001\u0000\u00d4\u00d5\u0005\u0015\u0000\u0000"+
		"\u00d5\u0013\u0001\u0000\u0000\u0000\u00d6\u00d7\u0003\u0006\u0003\u0000"+
		"\u00d7\u0015\u0001\u0000\u0000\u0000\u00d8\u00d9\u0003\b\u0004\u0000\u00d9"+
		"\u0017\u0001\u0000\u0000\u0000\u00da\u00db\u0005\n\u0000\u0000\u00db\u00dc"+
		"\u0005\u000b\u0000\u0000\u00dc\u00dd\u0003\u001e\u000f\u0000\u00dd\u00de"+
		"\u0005\f\u0000\u0000\u00de\u0019\u0001\u0000\u0000\u0000\u00df\u00e0\u0005"+
		"\r\u0000\u0000\u00e0\u00e1\u0005\u000b\u0000\u0000\u00e1\u00e6\u0003\u001c"+
		"\u000e\u0000\u00e2\u00e3\u0005\u000e\u0000\u0000\u00e3\u00e5\u0003\u001c"+
		"\u000e\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0005\f\u0000\u0000\u00ea\u001b\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0005\u000b\u0000\u0000\u00ec\u00ed\u0003\u001e\u000f"+
		"\u0000\u00ed\u00ee\u0005\f\u0000\u0000\u00ee\u001d\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f4\u0003\u000e\u0007\u0000\u00f0\u00f1\u0005\u000e\u0000\u0000"+
		"\u00f1\u00f3\u0003\u000e\u0007\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u001f\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f4\u0001\u0000\u0000\u0000\u0013#(.3fpz\u0085\u0089\u0091\u009c"+
		"\u009e\u00aa\u00ac\u00b8\u00ba\u00c4\u00e6\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}