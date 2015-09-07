package src.dec;
import src.var.*;
import src.*;

public class DeclaraArray {
	private static Object[] lista=new Object[50];
	private static int cont=0;
	
	public static void addlista(Object o){
		lista[cont]=o;
		cont++;	
	}

	public static void generarCodigo(Array v){		
		Variable t=Generador.nuevaTemp(v.tipoVar());
		Variable t1=Generador.nuevaTemp(v.tipoVar());
		String ini=t.nombre();
		int num=cont-1;		
		if(v.tope()>=cont){		
		   for(int i=0;i<cont;i++){
			t.nombre(t.nombre()+"["+num+"]");
				
			  if(v.tipoVar()==Generador.Tipo(lista[i])){	  
				  Generador.escribir(Generador.ASIG,lista[i],null,t);
			  }else{ Generador.escribir(40,null,null,null); }
						
			Generador.escribir(Generador.ASIG,t,null,t1);
			
			Array fin=Arrays.GuardarVariable(v.nombre()+"["+num+"]",v.tipoVar(),v.tope());			
			fin.nivel(v.nivel());
			Generador.escribir(Generador.ASIG,t1,null,fin);
			
			t.nombre(ini);
			num--;							
		   }
		Generador.escribir(Generador.ASIG,ini,null,v);
		lista=new Array[50];
		cont=0;
		}else{ Generador.escribir(40,null,null,null); }
	}	

	public static Array generarCodigo(){
		
		Character tipo=Generador.Tipo(lista[0]);
				
		Variable temp=Generador.nuevaTemp(tipo);
		Array t=Arrays.GuardarVariable(temp.toString(),tipo, cont);
		
		String ini=t.nombre();
		int num=cont-1;
				
	   	for(int i=0;i<cont;i++){	   		
			t.nombre(t.nombre()+"["+num+"]");
						
			Generador.escribir(Generador.ASIG,lista[i],'N',t); 
			
			t.nombre(ini);
			num--;							
		}
	   			
		lista=new Object[50];
		cont=0;
		return t;
	}
	
	public static void clonarArray(Array x,Array y){		
		Variable t=Generador.nuevaTemp(x.tipoVar());
		if(x.tope()>=y.tope()){
			
		   for(int i=0;i<y.tope();i++){
			Array res=Arrays.GuardarVariable(x.nombre()+"["+i+"]",x.tipoVar(),x.tope());			
			res.nivel(x.nivel());
			
			if(x.tipoVar()==y.tipoVar()){
		   	   Generador.escribir(Generador.ASIG,y.nombre()+"["+i+"]",null,t);
			}else{ Generador.escribir(40,null,null,null);}
	   	   Generador.escribir(Generador.ASIG,t,null,res);
		   }
		   
		   Generador.escribir(Generador.ASIG,y.nombre(),null,x);
		}else{ Generador.escribir(40,null,null,null);}
	}

}
