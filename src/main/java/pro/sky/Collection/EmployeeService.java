package pro.sky.Collection;

import org.springframework.stereotype.Service;
import pro.sky.Collection.exception.EmployeeAlreadyAddedException;
import pro.sky.Collection.exception.EmployeeNotFoundException;
import pro.sky.Collection.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<> (
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
    );

    public Employee addEmployee (String lastName, String firstName) {
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        if (employees.size()>100) {
            throw new EmployeeStorageIsFullException();
        }
        Employee e = new Employee(lastName, firstName);
        employees.add(e);
        return e;
    }
    public Employee removeEmployee (String lastName, String firstName) {
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)) {
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

