public class Pila {
	private static int[] pila=new int[50];
	private static int cont=0;
	private static int max=0;
	
	public static void GuardarValor(int v){
		pila[cont]=v;		
		cont++;		
		if(cont>=max){
			max=cont;
		}
	}
	public static void ModificarPila(int v){
		cont--;
		int p=cont-1;
		pila[p]=v;
	}
	public static void NegarValor(int v){
		int p=cont-1;
		pila[p]=v;
	}
	public static int SacarValor(){
		cont--;
		return pila[cont];
	}
	public static int ValorPila2(){
		int p=cont-1;
		return pila[p];
	}
	public static int ValorPila1(){
		int p=cont-2;
		return pila[p];
	}
	public static void Vaciar(){
		cont=0;
		max=0;
	}

	public static int Maximo(){
		return max;
	}
}

