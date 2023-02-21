package dao;

import entity.Employee;

import java.util.Collection;

public interface EmployeeDao {
    Collection<Employee> findAll();

    Employee add(Employee employee);
    void deletedById(long id);
    Employee getById(long id);
}
