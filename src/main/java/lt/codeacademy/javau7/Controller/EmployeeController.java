package lt.codeacademy.javau7.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lt.codeacademy.javau7.entities.Employees;
import lt.codeacademy.javau7.services.EmployeeService;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        return employeeService.getAll(model);
    }

    @GetMapping("/")
    public String getAll(Model model) {
        return employeeService.getAllEmployees(model);
    }

    @GetMapping("/add")
    public String addEmployeeForm(Employees employees) {
        return "add-employee";
    }

    @PostMapping("/addemployees")
    public String addEmployee(@Valid Employees employees, BindingResult result, Model model) {
        return employeeService.addEmployee(employees, result, model);
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable("id") long id, Model model) {
        return employeeService.updateEmployeeForm(id, model);
    }

    @PostMapping("/update/{id}")
    public String updateEmployees(@PathVariable("id") long id, @Valid Employees employees, BindingResult result,
            Model model) {
        return employeeService.updateEmployee(id, employees, result);
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
        return employeeService.finEmployeeAndDelete(id);
    }
}
