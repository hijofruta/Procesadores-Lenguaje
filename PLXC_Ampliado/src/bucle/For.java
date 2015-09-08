package src.bucle;
import src.Labels;

public class For {
	private Object res;	
	public For(Character oper,Object a,Object b,Labels label,Character part){
		switch(oper) {
			case 'T':
				if(part=='0'){
				FTo t=new FTo(a,b,label);
				res=t.val();
				}else{
					FToSt ts=new FToSt(a,b,label,part);
					res=ts.val();
				}
				break;
			case 'D':
				if(part=='0'){
				FDto d=new FDto(a,b,label);
				res=d.val();
				}else{
					FDtoSt ds=new FDtoSt(a,b,label,part);
					res=ds.val();
				}
				break;
			case 'I':
				FIn fi=new FIn(a,b,label,part);
				res=fi.val();
				break;
			default:				
				break;						
		}
	}
	public Labels res(){
		return (Labels)res;
	}
	public String toString(){
		return res.toString();
	}
}
