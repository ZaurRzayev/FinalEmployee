package com.javaproject.demo.DAO;

import com.javaproject.demo.demoRestAPI.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAO implements IEmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Employee> getAll() {
       Session session= entityManager.unwrap(Session.class);
        List<Employee> employees =session.createQuery("from Employee").getResultList();
        return employees;
    }

    @Override
    public void add(Employee employee) {
        Session session= entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);

    }

    @Override
    public void update(Employee employee) {
        Session session= entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(Employee employee) {
        Session session= entityManager.unwrap(Session.class);
        Employee deleteEmployee=session.get(Employee.class,employee.getId());
        session.delete(deleteEmployee);
    }

    @Override
    public Employee getById(int id) {
        Session session= entityManager.unwrap(Session.class);

        Employee employee=session.get(Employee.class,id);
        return  employee;
    }


}
