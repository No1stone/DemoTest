package CodeTest.pattern.bridge.nan;

public class Main {

	public static void main(String[] args) {

		PrintMorseCode code = new PrintMorseCode();
		
		code.j();code.a();code.n();code.j();
		code.j().a().n().g();
		
		code.builder().j().a().n().g().build();
		System.out.println(code);
	}

}
