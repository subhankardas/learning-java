package basics.inheritance;

public class ConstructorChaining {

	public static void main(String[] args) {
		
		Test test1 = new Test(12, 34);
		System.out.println();
		Test test2 = new Test(56);

	}

}

class Test {
	
	int value;
	
	Test() {
		System.out.println("Default constructor");
	}
	
	Test(int val) {
		this();
		System.out.println("Value1: " + val);
	}
	
	Test(int val1, int val2) {
		this(val1);
		System.out.println("Value1: " + val1 + "  Value2: " + val2);
	}
	
}