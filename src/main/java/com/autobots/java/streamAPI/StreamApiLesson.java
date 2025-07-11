package com.autobots.java.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiLesson {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");

//        List<String> names2 = new ArrayList<>();
//        for (String name : names2){
//            if (name.startsWith("A"))
//                names2.add(name.toUpperCase());
//            Collections.sort(names2);
//        }

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5,6);

        int totalSum = numbers.stream()
                .mapToInt(num -> num)
                .sum();

        System.out.println(totalSum);

        int totalElements = (int)numbers.stream()
                .count();

        System.out.println(totalElements);

        numbers.stream()
                .min(Integer :: compareTo)
                .ifPresent(System.out::println);

        List<String> list = List.of("one", "two", "three", "Hello", "four","five");

        list.stream()
                .filter(s -> s.length() > 3)
                .findFirst()
                .ifPresent(System.out::println);

        List<Employee> employees = List.of(new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT"));

        System.out.println(employees);

        List<Employee> itEmployees = employees.stream()
                .filter(s -> s.getDepartment().equalsIgnoreCase("IT"))
                .collect(Collectors.toList());

        System.out.println(itEmployees);

        List<Employee> itEmployees2 = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getDepartment().equalsIgnoreCase("IT")){
                itEmployees2.add(employee);
            }
        }
        System.out.println(itEmployees2);

        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDepartment.forEach((department, list1) -> {
                System.out.println("Otdel: " + department);
        list1.forEach(System.out::println);
        });

        Map<String, List<Employee>> employeesByDepartment1 = new HashMap<>();

        for (Employee employee : employees){
            employeesByDepartment1.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeesByDepartment1.get(employee.getDepartment()).add(employee);
        }

        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment1.entrySet()){
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
        System.out.println(employeesByDepartment1);
    }
}
