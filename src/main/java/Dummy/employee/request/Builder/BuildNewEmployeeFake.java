package Dummy.employee.request.Builder;

import Dummy.employee.request.EmployeeRequest;
import com.github.javafaker.Faker;


public class BuildNewEmployeeFake extends EmployeeRequestBuilder {
    private static final Faker faker = new Faker();

    public BuildNewEmployeeFake(){
        super.employee=new EmployeeRequest();
    }
    public void Buildname() {
        employee.setName(faker.internet().emailAddress());
   }
   // public  void Buildname(){
    // employee.setName("madfdf");
    //}

    public void Buildsalary()  {
        employee.setSalary("20000");
    }

    public void Buildage() {
        employee.setAge(faker.number().digit().toString());
    }
}
