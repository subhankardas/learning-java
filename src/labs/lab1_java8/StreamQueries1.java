package labs.lab1_java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import labs.data.employee.Employee;
import labs.data.employee.EmployeeDB;

/**
 * LAB PRACTICE 1:
 * Solving Real Time Queries Using Java 8 Features -Employee Management System.
 * Ref:
 * https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
 */
public class StreamQueries1 {

    public static void main(String[] args) {
        Query1();
        Query2();
        Query3();
        Query4();
        Query5();
        Query6();
        Query7();
        Query8();
        Query9();
        Query10();
    }

    // Query 1 : How many male and female employees are there in the organization?
    public static void Query1() {
        Map<String, Long> countByGender = EmployeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())); // counting by gender

        Map<String, List<Employee>> grpByGender = EmployeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getGender)); // grouping by gender
    }

    // Query 2 : Get the names of all departments in the organization?
    public static void Query2() {
        List<String> deptNames = EmployeeDB.getEmployees().stream()
                .map(Employee::getDepartment) // get department names
                .distinct() // get distinct department names
                .collect(Collectors.toList());
    }

    // Query 3 : What is the average age of male and female employees?
    public static void Query3() {
        Map<String, Double> avgByGender = EmployeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
    } // grouping by gender, average by age

    // Query 4 : Get the details of highest paid employee in the organization?
    public static void Query4() {
        Optional<Employee> highestPaidEmployee = EmployeeDB.getEmployees().stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))); // collect max by salary
    }

    // Query 5 : Get the names of all employees who have joined after 2015?
    public static void Query5() {
        List<String> names = EmployeeDB.getEmployees().stream()
                .filter(e -> e.getYearOfJoining() > 2015) // filter by joining year
                .map(Employee::getName) // map to employee names
                .collect(Collectors.toList());
    }

    // Query 6 : Count the number of employees in each department?
    public static void Query6() {
        Map<String, Long> countByDept = EmployeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    } // group and count by department names

    // Query 7 : What is the average salary of each department?
    public static void Query7() {
        Map<String, Double> avgByDept = EmployeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, // group by department
                        Collectors.averagingDouble(Employee::getSalary))); // average by salary
    }

    // Query 8 : Get the details of youngest male employee in the product
    // development department?
    public static void Query8() {
        Optional<Employee> youngestEmp = EmployeeDB.getEmployees().stream()
                .filter(e -> e.getDepartment().equals("Product Development") && e.getGender().equals("Male"))
                .min(Comparator.comparingInt(Employee::getAge));
        // .collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        // same as above min()
    }

    // Query 9 : Who has the most working experience in the organization?
    public static void Query9() {
        Optional<Employee> seniorEmp = EmployeeDB.getEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)) // sort by joining year ascending
                .findFirst(); // get the first element i.e. earliest joining year
    }

    // Query 10 : How many male and female employees are there in the sales and
    // marketing team?
    public static void Query10() {
        Map<String, Long> countByGender = EmployeeDB.getEmployees().stream()
                .filter(e -> e.getDepartment().equals("Sales And Marketing")) // filter by department
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())); // group by gender, count
    }

}
