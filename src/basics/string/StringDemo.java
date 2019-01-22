package basics.string;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringDemo {
	
	public static void main(String args[]) {
		
		byte[] data = {65, 66, 67, 88, 89, 90};
		char[] chars = {'H', 'E', 'Y'};
		
		// Create string from byte[] i.e ASCII values
		String str1 = new String(data);
		
		// Create string from char[]
		String str2 = new String(chars);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("---------------------------");
		
		StringBuffer strBuffer = new StringBuffer("This is a long text!");
		
		System.out.println("Value: " + strBuffer);
		System.out.println("Length: " + strBuffer.length());
		System.out.println("Capacity: " + strBuffer.capacity());
		System.out.println("---------------------------");
		
		String str3 = new String(strBuffer);
		
		System.out.println("Value: " + str3);
		System.out.println("Length: " + str3.length());
		System.out.println("---------------------------");
		
		// Tokenizing string
		StringTokenizer strTokens = new StringTokenizer(str3);
		while (strTokens.hasMoreTokens()) {
			System.out.print("[" + strTokens.nextToken() + "] ");
		}
		
		System.out.println();
		
		// Tokenizing string with delimeter
		strTokens = new StringTokenizer("Some-weird-text-format-extra text with :)", "-");
		strBuffer = new StringBuffer();
		
		while (strTokens.hasMoreTokens()) {
			String value = strTokens.nextToken();
			
			System.out.print("[" + value + "] ");
			strBuffer.append(value);
		}
		
		System.out.println();
		System.out.println(strBuffer);
		System.out.println("---------------------------");
		
		// Joining strings using delimeters
		StringJoiner strJoiner = new StringJoiner("/");
		
		strJoiner.add("Some");
		System.out.println(strJoiner);
		strJoiner.add("random text");
		System.out.println(strJoiner);
		strJoiner.add("joined");
		System.out.println(strJoiner);
		
		strJoiner = new StringJoiner(":", "{", "}");
		
		strJoiner.add("key 1").add("value 1");
		System.out.println(strJoiner);
		
		strJoiner.add("key 2").add("value 2");
		System.out.println(strJoiner);
		
	}
	
}
