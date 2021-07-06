package CodeTest.pattern.builder.build02;

public class Main {

	public static void main(String[] args) {

		Computer computer = ComputerBuilder.start().setCpu("i9").setRam("64g").setStorage("").build();

		System.out.println(computer.toString());
		
	}

}
