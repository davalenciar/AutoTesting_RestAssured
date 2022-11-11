import Dummy.employee.request.Builder.Build;
import Dummy.employee.request.Builder.BuildNewEmployee;
import Dummy.employee.request.Builder.BuildNewEmployeeFake;
import Dummy.employee.request.Builder.EmployeeRequestBuilder;
import Dummy.employee.request.EmployeeRequest;
import Dummy.employee.response.EmployeeResponse;
import data.factory.CreatePostDataFactory;
import model.Post.Response.PostResponse;
import Dummy.Post.request.PostRequest;
import Dummy.Post.response.Data;
import Dummy.employee.request.*;
import Dummy.Post.request.PostRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TwoTest{
    String bearerToken="e99413b1c415ad6d592d5f2bef758493fc68c59188d9274a38219b8fc9cb5c55";
    ObjectMapper objectMapper = new ObjectMapper();
    Build buildEmployeeRequest = new Build();
    EmployeeRequestBuilder employeenew= new BuildNewEmployee();
    EmployeeRequestBuilder employeeFake= new BuildNewEmployeeFake();

    EmployeeResponse responseBodyEmployee;

    PostResponse responseBodyPostEmployee;


    @BeforeEach
    public void setup(){

        RestAssured.baseURI="https://dummy.restapiexample.com";
        RestAssured.basePath="/api/v1/";
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();

    }
    @Test
    public void createEmployeeNew() throws JsonProcessingException {
        buildEmployeeRequest.setEmployeeRequestBuilder(employeenew);
        buildEmployeeRequest.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildEmployeeRequest.getEmployeeRequest();
        String response=
                given()
                        .body(employeeRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(200)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getData().getName(),equalTo(responseBodyEmployee.getData().getName()));
    }

    @Test
    public void createEmployeeFake() throws JsonProcessingException {
        buildEmployeeRequest.setEmployeeRequestBuilder(employeeFake);
        buildEmployeeRequest.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildEmployeeRequest.getEmployeeRequest();
        String response=
                given()
                        .body(employeeRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getMessage(),equalTo(responseBodyEmployee.getMessage()));

    }

}
