package src.exp;
import src.*;
import src.var.*;

public class EMenosMenos{
	public Object exp1;
	public EMenosMenos(Object a,Object b){				
		Variable v=Generador.nuevaTemp(Generador.Tipo(b));
		Generador.escribir(Generador.ASIG,b.toString(),null,v.toString());
		Generador.escribir(Generador.MENOS,b.toString(),a.toString(),b.toString());
		exp1=v;
	}
	
	public Object val(){
		return exp1;
	}
}