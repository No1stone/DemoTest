package CodeTest.pattern.decorator;

public class AbstAdding implements Ibeverage {

	private Ibeverage base;
	
	
	
	public AbstAdding(Ibeverage base) {
		super();
		this.base = base;
	}

	@Override
	public int getTotalPrice() {
		// TODO Auto-generated method stub
		return base.getTotalPrice();
	}

	public Ibeverage getBase() {
		return base;
	}

	public void setBase(Ibeverage base) {
		this.base = base;
	}
	
}
