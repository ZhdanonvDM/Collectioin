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

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private final Employee e = new Employee("Ivanov", "Ivan", 1, 10000);

    private Optional<Double> d = Optional.of(e.getSalary());

    private final List<Employee> employees = new ArrayList<>(
            List.of(new Employee("Ivanov", "Ivan", 1, 10000)
            ));
    HashMap<Integer, List<Employee>> hashEmp = new HashMap<>(Map.of(1, employees));
    @InjectMocks
//  @Mock
    private DepartmentService ds;

    @Mock
    EmployeeService es;

    @BeforeEach
    void setUp() {
        when(es.returnAll()).thenReturn(employees);
    }

    @Test
    public void empDepartExtract() {
      assertEquals(ds.empDepartExtract(1), employees);
    }
    @Test
    public void printAllByDepart() {
        assertEquals(ds.printAllByDepart(), hashEmp);
    }
    @Test
    public void findSum() {
        assertEquals(ds.findSum(1), e.getSalary());
    }
    @Test
    public void findMinSalary() {
        assertEquals(ds.findMinSalary(1), Optional.of(e.getSalary()));
    }
    @Test
    public void findMaxSalary() {
        assertEquals(ds.findMaxSalary(1), Optional.of(e.getSalary()));
    }
}
