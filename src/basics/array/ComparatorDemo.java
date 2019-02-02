package basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("Subhankar", 75.4f));
		students.add(new Student("Deepayan", 93.2f));
		students.add(new Student("Ajit", 75.6f));
		students.add(new Student("Chayan", 80.3f));
		
		students.forEach(student -> System.out.println(student));
		System.out.println("-------------------------------------------");
		
		Comparator<Student> comparator = new StudentComparator();
		Collections.sort(students, comparator);
		
		students.forEach(student -> System.out.println(student));
	}

}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		return ((int)(student1.marks - student2.marks));
	}
	
}

class Student {
	
	String name;
	float marks;
	
	public Student(String name, float marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
	
}