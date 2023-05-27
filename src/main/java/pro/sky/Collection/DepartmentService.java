package pro.sky.Collection;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class DepartmentService {

    private final EmployeeService es;

    public  DepartmentService (EmployeeService es) {
        this.es = es;
    }

    public List<Employee> empDepartExtract(int departmentId) {
        return es.returnAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public HashMap<Integer, List<Employee>> printAllByDepart() {
        return (HashMap<Integer, List<Employee>>) es.returnAll().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toList()));
    }
    public Optional<Double> findMinSalary (int departmentId) {
        Optional<Double> min =
                empDepartExtract(departmentId).stream()
                        .map(e -> e.getSalary())
                        .min(Comparator.naturalOrder());
        return min;
    }


    public Optional<Double> findMaxSalary (int departmentId) {
        Optional<Double> max =
                empDepartExtract(departmentId).stream()
                        .map(e -> e.getSalary())
                        .max(Comparator.naturalOrder());
        return max;
    }
    public double findSum (int departmentId) {
        double sum = 0;
        for (Employee e : empDepartExtract(departmentId)) {
            sum = sum + e.getSalary();
        }
        return sum;
    }
}
