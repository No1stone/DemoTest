package CodeTest.nomal;

public class Phonenum {
	
	private String ph1;
	private String ph2;
	private String ph3;
	public Phonenum(String ph1, String ph2, String ph3) {
		super();
		this.ph1 = ph1;
		this.ph2 = ph2;
		this.ph3 = ph3;
	}
	public String getPh1() {
		return ph1;
	}
	public void setPh1(String ph1) {
		this.ph1 = ph1;
	}
	public String getPh2() {
		return ph2;
	}
	public void setPh2(String ph2) {
		this.ph2 = ph2;
	}
	public String getPh3() {
		return ph3;
	}
	public void setPh3(String ph3) {
		this.ph3 = ph3;
	}
	@Override
	public String toString() {
		return "Phonenum [ph1=" + ph1 + ", ph2=" + ph2 + ", ph3=" + ph3 + "]";
	}
	
	
}
