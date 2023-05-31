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
       | array
       | matrix
       | '(' expression ')'
       | '-' value
       | 'true'
       | 'false' ;

array: 'array' '[' expressionList ']';

matrix: 'matrix' '[' matrixRow (',' matrixRow)* ']';

matrixRow: '[' expressionList ']';

expressionList: expression (',' expression)*;