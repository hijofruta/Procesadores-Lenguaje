import java.io.PrintStream;

public class Generador {
	public static final int MAIN=1;
	public static final int PUS=2;
	public static final int RET=3;
	public static final int LOCAL=4;
	public static final int STACK=5;
	public static final int MUL=6;
	public static final int LOAD=7;
	public static final int MAS=8;
	public static final int MENOS=9;
	public static final int DIV=10;
	public static final int STO=11;
	public static final int DUP=12;
	public static final int POP=13;
	public static final int FUN=14;
	public static final int INV=15;
	public static final int LABEL=16;
	public static final int GOTO=17;
	public static final int IFLT=18;
	public static final int IFGT=19;
	public static final int IFEQ=20;
	public static final int IFNE=21;
	public static final int IFLE=22;
	public static final int IFGE=23;	

	public static int contLabel = 0;
	public static boolean error=true;
	protected static PrintStream out = System.out;
	
	public static boolean Error(){
		return error;
	}
	public static void Noerror(){
		error=false;
	}
	public static String nuevaEtiq() {
		return "L" + contLabel++;
	}

	public static void escribir(int operacion, String arg1) {
		switch(operacion) {
			case MAIN:
				out.println(".method public static main(I)I");
				break;
			case PUS:
				out.println("  sipush "+arg1);
				break;			
			case RET:
				out.println("  ireturn");
				break;
			case STACK:
				out.println("  nop\n  .limit stack "+arg1);
				break;
			case LOCAL:
				out.println("  .limit locals "+arg1+"\n.end method\n");
				break;
			case LOAD:
				out.println("  iload "+arg1);
				break;
			case MUL:
				out.println("  imul");
				break;
			case DIV:
				out.println("  idiv ");
				break;
			case MAS:
				out.println("  iadd");
				break;
			case MENOS:
				out.println("  isub");
				break;
			case STO:
				out.println("  istore "+arg1);
				break;
			case DUP:
				out.println("  dup");
				break;
			case POP:
				out.println("  pop");
				break;
			case FUN:
				out.println(".method public static "+arg1+"(I)I");
				break;
			case INV:
				out.println("  invokestatic JPL/"+arg1+"(I)I");
				break;
			case LABEL:
				out.println(arg1+":");
				break;
			case GOTO:
				out.println("  goto "+arg1);
				break;
			case IFLT:
				out.println("  iflt "+arg1);
				break;
			case IFLE:
				out.println("  ifle "+arg1);
				break;
			case IFGT:
				out.println("  ifgt "+arg1);
				break;
			case IFGE:
				out.println("  ifge "+arg1);
				break;
			case IFNE:
				out.println("  ifne "+arg1);
				break;
			case IFEQ:
				out.println("  ifeq "+arg1);
				break;
			default:
				 System.err.println("error definido");
		}
	}

	
}
