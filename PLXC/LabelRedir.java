/* Clase que agrupa dos etiquetas de inicio y fin */

public class LabelRedir {

	private String ini,fin,v,y;

	public LabelRedir(String a, String b) {
		ini = a;
		fin = b;
		v="";
		y="";
	}

	public void ini(String a) {
		ini = a;
	}

	public void fin(String b) {
		fin = b;
	}
	public void tercera(String b) {
		v= b;
	}
	public void cuarta(String b) {
		y= b;
	}
	public String Labelini() {
		return ini;
	}

	public String Labelfin() {
		return fin;
	}
	public String tercera() {
		return v;
	}
	public String cuarta(){
		return y;
	}
}
