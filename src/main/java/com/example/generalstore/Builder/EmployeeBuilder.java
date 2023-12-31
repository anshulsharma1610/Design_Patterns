package com.example.generalstore.Builder;


import com.example.generalstore.ConvertUtility;
import com.example.generalstore.Employee;
import com.example.generalstore.Factory_Pattern.EmployeeFactory;

public class EmployeeBuilder implements BuilderAPI<Employee>{
	
	private int id;
	private String firstName;
	private String lastName;
	private int manufacturerRegistrationAge;
	private double wage;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getManufacturerRegistrationId() {
		return manufacturerRegistrationAge;
	}

	public void setManufacturerRegistrationId(int manufacturerRegistrationAge) {
		this.manufacturerRegistrationAge = manufacturerRegistrationAge;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public EmployeeBuilder(int id,int manufacturerRegistrationId,String firstName, String lastName, double wage) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manufacturerRegistrationAge = manufacturerRegistrationAge;
		this.wage=wage;
	}

	public EmployeeBuilder(String s) {
		String[] tokens=s.split(",");
		this.id= ConvertUtility.StringToInt(tokens[0]);
		this.firstName=tokens[1];
		this.lastName=tokens[2];
		this.manufacturerRegistrationAge=ConvertUtility.StringToInt(tokens[3]);
		this.wage=ConvertUtility.StringToDouble(tokens[4]);
	}

	@Override
	public Employee build() {
		// TODO Auto-generated method stub
		return EmployeeFactory.getInstance().getObject(this);
	}
}
