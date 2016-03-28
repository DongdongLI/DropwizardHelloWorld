package com.helloworld.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.helloworld.bean.Employee;
import com.helloworld.dao.EmployeeDAO;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	
	private EmployeeDAO employeeDAO;

	public EmployeeResource(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@GET
	@UnitOfWork
	public List<Employee> findByName(@QueryParam("name") Optional<String> name){
		if(name.isPresent()){
			return employeeDAO.findByName(name.get());
		}else{
			return employeeDAO.findAll();
		}
	}
	
	@GET
	@Path("/{id}")
	public Optional<Employee> findByd(@PathParam("id") LongParam id){
		return employeeDAO.findById(id.get());
	}
}
