package Dummy.employee.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest{

	@JsonProperty("name")
	private String name;

	@JsonProperty("salary")
	private String salary;

	@JsonProperty("age")
	private String age;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSalary(String salary){
		this.salary = salary;
	}

	public String getSalary(){
		return salary;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}
}