package src.bucle;
import src.*;


public class FToSt {
	private Object res;
	
	public FToSt(Object a,Object b,Labels c,Character parte){
		if(parte=='1'){
			primeraParte(a, b, c);
		}else{
			segundaParte( a, b, c);
		}
		
		
	}
	public void  primeraParte(Object a,Object b,Labels c){		
		String tres = Generador.nuevaEtiq();
		String cuatro = Generador.nuevaEtiq();
		c.tres(tres);
		c.cuatro(cuatro);
		
		Generador.escribir(Generador.LABEL, null, null, c.uno());		
		Generador.escribir(Generador.IFLT, b, a, c.cuatro());							
		Generador.escribir(Generador.GOTO, null, null, c.tres());
		
		Generador.escribir(Generador.LABEL, null, null, c.dos());
		
		res=c;
	}
	
	public void segundaParte(Object a,Object b,Labels c){		
		Generador.escribir(Generador.MAS,a, b , a);		
		Generador.escribir(Generador.GOTO, null, null, c.uno());
		Generador.escribir(Generador.LABEL, null, null, c.tres());
		res=c;
	}
		
	public Object val(){
		return res;
	}
}