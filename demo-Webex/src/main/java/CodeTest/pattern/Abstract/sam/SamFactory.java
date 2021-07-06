package CodeTest.pattern.Abstract.sam;

import CodeTest.pattern.Abstract.BikeFactory;
import CodeTest.pattern.Abstract.Body;
import CodeTest.pattern.Abstract.Wheel;

public class SamFactory implements BikeFactory {

	@Override
	public Body createBody() {
		// TODO Auto-generated method stub
		return new SamBody();
	}

	@Override
	public Wheel createWheel() {
		// TODO Auto-generated method stub
		return new SamWheel();
	}

}
