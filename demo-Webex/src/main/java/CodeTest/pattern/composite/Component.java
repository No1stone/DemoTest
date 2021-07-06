package CodeTest.pattern.composite;

abstract public class Component {

	public Component(String name) {
	
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Component [name=" + name + "]";
	}
	
	
	
	
}
