# Compiler

## lexer
- comments: Comments starts with // characters and ends with the end of line character.
- keywords: The keywords given in the grammar: int real if then else while 
- identifiers: An identifier starts with a letter and continues with a letter or digit. A keyword cannot be an identifier, and the maximum length of an identifier is 64 characters.
- operators:    The followings are operators:   +  -  /  *  =  ==  <  <=  >  >=  !=  
- delimiters:   The followings are delimeters:   (  )  {  }  ;  
- numbers:     The numbers are defined as follows:
- digit      <- 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
- intnumber  <- digit+ (the maximum integer number is 231)
- exponent   <- (E|e) ( + | - | null ) digit+ (the maximum exponent value is 128)
- fraction   <- . digit+
- realnumber <- digit+ exponent | digit+ fraction ( exponent | null )

## grammar
- program -> decls compoundstmt
- decls -> decl ; decls | null
- decl -> int ID = INTNUM | real ID = REALNUM
- stmt -> ifstmt | assgstmt | compoundstmt
- compoundstmt -> { stmts }
- stmts -> stmt stmts | null
- ifstmt -> if ( boolexpr ) then stmt else stmt
- assgstmt -> ID = arithexpr ;
- boolexp -> arithexpr boolop arithexpr
- boolop -> < | > | <= | >= | ==
- arithexpr -> multexpr arithexprprime
- arithexprprime -> + multexpr arithexprprime | - multexpr arithexprprime | null
- multexpr -> simpleexpr multexprprime
- multexprprime -> * simpleexpr multexprprime | / simpleexpr multexprprime | null
- simpleexpr -> ID | INTUM | REALNUM | ( arithexpr )
