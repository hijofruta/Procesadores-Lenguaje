package src.exp;

public class Exp{
	private Object res;	
	public Exp(char oper,Object a,Object b){
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
			case '%':
				EDiv l0=new EDiv(a,b);
				EPor l1=new EPor(b,l0.val());
				EMenos l3=new EMenos(a,l1.val());
				res=l3.val();
				break;
			default:
				ECast c=new ECast(oper,a);
				res=c.val();
				break;
			
		}
	}
	
	public String toString(){
		return res.toString();
	}
}
