package CodeTest.pattern.singleton;

public class Application {

	public static void main(String[] args) {
		
		SomeSystemComponent component1 = SomeSystemComponent.getInstance();
		SomeSystemComponent component2 = SomeSystemComponent.getInstance();
		
		component1.setVolume(11);
		
		System.out.println(component1.getVolume());
		System.out.println(component2.getVolume());
		
	}

}
