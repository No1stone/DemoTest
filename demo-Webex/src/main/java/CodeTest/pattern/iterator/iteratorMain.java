package CodeTest.pattern.iterator;

import java.util.Iterator;

public class iteratorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IteratorPattern iteratorBuild = new IteratorPattern();
		iteratorBuild.add("test1");
		iteratorBuild.add("test2");
		iteratorBuild.add("test3");

		Iterator<String> iterator = iteratorBuild.iterator();
		while (iterator.hasNext()) {
			String testText = iterator.next();
			System.out.println(testText);
		}
	}
}
