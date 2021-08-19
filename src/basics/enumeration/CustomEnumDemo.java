package basics.enumeration;

/**
 * Enums are constructs used to create user defined data types. It is generally
 * used to represent a group of named constant.
 */
public class CustomEnumDemo {

	enum Simple {
		ABC, DEF;
	}

	public static void main(String[] args) {

		System.out.println("SIMPLE ENUMS:");
		for (Simple sim : Simple.values()) {
			System.out.println(sim + " = " + sim.ordinal() + "		" + sim.toString());
		}
		System.out.println();

		System.out.println("CUSTOM ENUMS:");
		for (Command cmd : Command.values()) {
			System.out.println(cmd + " = " + cmd.getValue() + "	,	VALUE = " + cmd.toString());
		}
		System.out.println();

		// Compares, simply subtracts the ordinal values
		System.out.print(Simple.ABC.compareTo(Simple.ABC)); // -> 0
		System.out.print(Simple.ABC.compareTo(Simple.DEF)); // -> -1

		System.out.print(Command.DELETE.compareTo(Command.DELETE)); // -> 0
		System.out.print(Command.DELETE.compareTo(Command.SAVE)); // -> 1
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