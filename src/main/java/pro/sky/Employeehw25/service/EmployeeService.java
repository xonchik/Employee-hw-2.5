package pro.sky.Employeehw25.service;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);

    Employee searchEmployee(String firstName, String lastName);

    void deleteEmployee(String firstName, String lastName);

    void getAllEmployee();
}
