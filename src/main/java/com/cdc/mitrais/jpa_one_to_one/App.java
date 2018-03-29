package com.cdc.mitrais.jpa_one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdc.mitrais.jpa_one_to_one.entity.Department;
import com.cdc.mitrais.jpa_one_to_one.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    	EntityManager entitymanager = emFactory.createEntityManager();
    	
    	entitymanager.getTransaction().begin();
    	
    	Department department = new Department();
    	department.setName("Operation & Support");
    	entitymanager.persist(department);
    	
    	Employee employee = new Employee();
    	employee.setEname("Awadh Pandey");
    	employee.setSalary(45000);
    	employee.setDeg("Manager");
    	employee.setDepartment(department);
    	entitymanager.persist(employee);
    	
    	entitymanager.getTransaction().commit();
    }
}
