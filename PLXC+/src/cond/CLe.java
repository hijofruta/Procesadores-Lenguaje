package src.cond;
import src.*;

public class CLe{
	public Object exp1;
	public CLe(Object a,Object b){		
		String l1=Generador.nuevaEtiq();
		String l2=Generador.nuevaEtiq();
		Labels l=new Labels(l1,l2);
		exp1=l;
		Generador.escribir(Generador.IFLT, a, b, l2);
		Generador.escribir(Generador.GOTO, null, null, l1);
	}

	public Object val(){
		return exp1;
	}
}