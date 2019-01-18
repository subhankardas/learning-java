package basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization {
	
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		User user = new User(1, "Subhankar", "password");
		user.serializeData();
		System.out.println(user.deserializeData());
		
	}
	
}

class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String password;
	
	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	/**
	 * Serializes object and writes it to a file.
	 */
	void serializeData() throws FileNotFoundException, IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(this);
		System.out.println("Serialized object...");
		
		objectOutputStream.close();
		fileOutputStream.close();
	}
	
	/**
	 * Reads a file content and de-serializes to an object.
	 */
	User deserializeData() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("data.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		User obj = (User) objectInputStream.readObject();
		System.out.println("Deserialized object...");
		
		objectInputStream.close();
		fileInputStream.close();
		
		return obj;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
