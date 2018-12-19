package basics;

// Simple enum declaration
enum Employee {
	ADMIN, CODER, DESIGNER, TESTER
}

// Enum with constructor and methods
enum Role {
	CEO, CFO, CTO;
	
	private Role() {
		System.out.println("Created " + this);
	}
	
	public void getRole() {
		System.out.println("Role is " + this);
	}
}

// Enum with custom values
enum Salary {
	CEO(12000), CODER(1000);
	
	int salary;
	
	private Salary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return this.salary;
	}
}

public class Enum {

	public static void main(String[] args) {

		Employee emp1 = Employee.CODER;
		Employee emp2 = Employee.DESIGNER;
		
		// Checking on enum values
		if (emp1 == emp2) {
			System.out.println(emp1 + " is same as " + emp2);
		} else {
			System.out.println(emp1 + " is not same as " + emp2);
		}
		
		// Getting all the employee values
		Employee[] employees = Employee.values();
		System.out.println("Employees are: ");
		for (Employee emp: employees) {
			System.out.println(emp);
		}
		
		// Calling enum methods
		Role ceo = Role.CEO;
		ceo.getRole();
		
		// Adding salary
		Salary ceoSalary = Salary.CEO;
		System.out.println("Salary for CEO = " + ceoSalary.salary);
	}

}
