package CodeTest.pattern.builder.build02;


public class ComputerBuilder{

	private Computer computer;
	
	public ComputerBuilder() {
		
		computer = new Computer("default","default","default");
		
	}

	public static ComputerBuilder start() {
		// TODO Auto-generated method stub
		return new ComputerBuilder();
	}
	public ComputerBuilder setCpu(String string) {
		computer.setCpu(string);
		return this;
	}
	public ComputerBuilder setRam(String string) {
		computer.setRam(string);
		return this;
	}

	public ComputerBuilder setStorage(String string) {
		computer.setStorage(string);
		return this;
	}
	public Computer build() {
		return this.computer;
		
	}


	
}
