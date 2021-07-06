package CodeTest.pattern.bridge.useing;

import com.sun.el.lang.FunctionMapperImpl.Function;

public class FlashFunction implements MorseCodeFunction {

	
	
	@Override
	public void dot() {

		System.out.print("반짝");
		
	}

	@Override
	public void dash() {
		
		System.out.print("바안짝");
		
	}

	@Override
	public void space() {

		System.out.print(" ");
		
	}

}
