package CodeTest.handle;

public class handlecontroll {
	
	public String Chating(String getService) {
	
		String setText;
		
        if(getService.equals("function-assignment")) {	
        	System.out.println("getService assignment Return");    
        	setText = "function-assignment";
        	return setText;
        	}
        else if(getService.equals("function-help")) {
        	System.out.println("getService help Return");   
         	setText = "function-help";
        	return setText;
        }
		
		switch (getService) {
		case "function-schedule":
			setText = "function-schedule";
		break;

		case "function-lecture":
			setText = "function-lecture";
			break;

		case "function-meeting":
			setText = "function-meeting";
			break;

		case "function-attendance":
			setText = "function-attendance";
			break;
		case "function-test":
			setText = "function-test";
			break;
		case "function-survey":
			setText = "function-survey";
			break;
		case "function-teamactivity":
			setText = "function-teamactivity";
			break;
		case "function-grade":
			setText = "function-grade";
			break;			
			
		default: setText = "function-grade";
			break;
		}
		
		System.out.println("SetText print: "+setText);
		return "";
	}
	
}
