package Dummy.employee.request.Builder;

import Dummy.employee.request.EmployeeRequest;
import com.github.javafaker.Faker;


public class BuildNewEmployeeMale extends EmployeeRequestBuilder {
    private static final Faker faker = new Faker();
    public BuildNewEmployeeMale(){
        super.employee=new EmployeeRequest();
    }

     public  void Buildname(){
     employee.setName("Marlon Nieves");
    }

    public void Buildsalary()  {
        employee.setSalary("20000");
    }

    public void Buildage() {
        employee.setAge("22 anios");
    }
}
