package CodeTest.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPattern implements Iterable<String> {
	private List<String> list = new ArrayList<String>();

	public void add(String name) {
		list.add(name);
	}

	public Iterator<String> iterator() {
		return new Iterator<String>() {
			int seq = 0;

			public boolean hasNext() {
				return seq < list.size();
			}

			public String next() {
				return list.get(seq++);
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
