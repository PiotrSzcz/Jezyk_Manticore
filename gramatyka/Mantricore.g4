grammar Mantricore;

start: ( (program|function)? NEWLINE )* EOF;

block: ( program? NEWLINE )*;

program:   IF '(' ifParam ')' BEGIN block END               #if
          | LOOP '(' loopParam ')' BEGIN block END          #loop
          | ID '()'                                         #fuCall
          | PRINT '(' ID ')'                                #printId
          | PRINT '(' expression ')'                        #printExp
          | PRINT '(' STRUC ID ')'                          #printStruc
          | READ '(' ID ')'                                 #readId
          | ID ASSIGN expression                            #assignExpr
          | STRUC ID BEGIN (expression)* END                #structure
          | ID ID BEGIN (expression)* END                   #strucAssign
          | CLASS ID BEGIN (expression)* END                #classDeclaration
          | ID ID CLASS BEGIN (expression)* END             #classAssign
;

expression: logicalExpression ;

logicalExpression: arithmeticExpression                         #logical
                 | logicalExpression '&&' logicalExpression     #and
                 | logicalExpression '||' logicalExpression     #or
                 | logicalExpression '==' logicalExpression     #comp
                 | '!' logicalExpression                        #not
;

arithmeticExpression: term                                      #arithmetic
                     | arithmeticExpression '+' term            #add
                     | arithmeticExpression '-' term            #subt
;

term: value             #termVal
     | term '*' value   #mult
     | term '/' value   #div
;

value: ID           #id
       | NUMBER     #number
       | STRING     #string
       | array      #arrayVal
       | matrix     #matrixVal
       | 'true'     #btrue
       | 'false'    #bfals
;

function: FUNCTION ID '()' BEGIN block END;

loopParam: expression;

ifParam: logicalExpression;

array: 'array' '[' expressionList ']';

matrix: 'matrix' '[' matrixRow (',' matrixRow)* ']';

matrixRow: '[' expressionList ']';

expressionList: value (',' value)*;

CLASS: 'class';

IF: 'whatif';

LOOP: 'repeat';

FUNCTION: 'fthis';

STRUC: 'struc';

BEGIN:  '{';

END:	'}';

ASSIGN: '=';

ADD: '+';

SUBTRACT: '-';

MULT: '*';

DIVIDE: '/';

PRINT: 'print';

READ: 'read';

NUMBER: INT | FLOAT ;

INT: [0-9]+ ;

FLOAT: FLOAT32 | FLOAT64 ;

FLOAT32: [0-9]+'.'[0-9]+'f' ;

FLOAT64: [0-9]+'.'[0-9]+ ;

STRING: '"' (~["])* '"' ;

ID: [a-zA-Z_][a-zA-Z0-9_]* ;

NEWLINE: '\r'? '\n';

WS: (' '|'\t')+ -> skip;
