package CodeTest.pattern.decorator;

public class Milk extends AbstAdding {

	public Milk(Ibeverage base) {
		super(base);
	}
	@Override
	public int getTotalPrice() {
		// TODO Auto-generated method stub
		return super.getTotalPrice()+50;
	}
	
	
}
