public class Variable {
	private  String nombre;
	private  int llave;
	private  Character tipoVar;
	private  Integer topeArray;

	public Variable(String nom,int v,Character tv){
		nombre=nom;
		llave=v;
		tipoVar=tv;
		topeArray=0;	
	}
	public void nombre(String n){
		nombre=n;
	}
	public void topeArray(Integer t){
		topeArray=t;
	}
	public void llave(int l){
		llave=0;
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
	public Integer topeArray(){
		return topeArray;
	}
	
	public  String nombreCompleto(){
		if(llave==0){
			return nombre;
		}else{
			return nombre+"_"+llave;
		}
	}
}
