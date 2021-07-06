package CodeTest.etc;

import java.lang.reflect.Method;

public class anotestpint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		anotest ab = new anotest();
		
		try {
			Method method = ab.getClass().getDeclaredMethod("ab");
	
			if(method.isAnnotationPresent(count100.class)) {
				for(int i = 0 ; i < 100 ; i++);
				ab.hello();
			}
			else {
				ab.hello();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
