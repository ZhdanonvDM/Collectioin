package pro.sky.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService es;

    public  EmployeeController (EmployeeService es) {
        this.es = es;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping ("/add")
    public Employee add (@RequestParam ("firstName") String firstName,@RequestParam ("lastName") String lastName) {
        return es.addEmployee(lastName,firstName);
    }
    @GetMapping ("/remove")
    public Employee remove (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        return es.removeEmployee(lastName,firstName);
    }
    @GetMapping ("/find")
    public Employee find (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        return es.findEmployee(lastName,firstName);
    }
    @GetMapping ("/returnAll")
    public Collection<Employee> returnAll () {
        return es.returnAll();
    }

}