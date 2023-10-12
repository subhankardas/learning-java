package java_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Support for try-with-resources — introduced in Java 7 — allows us to declare
 * resources to be used in a try block with the assurance that the resources
 * will be closed after the execution of that block.
 * 
 * The resources declared need to implement the 'AutoCloseable' interface.
 * From Java 9 onwards, try-with-resources statements can now declare
 * effectively final resources.
 */
public class TryWithResources {

    public static void main(String[] args) throws Exception {
        System.out.println(read("Before java9!"));
        System.out.println(readJ9("After java9!"));

        autoCloseResource();
    }

    static String read(String data) throws IOException {
        StringReader reader = new StringReader(data);
        BufferedReader bReader = new BufferedReader(reader);
        try (BufferedReader bReaderTemp = bReader) { // Prior to Java 9, resources are to be declared before try or
                                                     // inside try statement.
            return bReaderTemp.readLine();
        }
    }

    static String readJ9(String data) throws IOException {
        StringReader reader = new StringReader(data);
        BufferedReader bReader = new BufferedReader(reader);
        try (bReader) { // Here we need to declare a resource within try statement and then use it.
            return bReader.readLine();
        }
    }

    static void autoCloseResource() throws Exception {
        try (MyResource1 myResource1 = new MyResource1();
                MyResource2 myResource2 = new MyResource2()) { // By order myResource2 is closed first then myResource1
                                                               // is closed. Reverse of order of opening.
            myResource1.read();
            myResource2.read();
        }
    }

}

class MyResource1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closed MyResource1.");
    }

    public void read() {
        System.out.println("Reading MyResource1.");
    }
}

class MyResource2 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closed MyResource2.");
    }

    public void read() {
        System.out.println("Reading MyResource2.");
    }
}