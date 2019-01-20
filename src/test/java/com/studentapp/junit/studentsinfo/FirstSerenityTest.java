package com.studentapp.junit.studentsinfo;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Nishant on 12/25/2018.
 */
@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost:8080/student/";
    }
   @Title("This is a general information")
    @Test
    public void getAllStudents(){
        SerenityRest.given()
                .when()
                .get("list")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void isTestFailing(){
        SerenityRest.given()
                .when()
                .get("list")
                .then()
                .log()
                .all()
                .statusCode(500);
    }
}
