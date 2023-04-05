package pro.sky.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void addEmployee (String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employees.add(employee);
    }
    public void removeEmployee (String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employees.remove(employee);
    }
    public void findEmployee (String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employees.contains(employee);
    }
}

