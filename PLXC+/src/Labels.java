package src;

public class Labels {
	private String uno,dos,tres,cuatro;

	public Labels(String a, String b) {
		uno = a;
		dos = b;
		tres="";
		cuatro="";
	}
	public Labels(String a, String b,String c,String d) {
		uno = a;
		dos = b;
		tres=c;
		cuatro=d;
	}

	public void uno(String a) {
		uno = a;
	}

	public void dos(String b) {
		dos = b;
	}
	public void tres(String b) {
		tres= b;
	}
	public void cuatro(String b) {
		cuatro= b;
	}
	public String uno() {
		return uno;
	}

	public String dos() {
		return dos;
	}
	public String tres() {
		return tres;
	}
	public String cuatro(){
		return cuatro;
	}
	
}
