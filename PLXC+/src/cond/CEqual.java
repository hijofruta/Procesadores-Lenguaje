package src.cond;
import src.*;

public class CEqual{
	public Object exp1;
	public CEqual(Object a,Object b){		
		String l1=Generador.nuevaEtiq();
		String l2=Generador.nuevaEtiq();
		Labels l=new Labels(l1,l2);
		exp1=l;
		Generador.escribir(Generador.IFEQ, a.toString(), b.toString(), l1);
		Generador.escribir(Generador.GOTO,null,null,l2);
	}

	public Object val(){
		return exp1;
	}
}
