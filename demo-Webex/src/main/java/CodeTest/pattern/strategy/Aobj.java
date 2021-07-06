package CodeTest.pattern.strategy;

public class Aobj {

	Ainterface ainterface;
	
	
	
	public Aobj(Ainterface ainterface) {
		super();
		this.ainterface = ainterface;
	}



	public void funcAA() {
		
		ainterface.funcA();
		ainterface.funcA();
		
		System.out.println("AAA");
		System.out.println("BBB");

	
	}
	
}
