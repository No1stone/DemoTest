package CodeTest.codingtest;

import java.util.*;

public class GajangKensu {

	public static int[] numbers() {

		int[] number = { 3, 30, 34, 5, 9 };

		return number;
	}

	public static void main(String[] args) {

		int[] numbers = numbers();
		List<Integer> tem10 = new ArrayList<>();
		List<Integer> tem1 = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 9) {
				tem10.add(numbers[i]);
			} else {
				tem1.add(numbers[i]);
			}

		}
		
		tem1.sort(Collections.reverseOrder());
		tem10.sort(Collections.reverseOrder());
		
		System.out.println(tem1);
		System.out.println(tem10);
		
		StringBuffer st = new StringBuffer();
		
		for(int e : tem1) {
			st.append(Integer.toString(e));
		}
		for(int f : tem10) {
			st.append(Integer.toString(f));
		}
		
		String answer = st.toString();
		
		System.out.println(answer);
		}

}
