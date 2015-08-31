grammar JsonFields;

json_fields:
    fields_expression EOF;

fields_expression:
    negation?
    field_set;
    
negation:
    '!';

field_set:
    '('
    qualified_field
    ( ',' qualified_field)*
    ')'
    ;

qualified_field:
    field
    fields_expression?
    ;

field:
    LETTER+
    (DASH? ( LETTER | DIGIT)+)*
    ;
LETTER
    : ('a'..'z') | ('A'..'Z')
    ;
DASH
    : [-_]
    ;
DIGIT
    : ('0'..'9');  
WS 
    : [ \r\n\t]+ -> skip
    ;