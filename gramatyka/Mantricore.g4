grammar Mantricore;

start: ( program? NEWLINE )* EOF;

program:  PRINT '(' ID ')'              #printId
          | PRINT '(' expression ')'    #printExp
          | READ '(' ID ')'             #readId
          | ID ASSIGN expression        #assignExpr
;

expression: logicalExpression ;

logicalExpression: arithmeticExpression                         #logical
                 | logicalExpression '&&' logicalExpression     #and
                 | logicalExpression '||' logicalExpression     #or
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

array: 'array' '[' expressionList ']';

matrix: 'matrix' '[' matrixRow (',' matrixRow)* ']';

matrixRow: '[' expressionList ']';

expressionList: value (',' value)*;

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
