package CodeTest.pattern.bridge.useing;

public class SoundFunction implements MorseCodeFunction {

	@Override
	public void dot() {

		System.out.print("쩜");
		
	}

	@Override
	public void dash() {
		
		System.out.print("대쉬");
		
	}

	@Override
	public void space() {

		System.out.print(" ");
		
	}

}
