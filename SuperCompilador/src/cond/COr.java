package src.cond;
import src.*;

public class COr{
	public Object exp1;
	public COr(Object a,Object b){		
		Labels c1=(Labels) a;
		Labels c2=(Labels) b;
					
		Generador.escribir(Generador.LABEL, null, null, c1.dos());
		Generador.escribir(Generador.LABEL, null, null, c1.uno());
		Generador.escribir(Generador.GOTO, null, null, c2.uno());
		exp1=c2;
	}

	public Object val(){
		return exp1;
	}
}