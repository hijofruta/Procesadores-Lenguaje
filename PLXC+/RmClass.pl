#!/usr/bin/perl

my $ruta="/home/alumno/Desktop/PLXC";

qx(rm $ruta/*.class);
qx(rm $ruta/parser.java);
qx(rm $ruta/Yylex.java);
qx(rm $ruta/sym.java);
qx(rm $ruta/src/*.class);
qx(rm $ruta/src/var/*.class);
qx(rm $ruta/src/exp/*.class);
qx(rm $ruta/src/dec/*.class);
qx(rm $ruta/src/cond/*.class);
qx(rm $ruta/src/bucle/*.class);

print "Borrado con Exito \n";
