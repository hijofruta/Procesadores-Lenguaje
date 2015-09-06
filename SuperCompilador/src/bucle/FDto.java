package src.bucle;
import src.*;


public class FDto {
	private Object res;
	public FDto(Object a,Object b,Object c){
		Labels l=(Labels) c;
		String tres = Generador.nuevaEtiq();
		String cuatro = Generador.nuevaEtiq();
		l.tres(tres);
		l.cuatro(cuatro);
		
		Generador.escribir(Generador.LABEL, null, null, l.uno());		
		Generador.escribir(Generador.IFLT, a, b, l.cuatro());							
		Generador.escribir(Generador.GOTO, null, null, l.tres());
		
		Generador.escribir(Generador.LABEL, null, null, l.dos());
		
		Generador.escribir(Generador.MENOS,a,1 , a);		
		Generador.escribir(Generador.GOTO, null, null, l.uno());
		Generador.escribir(Generador.LABEL, null, null, l.tres());
		
		res=l;
		
	}
	
	public Object val(){
		return res;
	}
}