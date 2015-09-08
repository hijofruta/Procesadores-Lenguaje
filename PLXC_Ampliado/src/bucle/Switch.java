package src.bucle;
import src.Generador;
import src.Labels;
import src.var.Variable;

public class Switch {
	private static Object res;
	private static Labels label;
		
	public Switch(Object o){
			res=o;
			String l1=Generador.nuevaEtiq();			
			label=new Labels(l1, null);			
	}
	public static void NuevoCase(Object o){
		String l2=Generador.nuevaEtiq();
		String l3=Generador.nuevaEtiq();
		label.dos(l2);
		label.tres(l3);				
			
		if(Generador.TipoVariable(res)=='V'){
			Variable r=(Variable) res;
			if(r.origen()!=null){ 
				Generador.escribir(Generador.IFNEQ, r.origen(), o.toString(), l2);		
			}else{ Generador.escribir(Generador.IFNEQ, res, o.toString(), l2); }
		}else{ Generador.escribir(Generador.IFNEQ, res, o.toString(), l2); }
				
		
	}
	
	
	public static void res(Object o){
		res=o;
	}
	
	public static Labels label(){
		return label;
	}
}
