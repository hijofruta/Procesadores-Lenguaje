import java.io.PrintStream;

public class Generador {
	public static final int PRINT=1;
	public static final int ASIG=2;
	public static final int MAS=3;
	public static final int MENOS=4;
	public static final int POR=5;
	public static final int DIV=6;
	public static final int GOTO=7;
	public static final int LABEL=8;
	public static final int IFEQ=9;
	public static final int IFLT=10;
	public static final int RANGO=11;
	

	public static int contTemp = 0;
	public static int contLabel = 0;
	protected static PrintStream out = System.out;

	public static Variable nuevaTemp(Character tipovar) {
		Variable res=Variables.GuardarVariable("t"+contTemp,tipovar);
		res.llave(0);
		contTemp++;
		return res;
	}
	public static String nuevaEtiq() {
		return "L" + contLabel++;
	}

	public static void escribir(int operacion, Object arg1, Object arg2, Object res) {
		Variable x=null;
		Variable y=null;
		Variable z=null;
		switch(operacion) {
			case PRINT:				
				if(Variables.TipoVariable(res)=='V'){ 	x=(Variable) res;}
				if(x!=null){  out.println("  print "+x.nombreCompleto()+";");
				}else{ out.println("  print "+res+";");}
				break;
			case ASIG:
				Character c=(Character) arg2;
				z=(Variable) res;
				if(Variables.TipoVariable(arg1)=='V'){ x=(Variable) arg1;}
/*Devuelve x=(float) 2*/	if(c=='F'){
				   if(x!=null){ out.println("  "+z.nombreCompleto()+"=(float) "+x.nombreCompleto()+";");
				   }else{ out.println("  "+z.nombreCompleto()+"=(float) "+arg1+";");}
/*Solo en caso (int)*/		}else if(c=='I'){
				   if(x!=null){ out.println("  "+z.nombreCompleto()+"=(int) "+x.nombreCompleto()+";");
				   }else{ out.println("  "+z.nombreCompleto()+"=(int) "+arg1+";");}
/*Devuelve lo normal x=2;*/	}else{
				   if(x!=null){ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+";");
				   }else{ out.println("  "+z.nombreCompleto ()+"="+arg1+";");}
				}
				break;			
			case MAS:
				z=(Variable) res;
				if(Variables.TipoVariable(arg1)=='V'){ x=(Variable) arg1;}
				if(Variables.TipoVariable(arg2)=='V'){ y=(Variable) arg2;}
/*Cuando son del mismo tipo***/	if(Variables.TipoVariable(arg1)==Variables.TipoVariable(arg2)){
/*Si las dos son variables reales*/    if(x!=null && y!=null && x.tipoVar()=='F'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"+r "+y.nombreCompleto()+";");
/*Si las dos son variables enteros*/   }else if(x!=null && y!=null && x.tipoVar()=='I'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"+"+y.nombreCompleto()+";");
/*Si las dos son numeros reales*/      }else if(Variables.TipoVariable(arg1)=='F'){
					    out.println("  "+z.nombreCompleto()+"="+arg1+"+r "+arg2+";");
/*Si las dos son numeros enteros*/     }else{ 
					    out.println("  "+z.nombreCompleto()+"="+arg1+"+"+arg2+";");
				       }
/*una variable y un numero*/	}else{ 
					if(y!=null){ 
					    if(Variables.TipoVariable(arg1)=='F'){ out.println("  "+z.nombreCompleto()+"="+arg1+"+r "+y.nombreCompleto()+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+arg1+"+"+y.nombreCompleto()+";");}
					}else{
					    if(Variables.TipoVariable(arg2)=='F'){ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"+r "+arg2+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"+"+arg2+";");}
					}
				}
				break;
			case MENOS:
				z=(Variable) res;
				if(Variables.TipoVariable(arg1)=='V'){ x=(Variable) arg1;}
				if(Variables.TipoVariable(arg2)=='V'){ y=(Variable) arg2;}
/*Cuando son del mismo tipo***/	if(Variables.TipoVariable(arg1)==Variables.TipoVariable(arg2)){
/*Si las dos son variables reales*/    if(x!=null && y!=null && x.tipoVar()=='F'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"-r "+y.nombreCompleto()+";");
/*Si las dos son variables enteros*/   }else if(x!=null && y!=null && x.tipoVar()=='I'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"-"+y.nombreCompleto()+";");
/*Si las dos son numeros reales*/      }else if(Variables.TipoVariable(arg1)=='F'){
					    out.println("  "+z.nombreCompleto()+"="+arg1+"-r "+arg2+";");
/*Si las dos son numeros enteros*/     }else{ 
					    out.println("  "+z.nombreCompleto()+"="+arg1+"-"+arg2+";");
				       }
/*una variable y un numero*/	}else{ 
					if(y!=null){ 
					    if(Variables.TipoVariable(arg1)=='F'){ out.println("  "+z.nombreCompleto()+"="+arg1+"-r "+y.nombreCompleto()+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+arg1+"-"+y.nombreCompleto()+";");}
					}else{
					    if(Variables.TipoVariable(arg2)=='F'){ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"-r "+arg2+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"-"+arg2+";");}
					}
				}
				break;
			case POR:
				z=(Variable) res;
				if(Variables.TipoVariable(arg1)=='V'){ x=(Variable) arg1;}
				if(Variables.TipoVariable(arg2)=='V'){ y=(Variable) arg2;}
