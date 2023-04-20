package pro.sky.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService es;

    public  EmployeeController (EmployeeService es) {
        this.es = es;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping ("/min-salary")
    public List<Employee> findMinSalary (@RequestParam ("departmentId") int departmentId) {
        return es.findMinSalary(departmentId);
    }
    @GetMapping ("/max-salary")
    public List<Employee> findMaxSalary (@RequestParam ("departmentId") int departmentId) {
        return es.findMaxSalary(departmentId);
    }
    @GetMapping(value = "/all", params = {"departmentId"})
    public List<Employee> findAllEmpByDepart (@RequestParam ("departmentId") int departmentId) {
        return es.empDepartExtract(departmentId);
    }
    @GetMapping ("/all")
    public Collection<Employee> all () {
        return es.printAllByDepart();
    }

}