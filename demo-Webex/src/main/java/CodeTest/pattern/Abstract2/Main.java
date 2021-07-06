package CodeTest.pattern.Abstract2;

import CodeTest.pattern.Abstract2.abs.Button;
import CodeTest.pattern.Abstract2.abs.GuiFac;
import CodeTest.pattern.Abstract2.abs.TextArea;
import CodeTest.pattern.Abstract2.concreate.FactoryInstance;

public class Main {

	public static void main(String[] args) {
	GuiFac fac = FactoryInstance.getGuiFac();

	
	Button button = fac.createButton();
	TextArea area = fac.createTextArea();
	
	button.click();
	System.out.println(area.getText());
	System.out.println(System.getProperty("os.name"));
	
	
	
	
	}

}
