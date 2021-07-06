package CodeTest.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class baepo {

	public static int[] num1() {
		int[] num1 = { 95, 90, 99, 99, 80, 99 };
		return num1;
	}

	public static int[] num2() {
		int[] num2 = { 1, 1, 1, 1, 1, 1 };
		return num2;
	}

	public static int[] num3() {
		int[] num3 = { 1, 3, 2 };
		return num3;
	}

	public static void main(String[] args) {

		int[] progress = num1();
		int[] speed = num2();
		int ac = 0;
		int c = 0;
		int total = 0;
		int[] result = new int[1000];
		for(int a = 0 ; a < 100 ; a++) {
		
		for(int i = 0 ; i < progress.length ; i++) {
			progress[i] += speed[i];
			System.out.println(progress[i]);
		}
		
		for(int j = 0 ; j < progress.length ; j++) {
		if(progress[j] >= 100 && progress[j] <= 20000) {
		System.out.println("들어온값"+progress[j]);
			c++;
			progress[j] +=20000;
		
		}
		}
		if(c>0) {
			result[ac] = c;
			total += c+1;
			System.out.println("토탈"+total);
			c=0;
			ac++;
	
		}
		if(progress.length == total) {
			System.out.println(total);
			System.out.println(result[0]);
			System.out.println(result[1]);
			System.out.println(result[2]);
			break;
		}
		}

}
}
