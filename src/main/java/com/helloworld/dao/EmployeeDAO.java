package com.helloworld.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;
import com.helloworld.bean.Employee;

import io.dropwizard.hibernate.AbstractDAO;

public class EmployeeDAO extends AbstractDAO<Employee>{

	public EmployeeDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	
	public List<Employee> findAll(){
		return list(namedQuery("com.helloworld.bean.Employee.findAll"));
	}
	
	public List<Employee> findByName(String name){
		StringBuffer sb=new StringBuffer("%");
		sb.append(name).append("%");
		return list(namedQuery("com.helloworld.bean.Employee.findByName")
				.setParameter("name", sb.toString()));
	}
	
	public Optional<Employee> findById(long id){
		return Optional.fromNullable(get(id));
	}
}
