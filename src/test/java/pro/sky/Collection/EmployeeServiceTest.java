package pro.sky.Collection;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import pro.sky.Collection.exception.EmployeeAlreadyAddedException;
import pro.sky.Collection.exception.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final Employee e = new Employee("Ivanov", "Ivan", 1, 10000);

    @InjectMocks
//  @Mock
    private EmployeeService es;

   @BeforeEach
    void setUp() {
        es = new EmployeeService();
    }



    @Test
    public void addEmployee () {
    assertThrows(EmployeeAlreadyAddedException.class, () -> {
        es.addEmployee("Ivanov", "Ivan", 1, 10000);
    });
    }

    @Test
    public void removeEmployee () {
        assertThrows(EmployeeNotFoundException.class, () -> {
            es.removeEmployee("Ivanov", "Ivan", 2, 10000);
        });
    }



}
