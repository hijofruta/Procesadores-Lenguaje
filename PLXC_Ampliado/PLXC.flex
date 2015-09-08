import java_cup.runtime.*;

%% 
%cup   

Termina = \r|\n|\r\n
Letras = [^\r\n]

Comentario = {Coment1} | {Coment2} | {Coment3} | {Coment4}

Coment1 	= "/*" [^*] ~"*/" | "/*" "*"+ "/"
Coment2 	= "//" {Letras}* {Termina}?
Coment3     = "/*" "*"+ [^/*] ~"*/"
Coment4		= "#" {Letras}* {Termina}?

%% 


{Comentario}		{ }
"true"			{ return new Symbol(sym.TRUE);}
"false"			{ return new Symbol(sym.FALSE);}
"switch"		{ return new Symbol(sym.SWITCH);}
"case"			{ return new Symbol(sym.CASE);}
"default"		{ return new Symbol(sym.DEFAULT);}
"break"			{ return new Symbol(sym.BREAK);}
":"				{ return new Symbol(sym.DOSP);}
"step"			{ return new Symbol(sym.ST);}
"downto"		{ return new Symbol(sym.DTO);}
"to"			{ return new Symbol(sym.TO);}
"%"			{ return new Symbol(sym.MOD);}
"+="			{ return new Symbol(sym.SASIG);}
"++"			{ return new Symbol(sym.MASMAS);}
"--"			{ return new Symbol(sym.MENOSMENOS);}
","			{ return new Symbol(sym.COMA);}
"(int)"			{ return new Symbol(sym.CASINT); }
"(float)"		{ return new Symbol(sym.CASFLOAT); }
"int"			{ return new Symbol(sym.INT); }
"float"			{ return new Symbol(sym.FLOAT); }
"in"			{ return new Symbol(sym.IN);}
"do"			{ return new Symbol(sym.DO); }
"while"			{ return new Symbol(sym.WHILE); }
"="			{ return new Symbol(sym.ASIG); }
"=="			{ return new Symbol(sym.EQUAL); }
"!="			{ return new Symbol(sym.NOTEQUAL); }
"<"			{ return new Symbol(sym.LT); }
"<="			{ return new Symbol(sym.LE); }
">"			{ return new Symbol(sym.GT); }
">="			{ return new Symbol(sym.GE); }
"!"             	{ return new Symbol(sym.NOT); }
"||"            	{ return new Symbol(sym.OR); }
"&&"            	{ return new Symbol(sym.AND); }
"for"			{ return new Symbol(sym.FOR); } 
"if"			{ return new Symbol(sym.IF); }
"else"			{ return new Symbol(sym.ELSE); }
"{"                	{ return new Symbol(sym.AL); }
"}"                	{ return new Symbol(sym.CL); }
"+"			{ return new Symbol(sym.MAS); }
"-"                	{ return new Symbol(sym.MENOS); }
"*"                	{ return new Symbol(sym.POR); }
"/"                	{ return new Symbol(sym.DIV); }
"("                	{ return new Symbol(sym.AP); }
")"                	{ return new Symbol(sym.CP); }
"]"			{ return new Symbol(sym.CC); }
"["			{ return new Symbol(sym.AC); }
"print"			{ return new Symbol(sym.PRINT); }
";"                	{ return new Symbol(sym.PYC); }
0|[1-9][0-9]*      	{ return new Symbol(sym.NUMERO, new Integer(yytext()) ); }
[0-9]*[.]([0-9]*|[eE][-+][0-9]*|[0-9]*[eE][-+][0-9]*)	{ return new Symbol(sym.REAL, new Double(yytext()) ); }
[a-z][a-zA-Z0-9_]*     { return new Symbol(sym.IDENT, yytext()); }
\r|\n              	{ }   
\ |\t|\f            	{ }  
[^]                	{ throw new Error("Illegal character <"+yytext()+">"); }

