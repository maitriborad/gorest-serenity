package com.gorest.userinfo;

import com.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "8x")
@UseTestDataFrom("src/test/java/resources/testdata/userinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateUserDataDrivenTest extends TestBase {
    private String name;
    private String email;
    private String gender;
    private String status;
    @Steps
    UserSteps userSteps;
    @Title("Data Driven Test for adding multiple users to the application")
    @Test
    public void createMultipleUsers(){
        userSteps.createUser(name,email,gender,status).statusCode(201);
    }
}


