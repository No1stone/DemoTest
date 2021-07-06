package CodeTest.nomal;

public class homenum {

	private String h1;
	private String h2;
	public homenum(String h1, String h2) {
		super();
		this.h1 = h1;
		this.h2 = h2;
	}
	public String getH1() {
		return h1;
	}
	public void setH1(String h1) {
		this.h1 = h1;
	}
	public String getH2() {
		return h2;
	}
	public void setH2(String h2) {
		this.h2 = h2;
	}
	@Override
	public String toString() {
		return "homenum [h1=" + h1 + ", h2=" + h2 + "]";
	}
	
	
	
}
