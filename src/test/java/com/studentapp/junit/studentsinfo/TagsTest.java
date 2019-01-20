package com.studentapp.junit.studentsinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Nishant on 1/19/2019.
 */
@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
@Title("Provide 405 code when incorrect HTTP method is used to access a resource")
    @Test
    public void invalidMethod(){
    SerenityRest.rest().given().when().post("/list")
            .then()
            .statusCode(405)
            .log().all();

}


}
