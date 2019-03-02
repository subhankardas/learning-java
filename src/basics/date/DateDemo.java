package basics.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		
		// Exact same output e.x Sat Mar 02 19:47:57 IST 2019
		System.out.println("Date:  " + calendar.getTime());
		System.out.println("Date:  " + date);
		System.out.println();
		
		// Getting the time zone
		TimeZone timeZone = calendar.getTimeZone();
		System.out.println("Timezone ID: " + timeZone.getID());
		System.out.println("Timezone   : " + timeZone.getDisplayName());
		System.out.println();
		
		// Get current timestamp
		Date date1 = new Timestamp(System.currentTimeMillis());
		Thread.sleep(1000); // Intentional delay
		Date date2 = new Timestamp(System.currentTimeMillis()); 
		System.out.println("Start: " + date1);
		System.out.println("End  : " + date2);
		System.out.println();
		
		// Supported Locales 
		Locale[] locales = Calendar.getAvailableLocales();
		System.out.println("No. of locales: " + locales.length);
		
		// Formatting timestamp i.e March 2019/03/03 12:29:48 AM
		String timestamp = new SimpleDateFormat("MMMM yyyy/MM/dd hh:mm:ss a").format(new Date());
		System.out.println("Formatted : " + timestamp);
		System.out.println();
		
		// Converting Java timestamp to SQL timestamp
		Date timestamp1 = new Date();
		java.sql.Timestamp timestamp2 = new java.sql.Timestamp(timestamp1.getTime());
		
		System.out.println("Java: " + timestamp1);
		System.out.println("SQL : " + timestamp2);
		System.out.println();
		
		// Date before and after
		System.out.print(date1 + " after " + date2 + "  : ");
		System.out.println(date1.after(date2));
		System.out.print(date1 + " before " + date2 + " : ");
		System.out.println(date1.before(date2));
		System.out.println();
		
		// LocaleDate usage
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1993, Month.MARCH, 18);
		Period period = Period.between(birthday, today);
		long days = ChronoUnit.DAYS.between(birthday, today);
		
		System.out.println("Local Date: " + today);
		System.out.println("Age: " + period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days");
		System.out.println("Age: " + days + " days on Earth!");
		
	}

}
