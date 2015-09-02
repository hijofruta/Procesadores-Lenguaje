public class Variable {
	private  String nombre;
	private  int llave;
	private  Character tipoVar;

	public Variable(String nom,int v,Character tv){
		nombre=nom;
		llave=v;
		tipoVar=tv;
	}
	public  String nombre(){
		return nombre;
	}
	public  int llave(){
		return llave;
	}

	public  Character tipoVar(){
		return tipoVar;
	}
	
	public  String nombreCompleto(){
		if(llave==0){
			return nombre;
		}else{
			return nombre+"_"+llave;
		}
	}
	
}
