package src.exp;
import src.Generador;
import src.var.*;

public class Exp{
	private Object res;	
	public Exp(char oper,Object a,Object b,Object ai){
		switch(oper) {
			case '+':
				ESum s=new ESum(a,b);
				res=s.val();
				break;
			case '=':
				EAsig i=new EAsig(a,b);
				res=i.val();
				break;
			case '-':
				EMenos m=new EMenos(a,b);
				res=m.val();
				break;
			case '*':
				EPor p=new EPor(a,b);
				res=p.val();
				break;
			case '/':
				EDiv d=new EDiv(a,b);
				res=d.val();
				break;
			case 'S':
				EMasMas mm=new EMasMas(a,b);
				res=mm.val();
				break;
			case 'R':
				EMenosMenos nn=new EMenosMenos(a,b);
				res=nn.val();
				break;
			case '%':
				EDiv l0=new EDiv(a,b);
				EPor l1=new EPor(b,l0.val());
				EMenos l3=new EMenos(a,l1.val());
				res=l3.val();
				break;
			case 'A':
				EArray ea=new EArray(a,b);
				res=ea.val();
				break;	
			case '.':
				EArray aa=new EArray(a,b,ai);
				res=aa.val();
				break;	
			default:
				ECast c=new ECast(oper,a);
				res=c.val();
				break;
			
		}
	}
	public Variable res(){
		if(Generador.TipoVariable(res)=='V'){
			return (Variable) res;
		}
		return null;		
	}
	public String toString(){
		return res.toString();
	}
}
