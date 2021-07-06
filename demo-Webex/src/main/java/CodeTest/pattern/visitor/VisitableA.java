package CodeTest.pattern.visitor;

public class VisitableA implements Visitable {

	int numberOfMember;

	public VisitableA(int numberOfMember) {
		this.numberOfMember = numberOfMember;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public int getNumberOfMember() {
		return numberOfMember;
	}

	public void setNumberOfMember(int numberOfMember) {
		this.numberOfMember = numberOfMember;
	}
	
	
}
