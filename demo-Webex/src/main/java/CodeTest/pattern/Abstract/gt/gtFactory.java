package CodeTest.pattern.Abstract.gt;

import CodeTest.pattern.Abstract.BikeFactory;
import CodeTest.pattern.Abstract.Body;
import CodeTest.pattern.Abstract.Wheel;

public class gtFactory implements BikeFactory {

	@Override
	public Body createBody() {
		// TODO Auto-generated method stub
		return new gtBody();
	}

	@Override
	public Wheel createWheel() {
		// TODO Auto-generated method stub
		return new gtWheel();
	}

}
