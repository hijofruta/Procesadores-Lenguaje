package src.exp;
import src.*;
import src.var.*;

public class EMasMas{
	public Object exp1;
	public EMasMas(Object a,Object b){	
		Variable v=Generador.nuevaTemp(Generador.Tipo(b));
		Generador.escribir(Generador.ASIG,b.toString(),null,v.toString());
		Generador.escribir(Generador.MAS,b.toString(),a.toString(),b.toString());
		exp1=v;
	}
	
	public Object val(){
		return exp1;
	}
}
