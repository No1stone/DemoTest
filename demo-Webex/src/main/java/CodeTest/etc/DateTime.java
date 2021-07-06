package CodeTest.etc;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Date1 = "2021-05-24 15:48:39";
		LocalDateTime validDateTime = LocalDateTime.parse(Date1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		
		
		System.out.println(validDateTime);
		System.out.println(LocalDateTime.now());
		System.out.println(validDateTime.plusMinutes(2));
		
		
		System.out.println(validDateTime.plusMinutes(2).isAfter(LocalDateTime.now()));
		System.out.println(validDateTime.plusMinutes(70).isAfter(LocalDateTime.now()));
		
		if(validDateTime.plusMinutes(60).isBefore(LocalDateTime.now())) {
			System.out.println("이거출력?");
		}
		
		
		
	}

}
