package dao.impl;

import config.HibernateSessionFactoryUtil;
import dao.EmployeeDao;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class EmployeeDaoImpl implements EmployeeDao {

    public Collection<Employee> findAll() {
        Collection<Employee> employees;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = new ArrayList<>(session.createQuery("FROM Employee", Employee.class).list());
            transaction.commit();

        }
        return employees;
    }

    public Employee add(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable id = session.save(employee);
            Employee persistedEmployee = session.get(Employee.class, id);
            transaction.commit();
            return persistedEmployee;

        }
    }

    @Override
    public void deletedById(long id) {
        Employee employee = new Employee();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee persistedEmployee = session.get(Employee.class, id);
            session.delete(persistedEmployee);
            transaction.commit();
        }
    }

    @Override
    public Employee getById(long id) {
        Employee employee = new Employee();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee persistedEmployee = session.get(Employee.class, id);
            transaction.commit();
            return persistedEmployee;
        }
    }
}
