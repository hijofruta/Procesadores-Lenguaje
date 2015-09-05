package src.var;
import src.*;

public class Arrays {
	private static Array[] arrays=new Array[80];
	private static int cont=0;
	private static int nivel=0;
	private static char tipovalor;
	
	public static Array GuardarVariable(String nombre,Character tipov,int tope){
		if(Validar(nombre)){
		   Generador.escribir(40,null,null,null);
		   return null;		  
		}else{
		   Array x=new Array(nombre,nivel,tipov,tope);		
		   arrays[cont]=x;
		   cont++;		
		   return x;
		}
	}	
	public static boolean Validar(String n){
		if(variables[0]!=null){
			for(int i=0;i<cont;i++){
				if(variables[i].nombre().compareTo(n)==0 && variables[i].nivel()==nivel){						
					return true;
				}
			}
		}
		return false;
	}
	public static Variable ComprobarExiste(String n){
		Variable v;
		if(variables[0]!=null){
			int p=cont-1;
			for(int i=p;i>=0;i--){
				v=variables[i];
				if(v.nombre().compareTo(n)==0){
					return v;
				}
			}
		}
		Generador.escribir(40,null,null,null);
		return null;
	}

	public static void NuevaLlave(){
		nivel++;
	}
	public static void CerrarLlave(){
		for(int i=0;i<cont;i++){
			if(variables[i].nivel()==nivel){
				if(i==0){
					variables=new Variable[50];
					cont=i;
				}else{
					cont=i;
				}
				break;
			}
		}
		nivel--;
	}	

	
}

