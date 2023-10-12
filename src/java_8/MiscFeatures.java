package java_8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MiscFeatures {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // New Date and Time API
        LocalDate date = now.toLocalDate();
        LocalTime time = now.toLocalTime();

        System.out.println(date);
        System.out.println(time);

        // Default Methods for Sorting in Collections
        List<String> names = Arrays.asList("Jane", "Bob", "Alice", "Charlie", "John");
        names.sort(Comparator.naturalOrder());
        System.out.println(names);

        names.sort(Comparator.reverseOrder());
        System.out.println(names);
    }

}
