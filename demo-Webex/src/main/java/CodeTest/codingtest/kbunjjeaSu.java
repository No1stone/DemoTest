package CodeTest.codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kbunjjeaSu {

	public static int ob(int[] su,int i, int j, int k) {
		
		
		int b,c;
		b=0;
		c=0;
				
		
		Map<Integer,Integer> l = new HashMap<>();
		
		for(int a = 0 ; a < su.length ; a++) {
			l.put(a, su[a]);
		}
		
		for(int a = 0 ; a < su.length ;a++) {
			if(l.get(a)==i) {
				b = a;
			}
			if(l.get(a)==j) {
				c = a;
			}
		}
		
		int answer[];
		
		List<Integer> so = new ArrayList<>();
		for(int a = b ; a <= c ; a++) {
			 so.add(l.get(a)); 

		}
		Collections.sort(so);
		
		
		System.out.println("출력값: "+so.get(k-1));
		
		return so.get(k-1);
	}
	
	
	
	public static void main(String[] args) {
	int[] su = {5,2,3,4,9,6,7,8,1};
	int[][] su1= {
			{5,6,1},
			{5,7,1},
			{5,8,2}
	}; 
	int[] answer = new int[100];

	
	
	System.out.println(su1.length);
	int len = su1.length;
	int i,j,k;
	for(int d = 0 ; d < len ; d++) {
		i = su1[d][0];
		j = su1[d][1];
		k = su1[d][2];
		
		int b,c;
		b=0;
		c=0;
				
		
		Map<Integer,Integer> l = new HashMap<>();
		
		for(int a = 0 ; a < su.length ; a++) {
			l.put(a, su[a]);
		}
		
		for(int a = 0 ; a < su.length ;a++) {
			if(l.get(a)==i) {
				b = a;
			}
			if(l.get(a)==j) {
				c = a;
			}
		}
		
		
		List<Integer> so = new ArrayList<>();
		for(int a = b ; a <= c ; a++) {
			 so.add(l.get(a)); 

		}
		Collections.sort(so);
		
	
		
		answer[d] =  so.get(k-1);
		System.out.println(answer[d]);
	}
	

	
	

	}

}