/*Cuando son del mismo tipo***/	if(Variables.TipoVariable(arg1)==Variables.TipoVariable(arg2)){
/*Si las dos son variables reales*/    if(x!=null && y!=null && x.tipoVar()=='F'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"*r "+y.nombreCompleto()+";");
/*Si las dos son variables enteros*/   }else if(x!=null && y!=null && x.tipoVar()=='I'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"*"+y.nombreCompleto()+";");
/*Si las dos son numeros reales*/      }else if(Variables.TipoVariable(arg1)=='F'){
					    out.println("  "+z.nombreCompleto()+"="+arg1+"*r "+arg2+";");
/*Si las dos son numeros enteros*/     }else{ 
					    out.println("  "+z.nombreCompleto()+"="+arg1+"*"+arg2+";");
				       }
/*una variable y un numero*/	}else{ 
					if(y!=null){ 
					    if(Variables.TipoVariable(arg1)=='F'){ out.println("  "+z.nombreCompleto()+"="+arg1+"*r "+y.nombreCompleto()+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+arg1+"*"+y.nombreCompleto()+";");}
					}else{
					    if(Variables.TipoVariable(arg2)=='F'){ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"*r "+arg2+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"*"+arg2+";");}
					}
				}
				break;
			case DIV:
				z=(Variable) res;
				if(Variables.TipoVariable(arg1)=='V'){ x=(Variable) arg1;}
				if(Variables.TipoVariable(arg2)=='V'){ y=(Variable) arg2;}
/*Cuando son del mismo tipo***/	if(Variables.TipoVariable(arg1)==Variables.TipoVariable(arg2)){
/*Si las dos son variables reales*/    if(x!=null && y!=null && x.tipoVar()=='F'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"/r "+y.nombreCompleto()+";");
/*Si las dos son variables enteros*/   }else if(x!=null && y!=null && x.tipoVar()=='I'){
					    out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"/"+y.nombreCompleto()+";");
/*Si las dos son numeros reales*/      }else if(Variables.TipoVariable(arg1)=='F'){
					    out.println("  "+z.nombreCompleto()+"="+arg1+"/r "+arg2+";");
/*Si las dos son numeros enteros*/     }else{ 
					    out.println("  "+z.nombreCompleto()+"="+arg1+"/"+arg2+";");
				       }
/*una variable y un numero*/	}else{ 
					if(y!=null){ 
					    if(Variables.TipoVariable(arg1)=='F'){ out.println("  "+z.nombreCompleto()+"="+arg1+"/r "+y.nombreCompleto()+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+arg1+"/"+y.nombreCompleto()+";");}
					}else{
					    if(Variables.TipoVariable(arg2)=='F'){ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"/r "+arg2+";");
					    }else{ out.println("  "+z.nombreCompleto()+"="+x.nombreCompleto()+"/"+arg2+";");}
					}
				}
				break;
			case IFEQ:
				if(Variables.TipoVariable(arg1)=='V'){x=(Variable) arg1;}
				if(Variables.TipoVariable(arg2)=='V'){y=(Variable) arg2;}
				if(x!=null && y!=null){	out.println("  if("+x.nombreCompleto()+"=="+y.nombreCompleto()+") goto "+res+";");
				}else if(x!=null){ out.println("  if("+x.nombreCompleto()+"=="+arg2+") goto "+res+";");
				}else if(y!=null){ out.println("  if("+arg1+"=="+y.nombreCompleto()+") goto "+res+";");
				}else{	out.println("  if("+arg1+"=="+arg2+") goto "+res+";");} 
				break;
			case IFLT:
				if(Variables.TipoVariable(arg1)=='V'){x=(Variable) arg1;}
				if(Variables.TipoVariable(arg2)=='V'){y=(Variable) arg2;}
				if(x!=null && y!=null){	out.println("  if("+x.nombreCompleto()+"<"+y.nombreCompleto()+") goto "+res+";");
				}else if(x!=null){ out.println("  if("+x.nombreCompleto()+"<"+arg2+") goto "+res+";");
				}else if(y!=null){ out.println("  if("+arg1+"<"+y.nombreCompleto()+") goto "+res+";");
				}else{	out.println("  if("+arg1+"<"+arg2+") goto "+res+";");} 
				break;
			case GOTO:
				out.println("  goto "+res+";");
				break;
			case LABEL:
				out.println(res+":");
				break;							      
			case RANGO:
				z=(Variable) res;
				out.println("# Comprobacion de rango");
				out.println(" if("+z.nombre()+" < "+"0) goto "+arg1+";");
				out.println(" if("+z.topeArray()+" < "+z.nombre()+") goto "+arg1+";");
				out.println(" if("+z.topeArray()+" == "+z.nombre()+") goto "+arg1+";");
				out.println(" goto "+arg2+";");
				out.println(arg1+":");
				out.println(" error;");
				out.println(" halt;");
				out.println(arg2+":");
				break;
			default:
				out.println("# variable no declarada \nerror; \nhalt;");
		}
	}

	
}
