package CodeTest.pattern.builder.build02;

public class Computer {

	private String cpu;
	private String ram;
	private String storage;
	public Computer(String cpu, String ram, String strage) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.storage = strage;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String strage) {
		this.storage = strage;
	}
	
	
	
	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", storage=" + storage + "]";
	}

	
	
	
	
	
}
