package pro.sky.Collection;

import org.springframework.stereotype.Service;
import pro.sky.Collection.exception.EmployeeAlreadyAddedException;
import pro.sky.Collection.exception.EmployeeNotFoundException;
import pro.sky.Collection.exception.EmployeeStorageIsFullException;

import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>(
            List.of(new Employee("Ivanov", "Ivan", 1, 10000),
                    new Employee("Petrov", "Petr", 3, 34734),
                    new Employee("Sidorov", "Sidor", 1, 45833),
                    new Employee("Shevnin", "Sergey", 4, 49321),
                    new Employee("Nesterova", "Olga", 2, 72882),
                    new Employee("Isupova", "Ekaterina", 3, 38932),
                    new Employee("Zhdanova", "Olga",4, 24942),
                    new Employee("Luginina", "Ann", 3, 98352),
                    new Employee("Simakov", "Vladimir", 2, 195935),
                    new Employee("Degtyarev", "Ivan", 5, 632858)
            ));

    public List<Employee> empDepartExtract(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public List<Employee> printAllByDepart() {
        List<Employee> l = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>(
                employees.stream()
                        .map(e -> e.getDepartment())
                        .collect(Collectors.toList())
                );
        s.stream().sorted();
        for (Integer dep : s) {
            l.addAll(employees.stream()
                    .filter(e -> e.getDepartment() == dep)
                    .collect(Collectors.toList()));
        }
        return l;
    }

    public List<Employee> findMinSalary (int departmentId) {
        List<Double> min =  empDepartExtract(departmentId).stream()
                .map(e -> e.getSalary())
                .collect(Collectors.toList());
        return employees.stream().filter(e -> e.getSalary() == Collections.min(min)).collect(Collectors.toList());
    }
    public List<Employee> findMaxSalary (int departmentId) {
        List<Double> max =  empDepartExtract(departmentId).stream()
                .map(e -> e.getSalary())
                .collect(Collectors.toList());
        return employees.stream().filter(e -> e.getSalary() == Collections.max(max)).collect(Collectors.toList());
    }
 }

