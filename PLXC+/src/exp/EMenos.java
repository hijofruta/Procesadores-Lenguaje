package src.exp;
import src.*;
import src.var.*;

public class EMenos{
	public Object exp1;
	public EMenos(Object a,Object b){		
		if(Generador.Tipo(a)==Generador.Tipo(b)){
			exp1=iguales(a,b);
		}else{
		  if(Generador.Tipo(a)=='F'){
			exp1=diferentes(a,b);
		  }else{
			exp1=diferentesB(a,b);
	          }
		}
	}
	public Object iguales(Object a,Object b){
		Variable v=null;
		if(Generador.Tipo(a)=='F'){	
			v=Generador.nuevaTemp('F');
			Generador.escribir(Generador.MENOS,a.toString(),"r "+b.toString(),v.toString());
		}else{
		    	v=Generador.nuevaTemp('I');
			Generador.escribir(Generador.MENOS,a.toString(),b.toString(),v.toString());
		}
		return v;
	}
	public Object diferentes(Object o1,Object o2){	
		Variable v0=Generador.nuevaTemp(Generador.Tipo(o1));
		Generador.escribir(Generador.ASIG,"(float) "+o2.toString(),null,v0.toString());
		Variable v=Generador.nuevaTemp(Generador.Tipo(o1));
		Generador.escribir(Generador.MENOS,o1.toString(),"r "+v0.toString(),v.toString());
		return v;
	}
	public Object diferentesB(Object o1,Object o2){	
		Variable v0=Generador.nuevaTemp(Generador.Tipo(o2));
		Generador.escribir(Generador.ASIG,"(float) "+o1.toString(),null,v0.toString());
		Variable v=Generador.nuevaTemp(Generador.Tipo(o2));
		Generador.escribir(Generador.MENOS,v0.toString(),"r "+o2.toString(),v.toString());
		return v;
	}
	public Object val(){
		return exp1;
	}
}
