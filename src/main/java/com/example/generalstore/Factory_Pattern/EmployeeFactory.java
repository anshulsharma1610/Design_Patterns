package com.example.generalstore.Factory_Pattern;


import com.example.generalstore.Builder.BuilderAPI;
import com.example.generalstore.Builder.EmployeeBuilder;
import com.example.generalstore.Employee;

public class EmployeeFactory extends AbstractFactory<Employee> {
	
	private static EmployeeFactory instance;  // Lazy Singleton Factory Class
	
	private  EmployeeFactory() {
		super();
		instance=null;
	}
	
	public static synchronized EmployeeFactory getInstance() {
		if (instance == null) {
			instance = new EmployeeFactory();
		}
		return instance;
	}

	@Override
	public Employee getObject(BuilderAPI<Employee> builder) {
		// TODO Auto-generated method stub
		EmployeeBuilder employeeBuilder=(EmployeeBuilder)builder;
		return new Employee(employeeBuilder);
	}

}
