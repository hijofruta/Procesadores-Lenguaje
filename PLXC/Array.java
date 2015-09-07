public class Array{
	private static Object[] lista=new Object[50];
	private static int cont=0;
	
	public static void addlista(Object o){
		lista[cont]=o;
		cont++;	
	}

	public static void generarCodigo(Object x){
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
			  if(v.tipoVar()==p.tipoVar()){	  Generador.escribir(Generador.ASIG,p,'N',t);
			  }else{ Generador.escribir(40,null,null,null); }
			}else{	
			  if(v.tipoVar()==Variables.TipoVariable(lista[i])){ Generador.escribir(Generador.ASIG,lista[i],'N',t);
			  }else{ Generador.escribir(40,null,null,null); }
			}
			Generador.escribir(Generador.ASIG,t,'N',t1);
			Variable fin=Variables.GuardarVariable(v.nombre()+"["+num+"]",v.tipoVar());
			fin.topeArray(v.topeArray());
			fin.llave(v.llave());
			Generador.escribir(Generador.ASIG,t1,'N',fin);
			t.nombre(ini);
			num--;							
		   }
		Generador.escribir(Generador.ASIG,ini,'N',v);
		lista=new Object[50];
		cont=0;
		}else{ Generador.escribir(40,null,null,null); }
	}

	public static Variable generarCodigo(){
		Variable x=null;
		Character tipo=Variables.TipoVariable(lista[0]);
		if(tipo=='V'){x=(Variable) lista[0]; tipo=x.tipoVar();}
		Variable t=Generador.nuevaTemp(tipo);
		String ini=t.nombre();
		int num=cont-1;
		Object[] list2=new Object[cont];
	   	for(int i=0;i<cont;i++){
			t.nombre(t.nombre()+"["+num+"]");
			if(Variables.TipoVariable(lista[i])=='V'){ 	
			  Variable p=(Variable) lista[i];			
			  Generador.escribir(Generador.ASIG,p,'N',t);
			}else{	
			  Generador.escribir(Generador.ASIG,lista[i],'N',t); 
			}
			t.nombre(ini);
			num--;							
		   }
		t.topeArray(cont);
		lista=new Object[50];
		cont=0;
		return t;
	}

	public static void clonarArray(Object x,Object y){
		Variable v1=(Variable) x;
		Variable v2=(Variable) y;
		Variable t=Generador.nuevaTemp(v1.tipoVar());
		if(v1.topeArray()>=v2.topeArray()){

		   for(int i=0;i<v1.topeArray();i++){
			Variable res=Variables.GuardarVariable(v1.nombre()+"["+i+"]",v1.tipoVar());
			res.topeArray(v1.topeArray());
			res.llave(v1.llave());
			if(v1.tipoVar()==v2.tipoVar()){
		   	   Generador.escribir(Generador.ASIG,v2.nombre()+"["+i+"]",'N',t);
			}else{ Generador.escribir(40,null,null,null);}
	   	   Generador.escribir(Generador.ASIG,t,'N',res);
		   }
		   Generador.escribir(Generador.ASIG,v2.nombre(),'N',v1);
		}else{ Generador.escribir(40,null,null,null);}
	}
}
