grammar Mantricore;

start: program EOF ;

program: statement+ ;

statement: assignment
         | inputStatement
         | outputStatement
         | errorStatement ;

assignment: ID '=' expression ';' ;

inputStatement: 'read' '(' ID ')' ';' ;

outputStatement: 'print' '(' expression ')' ';' ;

errorStatement: 'ERROR:' STRING ';' ;

expression: logicalExpression ;

logicalExpression: arithmeticExpression
                 | logicalExpression '&&' logicalExpression
                 | logicalExpression '||' logicalExpression
                 | '!' logicalExpression ;

arithmeticExpression: term
                     | arithmeticExpression '+' term
                     | arithmeticExpression '-' term ;

term: value
     | term '*' value
     | term '/' value ;

value: ID
       | NUMBER
       | STRING
       | arrayAccess
       | matrix
       | '(' expression ')'
       | '-' value
       | 'true'
       | 'false' ;

arrayAccess: ID '[' expression ']' ;

matrix: '[' matrixRow (',' matrixRow)* ']' ;

matrixRow: expression (',' expression)* ;

NUMBER: INT | FLOAT ;

INT: [0-9]+ ;

FLOAT: FLOAT32 | FLOAT64 ;

FLOAT32: [0-9]+'.'[0-9]+'f' ;

FLOAT64: [0-9]+'.'[0-9]+ ;

STRING: '"' (~["])* '"' ;

ID: [a-zA-Z_][a-zA-Z0-9_]* ;

WS: [ \t\r\n]+ -> skip ;
