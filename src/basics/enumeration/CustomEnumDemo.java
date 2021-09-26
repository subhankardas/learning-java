package basics.enumeration;

/**
 * Enumerations serve the purpose of representing a group of named constants in
 * a programming language. Enumerations are constructs used to create user
 * defined data types. It is generally used to represent a group of named
 * constant.
 * 
 * 1. Every enum is internally implemented by using Class.
 * 
 * public static final Simple ABC = new Simple();
 * 
 * public static final Simple DEF = new Simple();
 * 
 * 2. Every enum constant represents an object of type enum.
 * 
 * 3. Enum type can be passed as an argument to switch statement.
 * 
 * 4. Every enum constant is always implicitly public static final. Since it is
 * static, we can access it by using the enum name. Since it is final, we can’t
 * create child enums.
 * 
 * 5. All enums implicitly extend java.lang.Enum class. As a class can only
 * extend one parent in Java, so an enum cannot extend anything else.
 */
public class CustomEnumDemo {

	enum Simple {
		ABC, DEF;
	}

	public static void main(String[] args) {

		// Simple enums, ordinal values and string values
		System.out.println("SIMPLE ENUMS:");
		for (Simple sim : Simple.values()) {
			System.out.println(sim + " = " + sim.ordinal() + "		" + sim.toString());
		}
		System.out.println();

		// Custom enums, ordinal values and string values
		System.out.println("CUSTOM ENUMS:");
		for (Command cmd : Command.values()) {
			System.out.println(cmd + " = " + cmd.getValue() + "	,	VALUE = " + cmd.toString());
		}
		System.out.println();

		// Compares, simply subtracts the ordinal values
		System.out.print(Simple.ABC.compareTo(Simple.ABC) + " "); // -> 0
		System.out.print(Simple.ABC.compareTo(Simple.DEF) + "  \n"); // -> -1

		System.out.print(Command.DELETE.compareTo(Command.DELETE) + "  "); // -> 0
		System.out.print(Command.DELETE.compareTo(Command.SAVE) + "  \n"); // -> 1
		System.out.println();

		// Value of, to convert string to enum
		Command cmd = Command.valueOf("SAVE");
		System.out.println(cmd.getValue() + "	ORDINAL = " + cmd.ordinal()); // SV_DOC ORDINAL = 1

	}

}

enum Command {

	PRINT("PN_DOC"), SAVE("SV_DOC"), DELETE("DL_DOC");

	private String value;

	private Command(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}