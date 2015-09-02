public class Array{
	private static Object[] lista=new Object[50];
	private static int cont=0;
	
	public static void addlista(Object o){
		lista[cont]=o;
		cont++;	
	}

	public static Object[] generarCodigo(Object x){
		Variable v=(Variable) x;
		Variable t=Generador.nuevaTemp(v.tipoVar());
		Variable t1=Generador.nuevaTemp(v.tipoVar());
		String ini=t.nombre();
		int num=cont-1;
		Object[] list2=new Object[cont];
		if(v.topeArray()>=cont){		
		for(int i=0;i<cont;i++){
			t.nombre(t.nombre()+"["+num+"]");
			if(Variables.TipoVariable(lista[i])=='V'){ 	
			  Variable p=(Variable) lista[i];			
			  Generador.escribir(Generador.ASIG,p,'N',t);
			}else{	Generador.escribir(Generador.ASIG,lista[i],'N',t);}
			Generador.escribir(Generador.ASIG,t,'N',t1);
			Variable fin=Variables.GuardarVariable(v.nombre()+num+"]",v.tipoVar());
			Generador.escribir(Generador.ASIG,t1,'N',fin);
			t.nombre(ini);
			num--;
		}
		t.nombre(v.nombre().substring(0,1));
		Generador.escribir(Generador.ASIG,ini,'N',t);
		}else{ Generador.escribir(40,null,null,null); }
		return lista;
	}



}
