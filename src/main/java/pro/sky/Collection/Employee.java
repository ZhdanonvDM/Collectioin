package pro.sky.Collection;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;

//    private static int idGenerator;


    public Employee(String lastName, String firstName) {
//        this.id = idGenerator++;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "{" + '\'' + "lastName= " + '\'' + lastName + '\'' +
                ", firstName: '" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}
