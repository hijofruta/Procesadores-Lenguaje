package src.var;

public class Variable {
	private  String nombre;
	private  int nivel;
	private  Character tipo;

	public Variable(String nom,int v,Character t){
		nombre=nom;
		nivel=v;
		tipo=t;			
	}

	public  int nivel(){
		return nivel;
	}

	public void nivel(int l){
		nivel=l;
	}

	public void nombre(String n){
		nombre=n;
	}

	public  String nombre(){
		return nombre;
	}

	public void tipoVar(Character t){
		tipo=t;
	}

	public  Character tipoVar(){
		return tipo;
	}
	
	public  String toString(){
		if(nivel==0){
			return nombre;
		}else{
			return nombre+"_"+nivel;
		}
	}
}
