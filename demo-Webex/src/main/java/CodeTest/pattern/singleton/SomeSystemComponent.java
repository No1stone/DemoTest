package CodeTest.pattern.singleton;

public class SomeSystemComponent {

	static private SomeSystemComponent instance;
	private int volume =0;
	

	
	
	public static SomeSystemComponent getInstance(){
		if (instance == null) {
			
		}else {
			instance = new SomeSystemComponent();
		}
		return instance;
	}
	

	private SomeSystemComponent() {
		volume = 5;
			}

	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}



	
	
}