package src;
import java.io.PrintStream;
import src.var.*;

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
	public static PrintStream out = System.out;

	public static Variable nuevaTemp(Character tipo){
		Variable v=Variables.GuardarVariable("t"+contTemp++,tipo);
		v.nivel(0);
		return v;
	}
	public static String nuevaEtiq() {
		return "L" + contLabel++;
	}
	
	public static char Tipo(Object o){

		if(o.getClass().getName().equalsIgnoreCase("java.lang.double")){
		 	return 'F';
	        }else if(o.getClass().getName().equalsIgnoreCase("java.lang.integer")){
			return 'I';
		}else if(o.getClass().getName().equalsIgnoreCase("src.var.variable")){
			Variable v=(Variable) o;
		   	return v.tipoVar();
	        }else if(o.getClass().getName().equalsIgnoreCase("java.lang.string")){		
				return 'S';
		}else{ 	return 'N'; }
	}

	public static char TipoVariable(Object o){
		if(o.getClass().getName().equalsIgnoreCase("src.var.variable")){
			return 'V';
		}else{ return 'N'; }
	}

	public static void escribir(int operacion, Object arg1, Object arg2, Object res) {

		switch(operacion) {
			case PRINT:				
				out.println("  print "+res+";");
				break;
			case ASIG:
				out.println("  "+res+" = "+arg1+";");
				break;			
			case MAS:
				out.println("  "+res+" = "+arg1+" + "+arg2+";");
				break;
			case MENOS:
				out.println("  "+res+" = "+arg1+" - "+arg2+";");
				break;
			case POR:
				out.println("  "+res+" = "+arg1+" * "+arg2+";");
				break;
			case DIV:
				out.println("  "+res+" = "+arg1+" / "+arg2+";");
				break;
			case IFEQ:
				out.println("  if( "+arg1+" == "+arg2+" ) goto "+res+";");
				break;
			case IFLT:
				out.println("  if( "+arg1+" < "+arg2+" ) goto "+res+";"); 
				break;
			case GOTO:
				out.println("  goto "+res+";");
				break;
			case LABEL:
				out.println(res+":");
				break;							      			
			default:
				out.println("# variable no declarada \nerror; \nhalt;");
		}
	}

	
}
