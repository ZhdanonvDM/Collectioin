package pro.sky.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService ds;

    public  DepartmentController (DepartmentService ds) {
        this.ds = ds;
    }
    @ResponseStatus(HttpStatus.CREATED)


    @GetMapping("/{id}/employees")
    public List<Employee> findAllEmpByDepart (@PathVariable("id") int departmentId) {
        return ds.empDepartExtract(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Optional<Double> findMinSalaryByDepart (@PathVariable("id") int departmentId) {
        return ds.findMinSalary(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public Optional<Double> findMaxSalaryByDepart (@PathVariable("id") int departmentId) {
        return ds.findMaxSalary(departmentId);
    }
//   @GetMapping(value = "/all", params = {"departmentId"})

    @GetMapping("/{id}/salary/sum")
    public double findSumByDepart (@PathVariable("id") int departmentId) {
//    public List<Employee> findAllEmpByDepart (@RequestParam("departmentId") int departmentId) {
        return ds.findSum(departmentId);
    }
    @GetMapping ("/employees")
    public HashMap<Integer, List<Employee>> all () {
        return ds.printAllByDepart();
    }

}