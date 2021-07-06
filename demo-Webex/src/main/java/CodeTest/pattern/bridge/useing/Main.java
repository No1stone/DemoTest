package CodeTest.pattern.bridge.useing;


public class Main {

	public static void main(String[] args) {

		PrintMorseCode code1 = new PrintMorseCode(new DefaultFunction());
		PrintMorseCode code2 = new PrintMorseCode(new SoundFunction());
		PrintMorseCode code3 = new PrintMorseCode(new FlashFunction());
		
		code1.j().a().n().g();
		code2.j().a().n().g();
		code3.j().a().n().g();
		
		}

}
