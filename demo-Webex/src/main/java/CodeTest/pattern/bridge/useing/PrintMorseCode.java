package CodeTest.pattern.bridge.useing;

public class PrintMorseCode extends MorseCode{
	

	
	public PrintMorseCode(MorseCodeFunction function) {
		super(function);
	}
	public PrintMorseCode j() {
	
		dot();dash();dash();dash();
		System.out.println();
		return this;
	}
	public PrintMorseCode a() {
		dot();dash();
		System.out.println();
		return this;
	}
	public PrintMorseCode n() {
		dash();dot();
		System.out.println();
		return this;
	}
	public PrintMorseCode g() {
		dash();dash();dot();
		System.out.println();
		return this;
	}
	

}
