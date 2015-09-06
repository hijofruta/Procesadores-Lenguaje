package src.bucle;
import src.Labels;

public class For {
	private Object res;	
	public For(Integer oper,Object a,Object b,Object label){
		switch(oper) {
			case '1':
				FTo t=new FTo(a,b,label);
				res=t.val();
				break;
			case '2':
				FDto d=new FDto(a,b,label);
				res=d.val();
				break;			
			case '3':
				new FToSt(a,b,label);
				res=FToSt.val();
				break;
			case '4':
				new FDtoSt(a,b,label);
				res=FDtoSt.val();
				break;
			case '5':
				FToSt.segundaParte(a,b,label);
				res=FToSt.val();
				break;
			case '6':
				FDtoSt.segundaParte(a,b,label);
				res=FDtoSt.val();
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
