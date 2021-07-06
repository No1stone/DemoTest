package CodeTest.pattern.bridge.useing;

public class MorseCode {

	private MorseCodeFunction function;
	
	public MorseCode(MorseCodeFunction function) {
		super();
		this.function = function;
	}

	public void dot() {
		function.dot();
	}

	public void dash() {
		function.dash();
		}

	public void space() {
		function.space();
	}

}
