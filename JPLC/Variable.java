public class Variable {
	private String nombre;
	private int valor;
	public Variable(String nom,int v){
		nombre=nom;
		valor=v;

	}
	public String nombre(){
		return nombre;
	}
	public int Valor(){
		return valor;
	}
	public void CambioValor(int v){
		valor=v;
	}
	
	
}
