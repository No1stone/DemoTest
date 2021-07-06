package CodeTest.switch1;

public class Switchtest {

	public void SwitchInput(String input) {
		
		String output = null ;
		
		switch (input) {
		case "a":
			output = "a";
			System.out.println("ㅁㅁㅁ");

		case "b":
			output = "b";
			System.out.println("ㅠㅠㅠ");
	
		case "c":
			output = "c";
			System.out.println("ㅊㅊㅊ");
			break;
		case "d":
			output = "d";
			System.out.println("111");
			break;
		case "e":
			output = "e";
			System.out.println("111");
			break;
		case "f":
			output = "f";
			System.out.println("111");
			break;
		case "g":
			output = "g";
			break;
		case "h":
			output = "h";
			break;
		case "i":
			output = "i";
			break;

		default:
				output = "default";
			break;
		}
		
		System.out.println("output value:  "+ output);
		
		
	}
	
}
