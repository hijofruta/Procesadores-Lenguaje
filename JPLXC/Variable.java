public class Variable {
	private String nombre;
	private int valor;
	private int llave;

	public Variable(String nom,int v,int l){
		nombre=nom;
		valor=v;
		llave=l;
	}
	public String nombre(){
		return nombre;
	}
	public int Valor(){
		return valor;
	}
	public int llave(){
		return llave;
	}
	public void CambioValor(int v){
		valor=v;
	}
	
	
}
