package src.bucle;
import src.*;


public class FToSt {
	private static Object res;
	public FToSt(Object a,Object b,Object c){
		Labels l=(Labels) c;
		String tres = Generador.nuevaEtiq();
		String cuatro = Generador.nuevaEtiq();
		l.tres(tres);
		l.cuatro(cuatro);
		
		Generador.escribir(Generador.LABEL, null, null, l.uno());		
		Generador.escribir(Generador.IFLT, b, a, l.cuatro());							
		Generador.escribir(Generador.GOTO, null, null, l.tres());
		
		Generador.escribir(Generador.LABEL, null, null, l.dos());
		
		res=l;
		
	}
	
	public static void segundaParte(Object a,Object b,Object c){
		Labels l=(Labels) c;
		Generador.escribir(Generador.MAS,a, c , a);		
		Generador.escribir(Generador.GOTO, null, null, l.uno());
		Generador.escribir(Generador.LABEL, null, null, l.tres());
		res=l;
	}
		
	public static Object val(){
		return res;
	}
}