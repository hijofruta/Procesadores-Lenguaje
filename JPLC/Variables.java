public class Variables {
	private static Variable[] variables=new Variable[50];
	private static int cont=0;
	
	public static String GuardarVariable(String nombre,int v){
		if(Variables.ComprobarCrear(nombre)==true){
			return "false";
		}else{
			variables[cont]=new Variable(nombre,v);		
			cont++;		
			return nombre;
		}
	}
	public static int ComprobarExiste(String n){
		if(variables[0]!=null){
			for(int i=0;i<cont;i++){
				Variable v=variables[i];
				if(v.nombre().compareTo(n)==0){
					return i;					
				}
			}
		}
		return -1;
	}

	public static boolean ComprobarCrear(String n){
		if(variables[0]!=null){
			for(int i=0;i<cont;i++){
				if(variables[i].nombre().compareTo(n)==0){
					return true;
				}
			}
		}
		return false;
	}

	public static void ModificarVariable(int p,int v){
		variables[p].CambioValor(v);
	}

	public static void Vaciar(){
		cont=0;
	}

	public static int Maximo(){
		return cont;
	}
	
	public static int valor(int p){
		return variables[p].Valor();
	}

}

