package com.studentapp.junit.studentsinfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nishant on 1/19/2019.
 */
@Concurrent(threads="2x")
@UseTestDataFrom("testdata/studentInfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest  extends TestBase{
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public StudentSerenitySteps getSteps() {
        return steps;
    }

    public void setSteps(StudentSerenitySteps steps) {
        this.steps = steps;
    }

    @Steps
    StudentSerenitySteps steps;

    @Title("Data Driven Test for adding multiple Students to Student App")
    @Test
    public void createMultipleStudents(){
        ArrayList<String> courses = new ArrayList<>();
        courses.add(course);
        steps.createStudent(firstName,lastName,email,programme,courses)
        .statusCode(201);

    }

}
