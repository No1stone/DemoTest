package CodeTest.codingtest;

import java.util.Arrays;

public class KKbunjjeaSu {
	

	public static int[] SolutionA(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i = 0 ; i < commands.length ; i++) {
			int[] temp=Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			System.out.println(temp=Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]));
			System.out.println(String.format("어레이: %s",(String)array.toString()));
			System.out.println(String.format("코만즈[%d][0]: %d",i,commands[i][0]-1));
			System.out.println(String.format("코만즈[%d][1]: %d",i,commands[i][1]));
			System.out.println(temp.toString());
			Arrays.sort(temp);
			System.out.println(temp.toString());
			
			answer[i]=temp[commands[i][2]-1];
		}
		
		return answer;
	}
	
public static void main(String[] args) {
	int[] answer = {};
	int[] array = {1,5,2,6,3,7,4};
	int[][] commands = {
			{2,5,3},
			{4,4,1},
			{1,7,3}
	};
	
	SolutionA(array, commands);
	System.out.println(SolutionA(array, commands).toString());

		
}



}
