package CodeTest.pattern.bridge.nan;

public class PrintMorseCode extends MorseCode{
	
	private static final PrintMorseCode PrintMorseCode = null;

	public PrintMorseCode() {}
	
	public PrintMorseCode builder() {
		return new PrintMorseCode();
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
	
	public PrintMorseCode build() {
		return this.PrintMorseCode;
	}
	
}
