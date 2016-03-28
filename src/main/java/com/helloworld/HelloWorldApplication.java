package com.helloworld;

import com.helloworld.bean.Employee;
import com.helloworld.dao.EmployeeDAO;
import com.helloworld.db.GetConfiguration;
import com.helloworld.health.TemplateHealthCheck;
import com.helloworld.resource.EmployeeResource;
import com.helloworld.resource.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<GetConfiguration>{//HelloWorldConfiguration
	
	private final HibernateBundle<GetConfiguration> hibernateBundle=
			new HibernateBundle<GetConfiguration>(Employee.class) {

				@Override
				public DataSourceFactory getDataSourceFactory(GetConfiguration arg0) {
					// TODO Auto-generated method stub
					return arg0.getDataSourceFactory();
				}
			};
	
	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<GetConfiguration> arg0) {
		// TODO Auto-generated method stub
		arg0.addBundle(hibernateBundle);
	}

	@Override
	public void run(GetConfiguration arg0, Environment arg1) throws Exception {
		// TODO Auto-generated method stub
		final EmployeeDAO employeeDAO=new EmployeeDAO(hibernateBundle.getSessionFactory());
		arg1.jersey().register(new EmployeeResource(employeeDAO));
	}

//	@Override
//	public void initialize(Bootstrap<HelloWorldConfiguration> arg0) {
//		// TODO Auto-generated method stub
//		
//	}

	// each application can contain many resources,
	// each resource has its own URL
//	@Override
//	public void run(HelloWorldConfiguration arg0, Environment arg1) throws Exception {
//		// TODO Auto-generated method stub
//		final HelloWorldResource resource=new HelloWorldResource(arg0.getTemplate(), arg0.getDefaultName());
//		
//		final TemplateHealthCheck healthCheck=new TemplateHealthCheck(arg0.getTemplate());
//		arg1.healthChecks().register("template", healthCheck);
//		arg1.jersey().register(resource);
//		
//	}
	
	
}
