package CodeTest.handle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class asdqwe {

	public static void main(String[] args) {

		// 수포자1
		List<Integer> supo1 = new ArrayList<>();
		List<Integer> supo2 = new ArrayList<>();
		List<Integer> supo3 = new ArrayList<>();
		List<Integer> supo1Re = new ArrayList<>();
		List<Integer> supo2Re = new ArrayList<>();
		List<Integer> supo3Re = new ArrayList<>();
		
		
		for (int i = 1; i <= 2000; i++) {
			for (int j = 1; j <= 5; j++) {
				supo1.add(j); 
			
			}
		}
		System.out.println(supo1.size());
		
		System.out.println("===========================================");
		System.out.println("===========================================");
		// 수포자2
		for(int i = 0 ; i < 1250 ; i++) {
				supo2.add(2);
				supo2.add(1);
				supo2.add(2);
				supo2.add(3);
				supo2.add(2);
				supo2.add(4);
				supo2.add(2);
				supo2.add(5);
				
		};
		System.out.println(supo2.size());
		System.out.println("===========================================");
		System.out.println("===========================================");
		// 수포자3
		for(int i = 0 ; i < 1000 ; i++) {
				supo3.add(3);
				supo3.add(3);
				supo3.add(1);
				supo3.add(1);
				supo3.add(2);
				supo3.add(2);
				supo3.add(4);
				supo3.add(4);
				supo3.add(5);
				supo3.add(5);
			
		};	
		System.out.println(supo3.size());
		
		
		for(int i = 1 ; i < supo1.size() ; i++) {	
			if(supo1.get(i) == supo2.get(i)) {
				supo1Re.add(supo1.get(i));
			}
		}
		System.out.println(supo1Re.size());
	
	
	int[] ans = {1,2,3,4,5,6,7,8,9,10};
	for(int i = 0 ; i < ans.length ; i++) {	
		if(supo1.get(i) == ans[i]) {
			
			supo1Re.add(supo1.get(i));
			System.out.print(ans[i]);
			
		}
	}
	
	
	}
}
