package java_9;

import java.util.List;
import java.util.Set;

public class ImmutableCollections {

    public static void main(String[] args) {
        List<String> immutableList = List.of("Item 1", "Item 2", "Item 3");
        try {
            immutableList.add("Item 4"); // UnsupportedOperationException is thrown here
        } catch (UnsupportedOperationException e) {
            System.out.println("Unable to add to immutable list.");
        }

        Set<String> immutableSet = Set.of("Item 1", "Item 2", "Item 3");
        try {
            immutableSet.remove("Item 4"); // UnsupportedOperationException is thrown here
        } catch (Exception e) {
            System.out.println("Unable to remove from immutable set.");
        }
    }

}
