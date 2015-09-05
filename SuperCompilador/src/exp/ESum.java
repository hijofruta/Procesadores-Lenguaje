package src.exp;
import src.*;
import src.var.*;

public class ESum{
	public Object exp1;
	public ESum(Object a,Object b){		
		if(Generador.Tipo(a)==Generador.Tipo(b)){
			exp1=iguales(a,b);
		}else{
		  if(Generador.Tipo(a)=='F'){
			exp1=diferentes(a,b);
		  }else{
			exp1=diferentes(b,a);
	          }
		}
	}
	public Object iguales(Object a,Object b){
		Variable v=null;
		if(Generador.Tipo(a)=='F'){	
			v=Generador.nuevaTemp('F');
			Generador.escribir(Generador.MAS,a.toString(),"r "+b.toString(),v.toString());
		}else{
		    	v=Generador.nuevaTemp('I');
			Generador.escribir(Generador.MAS,a.toString(),b.toString(),v.toString());
		}
		return v;
	}
	public Object diferentes(Object o1,Object o2){	
		Variable v0=Generador.nuevaTemp(Generador.Tipo(o1));
		Generador.escribir(Generador.ASIG,"(float) "+o2.toString(),null,v0.toString());
		Variable v=Generador.nuevaTemp(Generador.Tipo(o1));
		Generador.escribir(Generador.MAS,o1.toString(),"r "+v0.toString(),v.toString());
		return v;
	}
	public Object val(){
		return exp1;
	}
}
