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

    public HashMap<Integer, List<Employee>> printAllByDepart() {
/*        List<Employee> l = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>(
                employees.stream()
                        .map(e -> e.getDepartment())
                        .collect(Collectors.toList())
                );*/
        return (HashMap<Integer, List<Employee>>) employees.stream()
                        .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.toList()));
 //       s.stream().sorted();
/*        for (Integer dep : s) {
            l.addAll(employees.stream()
                    .filter(e -> e.getDepartment() == dep)
                    .collect(Collectors.toList()));
        }*/
//        return l;
    }

    public List<Employee> findMinSalary (int departmentId) {
       Optional<Double> min =
                empDepartExtract(departmentId).stream()
                .map(e -> e.getSalary())
                .min(Comparator.naturalOrder());
        return employees.stream().filter(e -> min.get() == e.getSalary())
                .collect(Collectors.toList());
    }
    public List<Employee> findMaxSalary (int departmentId) {
        Optional<Double> max =
                empDepartExtract(departmentId).stream()
                        .map(e -> e.getSalary())
                        .max(Comparator.naturalOrder());
        return employees.stream().filter(e -> max.get() == e.getSalary())
                .collect(Collectors.toList());
    }
 }

