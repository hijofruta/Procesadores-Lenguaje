package src.bucle;
import src.*;


public class FDto {
	private Object res;
	public FDto(Object a,Object b,Labels c){
		
		String tres = Generador.nuevaEtiq();
		String cuatro = Generador.nuevaEtiq();
		c.tres(tres);
		c.cuatro(cuatro);
		
		Generador.escribir(Generador.LABEL, null, null, c.uno());		
		Generador.escribir(Generador.IFLT, a, b, c.cuatro());							
		Generador.escribir(Generador.GOTO, null, null, c.tres());
		
		Generador.escribir(Generador.LABEL, null, null, c.dos());
		
		Generador.escribir(Generador.MENOS,a,1 , a);		
		Generador.escribir(Generador.GOTO, null, null, c.uno());
		Generador.escribir(Generador.LABEL, null, null, c.tres());
		
		res=c;
		
	}
	
	public Object val(){
		return res;
	}
}