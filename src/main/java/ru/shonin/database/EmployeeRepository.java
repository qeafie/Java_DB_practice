package ru.shonin.database;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    List<Employee> findAllByDepartment(Integer id);
    @Query("Select e.id as id, e.name as name, d.id as DepartmentId, d.name as Department from employee e  join department d on e.department = d.id ")
    List<Employee> findEmployeesWithDepartment();
}
