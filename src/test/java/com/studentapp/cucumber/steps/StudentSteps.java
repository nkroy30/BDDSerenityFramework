package com.studentapp.cucumber.steps;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Nishant on 1/20/2019.
 */
public class StudentSteps {

    public static String email;

        @When("^User send a GET request to the list endpoint, they must get back a valid status code 200$")
        public void  Verify_Status_Code_200_for_listendpoint()
        {          // Write code here that turns the phrase above into concrete actions
            SerenityRest.rest()
                    .given()
                    .when()
                    .get("/list")
                    .then()
                    .statusCode(200);


        }

    @Steps
    StudentSerenitySteps steps;

    @When("^I Create a new student by providing the information firstName (.*) lastName (.*) email (.*)programme (.*) course (.*)$")
    public void createStudent(String firstName,String lastName,String _email,String programme,String course){
        List<String> courses = new ArrayList<>();
        courses.add(course);
        email= TestUtils.getRandomValue() + _email;
        System.out.println(email);
        steps.createStudent(firstName,lastName,email,programme,courses)
        .assertThat()
        .statusCode(201);
}

@Then("^I verify tht student is created$")
    public void verifyStudent(String emailId){
       HashMap<String,Object> actualValue =steps.getStudentInfoByFirstName(email);
      assertThat(actualValue,hasValue(email));
}



}
