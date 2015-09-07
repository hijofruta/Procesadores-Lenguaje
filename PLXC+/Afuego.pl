#!/usr/bin/perl

use strict;
use warnings;
#use diagnostics;
#use autodie;

my $plxcFile;
my $ctdFile;

my $falla;
my $cont = 0;
my $cont2 = 0;

my @files = </home/alumno/Desktop/SuperCompilador/prueba/*>;
foreach $plxcFile (@files){
	if($plxcFile =~ /\.plx$/i){
		$ctdFile = $plxcFile;
		$ctdFile =~ s/\.plx/\.ctd/;

		my $compila = qx(./plxc $plxcFile $ctdFile);
		my $salida1 = qx(./ctd $ctdFile);
		
		my $compila2 = qx(java PLXC $plxcFile $ctdFile);
		my $salida2 = qx(./ctd $ctdFile);

		if($salida1 eq $salida2){
			$cont++;
		}else{ print "\n ***********Archivo Falla". $plxcFile . "\n"; }
		
		$cont2++;

	}
}

if($cont == $cont2){
	print "Ole le le, todos los test superado " . $cont . "/" . $cont2 . "\n";
}
else{
	print "Has tenido algún error, número de test pasados: " . $cont . " de " . $cont2 . "\n";
	
}
qx(rm /home/alumno/Desktop/SuperCompilador/prueba/*.ctd);
