package Dummy.employee.request.Builder;

import Dummy.employee.request.EmployeeRequest;

public class BuildNewEmployee extends EmployeeRequestBuilder {

    public BuildNewEmployee(){
        super.employee=new EmployeeRequest();
    }

    @Override
    public void Buildname() {
        employee.setName("Diego Alejandro");
    }


    @Override
    public void Buildsalary() {
        employee.setSalary("200000");
    }

    @Override
    public void Buildage() {
        employee.setAge("33 años");
    }
}
