package labs.lab1_java8;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import labs.data.employee.Employee;
import labs.data.employee.EmployeeDB;

/**
 * LAB PRACTICE 2:
 * Solving Real Time Queries Using Java 8 Features -Employee Management System.
 * Ref:
 * https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
 */
public class StreamQueries2 {

    public static void main(String[] args) {
        Query11();
        Query12();
        Query13();
        Query14();
        Query15();
    }

    // Query 11 : What is the average salary of male and female employees?
    public static void Query11() {
        Map<String, Double> avgSalByGender = EmployeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        // group by gender and averaging by salary
    }

    // Query 12 : List down the names of all employees in each department?
    public static void Query12() {
        Map<String, List<Employee>> grpByDept = EmployeeDB.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        // group by department
    }

    // Query 13 : What is the average salary and total salary of the whole
    // organization?
    public static void Query13() {
        DoubleSummaryStatistics stats = EmployeeDB.getEmployees().stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary)); // collect complete statistics for salary
        double avgSalary = stats.getAverage();
        double totalSalary = stats.getSum();
    }

    // Query 14 : Separate the employees who are younger or equal to 25 years from
    // those employees who are older than 25 years.
    public static void Query14() {
        Map<Boolean, List<Employee>> grpByAge = EmployeeDB.getEmployees().stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        // partitioning by age, true = age>25, false=age<=25
    }

    // Query 15 : Who is the oldest employee in the organization? What is his age
    // and which department he belongs to?
    public static void Query15() {
        Optional<Employee> oldestEmp = EmployeeDB.getEmployees().stream()
                .max(Comparator.comparingInt(Employee::getAge)); // collect max by age
        String dept = oldestEmp.get().getDepartment();
    }

}
