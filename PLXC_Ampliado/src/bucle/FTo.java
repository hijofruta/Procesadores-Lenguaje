package src.bucle;
import src.*;


public class FTo {
	private Object res;
	public FTo(Object a,Object b,Labels c){
		
		String tres = Generador.nuevaEtiq();
		String cuatro = Generador.nuevaEtiq();
		c.tres(tres);
		c.cuatro(cuatro);
		
		Generador.escribir(Generador.LABEL, null, null, c.uno());		
		Generador.escribir(Generador.IFLT, b, a, c.cuatro());							
		Generador.escribir(Generador.GOTO, null, null, c.tres());
		
		Generador.escribir(Generador.LABEL, null, null, c.dos());
		
		Generador.escribir(Generador.MAS,"1",a , a);		
		Generador.escribir(Generador.GOTO, null, null, c.uno());
		Generador.escribir(Generador.LABEL, null, null, c.tres());
		
		res=c;
		
	}
	
	public Object val(){
		return res;
	}
}
