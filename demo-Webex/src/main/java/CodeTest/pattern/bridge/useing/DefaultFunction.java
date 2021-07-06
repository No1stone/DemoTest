package CodeTest.pattern.bridge.useing;

import com.sun.el.lang.FunctionMapperImpl.Function;

public class DefaultFunction implements MorseCodeFunction {

	
	
	@Override
	public void dot() {

		System.out.print(".");
		
	}

	@Override
	public void dash() {
		
		System.out.print("-");
		
	}

	@Override
	public void space() {

		System.out.print(" ");
		
	}

}
