public class Variables {
	private static Variable[] variables=new Variable[100];
	private static int cont=0;
	private static int llaves=0;
	private static char tipovalor;

	
	public static Variable GuardarVariable(String nombre,Character tipov){
		Variable x=new Variable(nombre,llaves,tipov);		
		variables[cont]=x;
		cont++;		
		return x;

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
		return null;
	}
	public static boolean ComprobarCrear(String n){
		if(variables[0]!=null){
			for(int i=0;i<cont;i++){
				if(variables[i].nombre().compareTo(n)==0 && variables[i].llave()==llaves){
					return true;

				}
			}
		}
		return false;
	}
	public static void NuevaLlave(){
		llaves++;
	}
	public static void CerrarLlave(){
		for(int i=0;i<cont;i++){
			if(variables[i].llave()==llaves){
				if(i==0){
					variables=new Variable[50];
					cont=i;
				}else{
					cont=i;
				}
				break;
			}
		}
		llaves--;
	}	

	public static char TipoVariable(Object o){
		if(o.getClass().getName().equalsIgnoreCase("java.lang.double")){
        	   return 'F';
	        }else if(o.getClass().getName().equalsIgnoreCase("java.lang.integer")){
		   return 'I';
		}else if(o.getClass().getName().equalsIgnoreCase("variable")){
		   return 'V';
	        }else if(o.getClass().getName().equalsIgnoreCase("java.lang.string")){		
		   return 'S';
		}else{return 'N';}
	}
}

