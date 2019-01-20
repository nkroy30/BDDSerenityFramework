package com.studentapp.junit.studentsinfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications;
import com.studentapp.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nishant on 1/17/2019.
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class studentCRUDTest extends TestBase {

    static String firstName="Test" + TestUtils.getRandomValue();
    static String lastName="RestAPI"+ TestUtils.getRandomValue();
    static String programme="Computer Engineering";
    static String email= TestUtils.getRandomValue() + "nishant.sit@gmail.com";
    static int studentId;

    @Steps
    StudentSerenitySteps steps;

    @Title("This Test will create a student")
    @Test
    public void createStudent(){
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Electronics");
        courses.add("Electrical");
        steps.createStudent(firstName,lastName,email,programme,courses)
        .statusCode(201)
                .spec(ReusableSpecifications.getGenericResponseSpec());

    }

@Title("Verify if Student is added to the application")
@Test()
    public void getStudent(){
    HashMap<String,Object> value = steps.getStudentInfoByFirstName(firstName);
    System.out.println("The value of " +  value);

    assertThat(value,hasValue(firstName));
    studentId  =(int)value.get("id");
    System.out.println(studentId);

}

@Title("Update the user information of Student and verify the updated information")
    @Test
    public void test003(){
StudentClass student = new StudentClass();
    ArrayList<String> courses = new ArrayList<>();
    courses.add("Electronics");
    courses.add("Electrical");
    firstName = firstName +"_updated";
    steps.updateStudent(studentId,firstName,lastName,email,programme,courses);
    HashMap<String,Object> value= steps.getStudentInfoByFirstName(firstName);
    assertThat(value,hasValue(firstName));


}

}
