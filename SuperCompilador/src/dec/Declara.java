package src.dec;
import src.*;
import src.var.*;
import src.exp.*;

public class Declara{
	private Object o1;
	private static Object[] lo=new Object[20];
	private static Object[] vo=new Object[20];
	private static int cont=0;

	public Declara(Object o){
		if(Generador.TipoVariable(o)=='V'){
		    Variable v=(Variable) o;
		    DeclaraVariable(v);
		    if(vo[0]!=null){ DeclaraVariableValor(v);}
		}
	}


	public void DeclaraVariable(Variable v){
		for(int i=0;i<cont;i++){
			Variables.GuardarVariable(lo[i].toString(),v.tipoVar());
		}
	}

	public void DeclaraVariableValor(Variable v){

		for(int i=0;i<cont;i++){
			Variable z=Variables.GuardarVariable(lo[i].toString(),v.tipoVar());
			Exp e=new Exp('=',vo[i],z);
		}
	}

	public static void addLista(Object o){
		lo[cont]=o;
		cont++;
	}
	
	public static void addLista(Object o,Object v){
		lo[cont]=o;
		vo[cont]=v;
		cont++;
	}

}
