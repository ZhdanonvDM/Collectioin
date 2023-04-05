package pro.sky.Collection;

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
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
