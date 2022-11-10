package Dummy.employee.request.Builder;

import Dummy.employee.request.EmployeeRequest;

public class BuildNewEmployeeMale extends EmployeeRequestBuilder {

    public BuildNewEmployeeFake(){
        super.employee=new EmployeeRequest();
    }

    @Override
    public void Buildname() {
        employee.setName(faker.internet().emailAddress());
    }

    @Override
    public void Buildsalary()  {
        employee.setSalary("20000");
    }
    @Override
    public void Buildage() {
        employee.setAge(faker.number().digit().toString());
    }
}
