package CodeTest.pattern.Abstract;

import CodeTest.pattern.Abstract.gt.gtFactory;
import CodeTest.pattern.Abstract.sam.SamFactory;

public class Main {

	public static void main(String[] args) {

		//BikeFactory factory = new SamFactory();
		BikeFactory factory = new gtFactory();
		
		Body body = factory.createBody();
		Wheel wheel = factory.createWheel();
	
		System.out.println(body.getClass());
		System.out.println(wheel.getClass());
	}

}
