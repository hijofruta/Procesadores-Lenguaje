package src.bucle;
import src.*;
import src.dec.DeclaraArray;
import src.var.*;

public class FIn {
	private Object res;
	public FIn(Object a,Object b,Labels c,Character p){		
		if(p=='0'){
			GenerandoCodigo(a,c);			
		}else{
			Array a2=Arrays.ComprobarExiste(b.toString());
			if(a2!=null){
				Array a1=(Array) a;			
				SinGenerarCodigo(a1,a2,c);
			}else{ Generador.escribir(40,null,null,null); }
		}
		
		
	}
	public void GenerandoCodigo(Object a,Labels c){
		String tres = Generador.nuevaEtiq();
		String cuatro = Generador.nuevaEtiq();
		c.tres(tres);
		c.cuatro(cuatro);
		
		Variable cont=Generador.nuevaTemp('I');		
		
		Array t=DeclaraArray.generarCodigo();
		
		Generador.escribir(Generador.ASIG, "-1", null, cont.toString());
		
		Generador.escribir(Generador.LABEL, null, null, c.uno());
		
		Generador.escribir(Generador.MAS, cont.toString(),"1", cont.toString());
		Generador.escribir(Generador.IFLT, cont.toString(),t.tope(), c.dos());
		Generador.escribir(Generador.GOTO, null, null, c.tres());
		
		Generador.escribir(Generador.LABEL, null, null, c.dos());
		
		Generador.escribir(Generador.ASIG, t.nombre()+"["+cont.toString()+"]", null, a);
		
		res=c;
	}
	
	public void SinGenerarCodigo(Array a,Array b,Labels c){
		String tres = Generador.nuevaEtiq();
		String cuatro = Generador.nuevaEtiq();
		c.tres(tres);
		c.cuatro(cuatro);
		
		Variable cont=Generador.nuevaTemp('I');		
		
		if(a.tipoVar()==b.tipoVar()){
		
			Generador.escribir(Generador.ASIG, "-1", null, cont.toString());
		
			Generador.escribir(Generador.LABEL, null, null, c.uno());
		
			Generador.escribir(Generador.MAS, cont.toString(),"1", cont.toString());
			Generador.escribir(Generador.IFLT, cont.toString(),b.tope(), c.dos());
			Generador.escribir(Generador.GOTO, null, null, c.tres());
		
			Generador.escribir(Generador.LABEL, null, null, c.dos());
			
			if(a.tope()!=0){
				Variable t=Generador.nuevaTemp(a.tipoVar());
				Generador.escribir(Generador.ASIG, b.nombre()+"["+cont.toString()+"]", null, t);
				Generador.escribir(Generador.ASIG, t.toString(), null, a.toString());
			}else{ Generador.escribir(Generador.ASIG, b.nombre()+"["+cont.toString()+"]", null, a.toString());}
		
		}else{ Generador.escribir(40,null,null,null); }
		
		res=c;
	}
	
	
	public Object val(){
		return res;
	}
}
