//import Dummy.employee.request.Builder.*;
import Dummy.employee.request.Builder.*;
import Dummy.employee.request.EmployeeRequest;
import Dummy.employee.response.EmployeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
//import model.Post.Response.PostResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import model.Post.Response.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static data.reader.managerData.getData;
public class DummyRest {
    String bearerToken="e99413b1c415ad6d592d5f2bef758493fc68c59188d9274a38219b8fc9cb5c55";
    ObjectMapper objectMapper = new ObjectMapper();
    Build buildEmployeeRequest = new Build();
    EmployeeRequestBuilder employeenew= new BuildNewEmployee();
    EmployeeRequestBuilder employeemale = new BuildNewEmployeeMale();
    EmployeeRequestBuilder employeeFake= new BuildNewEmployeeFake();

    EmployeeResponse responseBodyEmployee;

    PostResponse responseBodyPostEmployee;
    @BeforeEach
    public void setup(){

        /**Variables de ambiente para probar en su local*/
        RestAssured.baseURI=getData("base.url.dummy");
        RestAssured.basePath=getData("base.path.dummy");

        /**serializacion y refactorizacion de JSONCONTENT*/
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();

    }
    @Test
    @Description("New Employee")
    @Epic("Create EMployee")
    @Feature("Employee")
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
    @Description("Employee Fake")
    @Epic("Create EMployee")
    @Feature("User fake")
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
                        .statusCode(200)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getData().getId(),equalTo(responseBodyEmployee.getData().getId()));
    }
    @Test
    @Description("Masculino")
    @Epic("Create user")
    @Feature("User male")
    public void createEmployeemale() throws JsonProcessingException {
        buildEmployeeRequest.setEmployeeRequestBuilder(employeemale);
        buildEmployeeRequest.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildEmployeeRequest.getEmployeeRequest();
        String response =
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
        assertThat(responseBodyEmployee.getData().getAge(), equalTo(responseBodyEmployee.getData().getAge()));
    }
}
