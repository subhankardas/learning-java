package collections;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Custom collection implementation using AbstractCollection.
 */
public class AbstractCollectionDemo {

	public static void main(String[] args) {

		CustomCollection<String> collection = new CustomCollection<>();

		// Adding values to collection
		collection.add("Some");
		collection.add("Dummy");
		collection.add("Text");
		collection.add("Here");

		// Utilities
		System.out.println("Collection : " + collection.toString());
		System.out.println("Contains   : " + collection.contains("Dummy"));
		System.out.println("Size       : " + collection.size());
		System.out.println("Is empty   : " + collection.isEmpty());
		
		// Getting values from iterator
		System.out.print("Iterator   : ");
		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "  ");
		}
		
	}

}

/**
 * Custom collection implementation is easier extending AbstractCollection.
 * AbstractCollection provides skeletal implementation for Collection interface.
 * Custom collection implementation just requires add(), iterator() and size()
 * implementations.
 * 
 * @author Subhankar Das
 */
class CustomCollection<T> extends AbstractCollection<T> {

	List<T> list = new ArrayList<>();

	@Override
	public boolean add(T e) {
		return list.add(e);
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public int size() {
		return list.size();
	}

}
