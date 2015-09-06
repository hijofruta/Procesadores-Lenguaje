package src.cond;
import src.Labels;

public class Cond{
	private Object res;	
	public Cond(char oper,Object a,Object b){
		switch(oper) {
			case '=':
				CEqual e=new CEqual(a,b);
				res=e.val();
				break;
			case '!':
				CNEqual n=new CNEqual(a,b);
				res=n.val();
				break;
			case '<':
				CLt l=new CLt(a,b);
				res=l.val();
				break;
			case 'E':
				CLe le=new CLe(a,b);
				res=le.val();
				break;
			case 'O':
				COr co=new COr(a,b);
				res=co.val();
				break;
			default:
				CAnd ca=new CAnd(a,b);
				res=ca.val();
				break;						
		}
	}
	public Labels res(){
		return (Labels) res;
	}
	
	public String toString(){
		return res.toString();
	}
}
