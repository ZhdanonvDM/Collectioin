package pro.sky.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pro.sky.Collection.exception.EmployeeAlreadyAddedException;
import pro.sky.Collection.exception.EmployeeNotFoundException;
import pro.sky.Collection.exception.EmployeeStorageIsFullException;

import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
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

    public Employee addEmployee (String lastName, String firstName, int department, double salary) {
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) &&
                    employee.getFirstName().equals(firstName) &&
                    employee.getDepartment() == department &&
                    employee.getSalary() == salary
            ) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        Employee e = new Employee(lastName, firstName, department, salary);
        employees.add(e);
        return e;
    }
    public Employee removeEmployee (String lastName, String firstName, int department, double salary) {
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) &&
                    employee.getFirstName().equals(firstName) &&
                    employee.getDepartment() == department &&
                    employee.getSalary() == salary
            ) {
                employees.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
    public Employee findEmployee (String lastName, String firstName) {
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> returnAll() {
        return employees;
    }

 }

