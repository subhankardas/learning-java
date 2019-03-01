package basics.misc;

import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		
		String regex1 = "^[a-zA-Z]*$"; 
		
		String str1 = "ABCD";
		String str2 = "AB12CD";
		
		// Check if string has only alphabets
		System.out.println(str1 + " matches " + regex1 + ": " + str1.matches(regex1));
		System.out.println(str2 + " matches " + regex1 + ": " + str2.matches(regex1));
		System.out.println();
		
		System.out.println(str1 + " matches " + regex1 + ": " + Pattern.matches(regex1, str1));
		System.out.println(str2 + " matches " + regex1 + ": " + Pattern.matches(regex1, str2));
		System.out.println();
		
		// Check for a substring in a string
		String str3 = "This is a long text with content";
		String str4 = "This is simple text";
		
		String regex2 = ".* simple .*";
		
		System.out.println("Result 1: " + Pattern.matches(regex2, str3));
		System.out.println("Result 2: " + Pattern.matches(regex2, str4));
	}

}
