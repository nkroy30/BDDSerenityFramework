package com.studentapp.testbase;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Created by Nishant on 1/17/2019.
 */
public class TestBase {
    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost:8080/student";
    }

}
