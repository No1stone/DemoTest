package CodeTest.pattern.decorator;

public class Espresso extends AbstAdding{
	static protected int espressoCount = 0;
	public Espresso(Ibeverage base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getTotalPrice() {
		// TODO Auto-generated method stub
		return super.getTotalPrice()+getAddPrice();
	}
	private int getAddPrice() {
		espressoCount += 1;
		int addPrice = 100;
		
		if(espressoCount > 1) {
			addPrice = 70;
		}
		
		return espressoCount;
	}
	

}
