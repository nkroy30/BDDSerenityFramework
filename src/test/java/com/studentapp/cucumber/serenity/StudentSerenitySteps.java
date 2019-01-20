package com.studentapp.cucumber.serenity;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReusableSpecifications;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Nishant on 1/19/2019.
 */
public class StudentSerenitySteps {
    @Step
    public ValidatableResponse createStudent(String firstName,String lastName,String email,String programme,List<String> courses) {

        StudentClass student = new StudentClass() ;
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setProgramme(programme);
        student.setEmail(email);
        student.setCourses(courses);

        return  SerenityRest.rest().given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .body(student)
                .post()
                .then();

   }


   @Step
    public HashMap<String,Object> getStudentInfoByFirstName(String firstName){
       String p1="findAll{it.firstName=='";
       String p2="'}.get(0)";
      return SerenityRest.rest().given()
               .when()
               .get("/list")
               .then()
               .log().all().statusCode(200)
               .extract()
               .path(p1+firstName+p2);


  }

  @Step("Updating student information with studentid:{0},firstName:{1},lastName:{2},email:{3},programme:{4},courses:{5}")
  public ValidatableResponse updateStudent(int studentId,String firstName,String lastName,
                                             String email,String programme,
                                            List<String> courses){
      StudentClass student = new StudentClass();
      student.setFirstName(firstName);
      student.setLastName(lastName);
      student.setEmail(email);
      student.setProgramme(programme);
      student.setCourses(courses);

      firstName = firstName +"_Updated";
      System.out.println(firstName);

      return SerenityRest.rest().given()
              .spec(ReusableSpecifications.getGenericRequestSpec())
              .log()
              .all()
              .when()
              .body(student)
              .put("/" + studentId)
              .then()
              .log()
              .all();
  }

}
