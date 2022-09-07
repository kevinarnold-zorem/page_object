package com.project;

import org.openqa.selenium.WebDriver;

public class RegisterStep {

    private WebDriver driver;
    RegisterPage registerPage;

    public void setUp() throws Exception{
        registerPage = new RegisterPage(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.visit("");
    }

    public void test() throws InterruptedException {
        registerPage.registerUser();
        System.out.println("Message:"+registerPage.registeredMessage());
    }
}
