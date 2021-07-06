package CodeTest.codingtest;

import java.util.Arrays;

public class NotComplete {
	public static String[] Value1() {

		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };

		return participant;
	}

	public static String[] Value2() {

		String[] completion = { "josipa", "filipa", "marina", "nikola" };

		return completion;
	}

	public static void main(String[] args) {

		String[] participant = Value1();
		String[] completion = Value2();
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for(int i = 0 ; i<completion.length ; i++) {
			if(!participant[i].equals(completion[i])) {
				answer = participant[i];
			}
		}
		if (answer.equals("")) {
			answer = participant[participant.length-1];
		}
		
		
//		List<String> par = Arrays.asList(participant);
//		List<String> com = Arrays.asList(completion);
//
//		Collections.sort(par);
//		Collections.sort(com);
//
//		for (int i = 0; i < com.size(); i++) {
//			if (par.get(i).equals(com.get(i))) {
//			} else {
//				answer = par.get(i);
//			}
//		}
//		if (answer.equals("")) {
//			answer = par.get(par.size() - 1);
//		}
//
//		System.out.println(answer);
	}

}
