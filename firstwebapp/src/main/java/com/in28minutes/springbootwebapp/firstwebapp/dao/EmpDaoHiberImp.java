package com.in28minutes.springbootwebapp.firstwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.in28minutes.springbootwebapp.firstwebapp.model.Employee;


@Repository
public class EmpDaoHiberImp implements EmployeeDAO{

	//define field for entityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	public EmpDaoHiberImp(EntityManager theEnityManager) {
		
		entityManager=theEnityManager;
	}
	@Override
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> query=currentSession.createQuery("from Employee",Employee.class);
		
		
		//execute the query and get result list
		List<Employee> employees=query.getResultList();
		
		//return the results
		return employees;
	}
	@Override
	public Employee findById(int theId) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
        // get the Employee
		Employee theEmployee=currentSession.get(Employee.class,theId);
		
		return theEmployee;
	}
	@Override
	public void save(Employee employee) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
	}
	@Override
	public void deleteById(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query query=currentSession.createQuery("delete from Employee where id=:empId");
		
		query.setParameter("empId",theId);
		
		query.executeUpdate();
	}

}
