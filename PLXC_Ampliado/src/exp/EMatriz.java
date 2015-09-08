package src.exp;
import src.*;
import src.var.Array;
import src.var.Arrays;
import src.var.Variable;
import src.var.Variables;
import src.exp.Exp;

public class EMatriz {
	private Object res;
	private static String top;
	
	public EMatriz(Object a,Object b){
		   Array x=(Array) a;	
		   
		   primerArray(x);
		   Array y=segundoArray(x,b);
			
		   Variable t=Generador.nuevaTemp(y.tipoVar());
		   Generador.escribir(Generador.ASIG,y,null,t);
			
			res=t;
		   
	}
	
	public EMatriz(Object a,Object b,Object c){
			Array x=(Array) a;
			primerArray(x);				
			Array y=segundoArray(x,b);
			
			new Exp('=',c,y,null);
			
			Variable z=Variables.GuardarVariable(y.nombre(),y.tipoVar());
			z.nivel(y.nivel());			
			z.origen(x.nombre());
			
			res=z;	
			   
	}
	public void primerArray(Array x){
		
		   String l1=Generador.nuevaEtiq();
		   String l2=Generador.nuevaEtiq();		  
		   
	       Array y=Arrays.GuardarVariable(top, x.tipoVar(), x.tope1());
	       y.nivel(x.nivel());
		   Generador.escribir(Generador.RANGO,l1,l2,y);
		   Arrays.BorrarActual();
		   
	}
	
	public Array segundoArray(Array x,Object b){
		   		   
		   String l1=Generador.nuevaEtiq();
		   String l2=Generador.nuevaEtiq();		  
		   
	       Variable t=Generador.nuevaTemp(x.tipoVar());
	       Generador.escribir(Generador.POR, x.tope2(), top, t);
	       Generador.escribir(Generador.MAS, t, b.toString(), t);
	       
	       Array y=Arrays.GuardarVariable(b.toString(), x.tipoVar(), x.tope2());
	       y.nivel(x.nivel());
		   Generador.escribir(Generador.RANGO,l1,l2,y);
		   Arrays.BorrarActual();
		   		   		  
			y=Arrays.ComprobarExiste(x.nombre()+"["+t.toString()+"]");			
			if(y==null){ y=Arrays.GuardarVariable(x.nombre()+"["+t.toString()+"]",x.tipoVar(),x.tope());
				y.nivel(x.nivel());}
				
			return y;
										 
	}
	
	
	
	public static void top(String a){
		top=a;
	}
	
	public Object val(){
		return res;
	}
}
