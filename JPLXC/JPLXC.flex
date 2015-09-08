import java_cup.runtime.*;

%% 
%cup 
%%   

"main"			{ return new Symbol(sym.MAIN);}
"return"		{ return new Symbol(sym.RET);}
"step"			{ return new Symbol(sym.ST);}
"downto"		{ return new Symbol(sym.DTO);}
"to"			{ return new Symbol(sym.TO);}
"%"			{ return new Symbol(sym.MOD);}
"++"			{ return new Symbol(sym.MASMAS);}
"--"			{ return new Symbol(sym.MENOSMENOS);}
","			{ return new Symbol(sym.COMA);}
"int"			{ return new Symbol(sym.INT); }
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
";"                	{ return new Symbol(sym.PYC); }
0|[1-9][0-9]*      	{ return new Symbol(sym.NUMERO, new Integer(yytext()) ); }
[a-z][a-zA-Z0-9_]*     { return new Symbol(sym.IDENT, yytext()); }
\r|\n              	{ }   
\ |\t|\f            	{ }  
[^]                	{ throw new Error("Illegal character <"+yytext()+">"); }
