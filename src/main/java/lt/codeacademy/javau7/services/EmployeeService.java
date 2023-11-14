package lt.codeacademy.javau7.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import lt.codeacademy.javau7.entities.Employees;
import lt.codeacademy.javau7.repositories.EmployeesRepository;

@Service
public class EmployeeService {
    EmployeesRepository employeesRepository;

    EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public String getAll(Model model) {
        model.addAttribute("employees", employeesRepository.findAll());
        return "/employees";
    }

    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeesRepository.findAll());
        return "index";
    }

    public String addEmployee(Employees employees, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-employee";
        }
        employeesRepository.save(employees);
        return "redirect:/";
    }

    public String updateEmployeeForm(long id, Model model) {
        Employees employee = employeesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));

        model.addAttribute("employee", employee);
        return "edit-employees";
    }

    public String updateEmployee(long id, Employees employees, BindingResult result) {
        if (result.hasErrors()) {
            employees.getId();
            return "edit-employees";
        }
        employeesRepository.save(employees);
        return "redirect:/employees";
    }

    public String finEmployeeAndDelete(long id) {
        Employees employees = employeesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeesRepository.delete(employees);
        return "redirect:/employees";
    }

}
