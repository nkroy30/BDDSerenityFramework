package com.studentapp.cucumber;


import com.studentapp.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Nishant on 1/20/2019.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/")

public class StudentRunner extends TestBase
{

}
