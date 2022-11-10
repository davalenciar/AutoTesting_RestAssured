package Dummy.Post.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequest{

	@JsonProperty("name")
	private String name;

	@JsonProperty("salary")
	private String salary;

	@JsonProperty("age")
	private String age;

	public String getName(){
		return name;
	}

	public String getSalary(){
		return salary;
	}

	public String getAge(){
		return age;
	}
}