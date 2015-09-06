package src.exp;
import src.*;
import src.var.*;

public class ECast{
	private Object res;
	public ECast(Object c,Object a){
		Character cas=(Character) c;
		Variable v=Generador.nuevaTemp(cas);
		if(cas==Generador.Tipo(a)){
			Generador.escribir(Generador.ASIG,a.toString(),null,v);
			res=v;
		}else{		  
			res=diferentes(a,v);		  
		}	
	}		
	public Object diferentes(Object a,Variable b){	
		if(b.tipoVar()=='I'){							
			Generador.escribir(Generador.ASIG,"(int) "+a.toString(),null,b.toString());
		}else{
			Generador.escribir(Generador.ASIG,"(float) "+a.toString(),null,b.toString());
		}
		return b;
	}

	public Object val(){
		return res;
	}
}
