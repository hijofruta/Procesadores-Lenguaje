package src.cond;
import src.*;


public class CNEqual{
	public Object exp1;
	public CNEqual(Object a,Object b){		
		String l1=Generador.nuevaEtiq();
		String l2=Generador.nuevaEtiq();
		Labels l=new Labels(l1,l2);
		exp1=l;
		Generador.escribir(Generador.IFEQ, a.toString(), b.toString(), l2);
		Generador.escribir(Generador.GOTO,null,null,l1);
	}

	public Object val(){
		return exp1;
	}
}
