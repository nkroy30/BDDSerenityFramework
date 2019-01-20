package com.studentapp.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * Created by Nishant on 1/19/2019.
 */


public class ReusableSpecifications {

    public static RequestSpecification requestSpecification;
    public static RequestSpecBuilder rspec;
    public static ResponseSpecification responseSpecification;
    public static ResponseSpecBuilder responseSpecBuilder;

    public static RequestSpecification getGenericRequestSpec(){
        rspec= new RequestSpecBuilder();
        rspec.setContentType(ContentType.JSON);
        requestSpecification = rspec.build();
        return requestSpecification;

    }

    public static  ResponseSpecification getGenericResponseSpec(){
        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Content-Type","application/json;charset=UTF-8");
        responseSpecBuilder.expectHeader("Transfer-Encoding","chunked");
        responseSpecBuilder.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
        responseSpecification = responseSpecBuilder.build();
        return  responseSpecification;
    }

}
