package basics.misc;

public class SwapObjects {

	public static void main(String[] args) {

		Person person1 = new Person("Amit");
		Person person2 = new Person("Suresh");

		System.out.println("Before swap : " + person1 + "	" + person2);

		// This wont work
		swap(person1, person2);
		System.out.println("After swap 1: " + person1 + "	" + person2);

		// This will work - solution = use wrapper class
		PersonWrapper pwrap1 = new PersonWrapper(person1);
		PersonWrapper pwrap2 = new PersonWrapper(person2);
		swap(pwrap1, pwrap2);
		System.out.println("After swap 2: " + pwrap1.person + "	" + pwrap2.person);

	}

	/**
	 * This swap method wont work as p1, p2 is passed as value i.e. copy of
	 * references are passed to the swap() method.
	 */
	public static void swap(Person p1, Person p2) {
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

	/**
	 * We can swap persons by swapping references of wrapper class.
	 */
	public static void swap(PersonWrapper p1, PersonWrapper p2) {
		Person temp = p1.person;
		p1.person = p2.person;
		p2.person = temp;
	}

}

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class PersonWrapper {
	Person person;

	public PersonWrapper(Person person) {
		this.person = person;
	}
}