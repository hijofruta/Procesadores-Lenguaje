package src.exp;
import src.*;
import src.var.Array;
import src.var.Arrays;
import src.var.Variable;
import src.var.Variables;
import src.exp.Exp;

public class EArray {
	private Object res;
	
	public EArray(Object a,Object b){
		   Array x=(Array) a;		   
		   String l1=Generador.nuevaEtiq();
		   String l2=Generador.nuevaEtiq();			   
		   
	       Array y=Arrays.GuardarVariable(b.toString(), x.tipoVar(), x.tope());	       
		   Generador.escribir(Generador.RANGO,l1,l2,y);		   
		   Arrays.BorrarActual();
		   
		   if(x!=null){
			y=Arrays.ComprobarExiste(x.nombre()+"["+b.toString()+"]");
			if(y==null){ y=Arrays.GuardarVariable(x.nombre()+"["+b.toString()+"]",x.tipoVar(),x.tope());
				y.nivel(x.nivel());}
			
			Variable t=Generador.nuevaTemp(y.tipoVar());
			Generador.escribir(Generador.ASIG,y,null,t);
			
			res=t;
		   }else{
			Generador.escribir(40,null,null,null);
		   }
	}
	
	public EArray(Object a,Object b,Object c){
		   Array x=(Array) a;		   
		   String l1=Generador.nuevaEtiq();
		   String l2=Generador.nuevaEtiq();		  
		   
	       Array y=Arrays.GuardarVariable(b.toString(), x.tipoVar(), x.tope());
		   Generador.escribir(Generador.RANGO,l1,l2,y);
		   Arrays.BorrarActual();
		   
		   if(x!=null){			   
			y=Arrays.ComprobarExiste(x.nombre()+"["+b.toString()+"]");			
			if(y==null){ y=Arrays.GuardarVariable(x.nombre()+"["+b.toString()+"]",x.tipoVar(),x.tope());
				y.nivel(x.nivel());}
						
			new Exp('=',c,y,null);
			
			Variable z=Variables.GuardarVariable(y.nombre(),y.tipoVar());
			z.nivel(y.nivel());
			res=z;
						
		   }else{			   
			Generador.escribir(40,null,null,null);
		   }
	}
	
	public Object val(){
		return res;
	}
}
