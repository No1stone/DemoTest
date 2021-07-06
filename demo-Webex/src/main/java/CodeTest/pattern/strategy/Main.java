package CodeTest.pattern.strategy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ainterface ainterface = new AinterfaceImpl();
		
		ainterface.funcA();
		Aobj oObj = new Aobj(ainterface);
		
		
		
		
		System.out.println();
	}

}
