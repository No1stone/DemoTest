package cote;

public class Cote {
	public static void main(String[] args) {

		
		int nums[] = {1,2,3,4,5,6,7,8,9,10} ;
		int count = 0;
		int su = 0;
		
		for(int i = 1 ; i < nums.length ; i++) {
			for( int j = i + 1 ; j < nums.length-1 ; j++ ){
				for( int k = j + 1 ; k < nums.length-2 ; k++ ){
					su = nums[i] + nums[j] + nums[k] ;
					if(su % i == 0 ) {
						
						count+=1;
					
					}
					
				}	
			}
		}
		
		System.out.println(count);
	}
}
