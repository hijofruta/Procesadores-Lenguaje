package src.exp;
import src.*;
import src.var.*;

public class EAsig{
	private Object res;
	public EAsig(Object a,Object b){
		if(Generador.Tipo(a)==Generador.Tipo(b)){
			Generador.escribir(Generador.ASIG,a.toString(),null,b.toString());
			res=b;
		}else{		  
			res=diferentes(a,b);		  
		}	
	}		
	public Object diferentes(Object a,Object b){	
		Variable v=Generador.nuevaTemp('F');
		if(Generador.Tipo(a)=='I'){							
			Generador.escribir(Generador.ASIG,"(float) "+a.toString(),null,v.toString());
			Generador.escribir(Generador.ASIG,v.toString(),null,b.toString());
		}else{
			Generador.escribir(40,null,null,null);
		}
		return b;
	}

	public Object val(){
		return res;
	}
}
