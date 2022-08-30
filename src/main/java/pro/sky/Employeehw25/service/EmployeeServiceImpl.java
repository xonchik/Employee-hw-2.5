package pro.sky.Employeehw25.service;

import org.springframework.stereotype.Service;
import pro.sky.Employeehw25.exception.EmployeeAlreadyAddedException;
import pro.sky.Employeehw25.exception.EmployeeNotFoundException;
import pro.sky.Employeehw25.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            employees.add(employee);
        } else {
            throw new EmployeeAlreadyAddedException("Добовляемый сотрудник уже имеется в списке!");
        }
    };

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return employee;
    };

    @Override
    public void deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            System.out.println("Сотрудник удален!");
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
    };

    @Override
    public void getAllEmployee() {
        System.out.println("Список сотрудников:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }
}
