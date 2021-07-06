package CodeTest.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class munjayul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] munja = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

		String n;
		char temp;
		
		for(int i = 0 ; i < munja.length/2 ; i++) {
			
			temp = munja[i];
			System.out.print(temp);
			
			munja[i] = munja [munja.length-i-1];
			System.out.print(munja[i]);
			
			munja[munja.length-i-1] = temp;
			System.out.println(munja[munja.length-i-1]);
			
		}
		n = new String(munja);
		System.out.println(munja);

		
	}

}
