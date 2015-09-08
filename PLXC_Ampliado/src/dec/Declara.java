package src.dec;
import src.*;
import src.var.*;
import src.exp.*;

public class Declara{	
	private static Object[] lo=new Object[20];
	private static Object[] vo=new Object[20];
	private static int ct=0;

	public Declara(Object o){
		if(Generador.TipoVariable(o)=='V'){
		    Variable v=(Variable) o;
		    DeclaraVariable(v);
		    if(vo[0]!=null){ DeclaraVariableValor(v);}
		    lo=new Object[20];
		    vo=new Object[20];
		    ct=0;
		}
	}


	public void DeclaraVariable(Variable v){
		for(int i=0;i<ct;i++){			
			Variables.GuardarVariable(lo[i].toString(),v.tipoVar());
		}
	}

	public void DeclaraVariableValor(Variable v){
		Variable z=null;
		for(int i=0;i<ct;i++){		
			Variables.GuardarVariable(lo[i].toString(),v.tipoVar());
			z=Variables.ComprobarExiste(lo[i].toString());
			new Exp('=', vo[i], z,null);
		}		
	}

	public static void addLista(Object o){
		lo[ct]=o;
		ct++;
	}
	
	public static void addLista(Object o,Object v){
		lo[ct]=o;
		vo[ct]=v;
		ct++;
	}

}

