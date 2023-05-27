package pro.sky.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

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

    private List<Employee> eTest = new ArrayList<>(
            List.of(new Employee("Ivanov", "Ivan", 1, 10000),
                    new Employee("Sidorov", "Sidor", 1, 45833)
            ));

    @InjectMocks
    private DepartmentService ds;

    @Mock
    EmployeeService es;


    @BeforeEach
    void setUp() {
        when(es.returnAll()).thenReturn(employees);
    }



    // Тестирование методов DepartmentService
    @Test
    public void empDepartExtract() {
      assertEquals(ds.empDepartExtract(1), eTest);
    }

    @Test
    public void printAllByDepartTest () {
        HashMap<Integer, List<Employee>> hasTest = (HashMap<Integer, List<Employee>>) employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toList()));
        assertEquals(ds.printAllByDepart(), hasTest);
    }

    @Test
    public void findSum() {
        double sum = employees.get(0).getSalary()+employees.get(2).getSalary();
        assertEquals(ds.findSum(1), sum);
    }

    @Test
    public void findMinSalary() {
        assertEquals(ds.findMinSalary(1), Optional.of(employees.get(0).getSalary()));
    }

    @Test
    public void findMaxSalary() {
        assertEquals(ds.findMaxSalary(1), Optional.of(employees.get(2).getSalary()));
    }
}
