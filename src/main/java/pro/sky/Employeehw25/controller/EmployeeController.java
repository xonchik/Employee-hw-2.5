package pro.sky.Employeehw25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Employeehw25.service.Employee;
import pro.sky.Employeehw25.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/add")
    public String  addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeServiceImpl.addEmployee(firstName, lastName);
        return "<b>Сотрудник добавлен!</b>";
    }

    @GetMapping(path = "/find")
    public String searchEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee employee = employeeServiceImpl.searchEmployee(firstName, lastName);
        return employee.toString();
    }

    @GetMapping(path = "/remove")
    public String deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeServiceImpl.deleteEmployee(firstName, lastName);
        return "<b>Сотрудник удален!</b>";
    }

    @GetMapping(path = "/getAll")
    public void getAllEmployee() {
        employeeServiceImpl.getAllEmployee();
    }
}
