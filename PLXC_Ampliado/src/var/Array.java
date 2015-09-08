package src.var;

public class Array {
	private  String nombre;
	private  int nivel;
	private  Character tipo;
	private  int tope;
	private  int tope1;
	private  int tope2;
	

	public Array(String nom,int v,Character t,int top){
		nombre=nom;
		nivel=v;
		tipo=t;
		tope=top;
	}
	
	public int tope2(){
		return tope2;
	}
	public void tope2(int t){
		tope2=t;
	}
	
	public int tope1(){
		return tope1;
	}
	public void tope1(int t){
		tope1=t;
	}
	
	public int tope(){
		return tope;
	}
	public void tope(int t){
		tope=t;
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
