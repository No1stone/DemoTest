package CodeTest.etc;

public class stringbufferappenderextends0 extends stringbufferappendertest {
	
	
	
	public String testaaa(int a) {
		
		this.ex.append("exteds0 \n");
		
		
		for(int i = 0 ; i < a ; i++) {
			
			String j = Integer.toString(i);
			this.ex.append(j);
			this.ex.append("extends append 자식객체 \n");	
		}
		System.out.println(this.ex);
		
		
		return this.getEx().toString();
		}
}
