package SalesForceTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Login_TC01 extends LoginUtility {

	public static void main(String[] args) {
		
		LocalDate date2 =  LocalDate.now().plusDays(15);
		//DateTimeFormatter.ofPattern("EEEE,dd MM yyyy");
		//DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
		 String a=date2.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"));
		
		System.out.println(a);
		String[] A=date2.toString().split("-");
	//	System.out.println(A[0]+A[1]+A[2]);
			

	}
	

}
