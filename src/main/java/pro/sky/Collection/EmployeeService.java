package pro.sky.Collection;

import org.springframework.stereotype.Service;
import pro.sky.Collection.exception.EmployeeAlreadyAddedException;
import pro.sky.Collection.exception.EmployeeNotFoundException;
import pro.sky.Collection.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
/*    private List<Employee> employees = new ArrayList<> (
            List.of(
                    new Employee("Ivanov", "Ivan"),
                    new Employee("Petrov", "Petr"),
                    new Employee("Sidorov", "Sidor"),
                    new Employee("Shevnin", "Sergey"),
                    new Employee("Nesterova", "Olga"),
                    new Employee("Isupova", "Ekaterina"),
                    new Employee("Zhdanova", "Olga"),
                    new Employee("Luginina", "Ann"),
                    new Employee("Simakov", "Vladimir"),
                    new Employee("Degtyarev", "Ivan")
            )
    );*/

    private Map<String, Employee> employees = new HashMap<>(
            Map.of("Ivanov Ivan", new Employee("Ivanov", "Ivan"),
                    "Petrov Petr", new Employee("Petrov", "Petr"),
                    "Sidorov Sidor", new Employee("Sidorov", "Sidor")
            )
    );

    public Employee addEmployee(String lastName, String firstName) {
        String fullName = lastName + " " + firstName;
        if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee e = new Employee(lastName, firstName);
        employees.put(fullName, e);
        return e;
    }

    public Employee removeEmployee(String lastName, String firstName) {
        String fullName = lastName + " " + firstName;
        Employee e = new Employee(lastName, firstName);
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
            return e;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String lastName, String firstName) {
        String fullName = lastName + " " + firstName;
        Employee e = new Employee(lastName, firstName);
        if (employees.containsKey(fullName)) {
            return e;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> returnAll() {
        return employees.values();
    }

}

