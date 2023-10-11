package java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Optional1 {

    public static void main(String[] args) {
        Optional<String> opt = Optional.empty(); // EMPTY OPTIONAL
        System.out.println("Is present: " + opt.isPresent()); // false
        System.out.println("Is empty  : " + opt.isEmpty()); // true

        try {
            System.out.println("Value : " + opt.get()); // NoSuchElementException thrown here for empty optional
        } catch (NoSuchElementException e) {
            System.out.println("Exception : " + e);
        }

        try {
            opt = Optional.of(null); // NullPointerException is thrown here
        } catch (NullPointerException ex) {
            System.out.println("Exception : " + ex);
        }

        Optional<String> nullOpt = Optional.ofNullable(null); // NULL OPTIONAL, no exception is thrown here
        System.out.println("Is present: " + nullOpt.isPresent()); // false
        System.out.println("Is empty  : " + nullOpt.isEmpty()); // true

        Optional<String> emptyOpt = Optional.empty();
        System.out.println("Is null == empty: " + nullOpt.equals(emptyOpt)); // true

        String res = nullOpt.orElse("Default value"); // Here we get default in both null and empty
        System.out.println("Result : " + res);
        res = emptyOpt.orElse("Default value");
        System.out.println("Result : " + res);

        List<String> val = getValOptional().orElseGet(() -> new ArrayList<String>());
        System.out.println("Result : " + val);

        try {
            res = nullOpt.orElseThrow(() -> new RuntimeException("CustomException")); // Throws exception here
        } catch (RuntimeException ex) {
            System.out.println("Exception : " + ex);
        }
    }

    static Optional<List<String>> getValOptional() {
        return Optional.of(Arrays.asList("A", "B", "C"));
    }

}
