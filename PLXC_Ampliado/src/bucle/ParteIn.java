package src.bucle;

import src.Generador;
import src.var.Array;
import src.var.Arrays;

public class ParteIn {
	private Array res;
	
	public ParteIn(Array x,Object b){
		
		   String l1=Generador.nuevaEtiq();
		   String l2=Generador.nuevaEtiq();		
		   
	       Array y=Arrays.GuardarVariable(b.toString(), x.tipoVar(), x.tope());
	       y.nivel(x.nivel());
		   Generador.escribir(Generador.RANGO,l1,l2,y);		
		   Arrays.BorrarActual();
		   
		   if(x!=null){
			y=Arrays.ComprobarExiste(x.nombre()+"["+b.toString()+"]");
			if(y==null){ y=Arrays.GuardarVariable(x.nombre()+"["+b.toString()+"]",x.tipoVar(),x.tope());
				y.nivel(x.nivel());}					
			
			res=y;
		   }else{
			Generador.escribir(40,null,null,null);
		   }
	}
	
	public Array res(){
		return res;
	}
}
