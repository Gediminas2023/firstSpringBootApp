package lt.codeacademy.javau7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.javau7.entities.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

}
