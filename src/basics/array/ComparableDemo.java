package basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo program for usage of comparable interface
 * and sort using Arrays utility sort.
 */
public class ComparableDemo {

	public static void main(String[] args) {
		
		// Populate the list of users
		List<User> users = new ArrayList<>();
		users.add(new User(2, "Subhankar"));
		users.add(new User(4, "Chayan"));
		users.add(new User(1, "Deepayan"));
		users.add(new User(3, "Ajit"));
		
		// Print all users
		users.forEach(user -> System.out.println(user));
		System.out.println("------------------------------");
		
		// Convert list to array and sort
		Object[] arr = users.toArray();
		Arrays.sort(arr);
		
		// Print sorted array
		for (Object ar : arr) {
			System.out.println(ar);
		}
		
	}

}


/**
 * Using Comparable interface
 */
class User implements Comparable<User> { 
	
	int id;
	String name;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(User user) {
		return id - user.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}

