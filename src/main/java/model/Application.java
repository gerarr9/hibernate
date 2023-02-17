package model;

import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;

public class Application {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        //employeeDao.add(new Employee("Руби","Буби","W",21,2));
        employeeDao.findAll().forEach(System.out::println);
        //employeeDao.deletedById(8);
        employeeDao.findAll().forEach(System.out::println);
        System.out.println(employeeDao.getById(7));

    }
}
