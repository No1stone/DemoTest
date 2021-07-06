package CodeTest.etc;

public class stringbufferappenderextends1 extends stringbufferappendertest {

	public String testbbb(int a) {
		
		this.ex.append("exteds1 \n");
		
		for(int i = 0 ; i < a ; i++) {
			
			String j = Integer.toString(i);
			this.ex.append(j);
			this.ex.append("extends append \n");	
		}
		System.out.println(this.ex);
		
		return this.getEx().toString();
		}
}
