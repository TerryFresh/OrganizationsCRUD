package com.example.organizationscrud.dao;

import com.example.organizationscrud.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("FROM Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }


}
