package com.testngtutorials.elements;

import org.testng.annotations.DataProvider;

public class DataProviderExample {

    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][]{
                {"user1", "abcd@abcd.com", "Pune"},
                {"user2", "pqrs@pqrs.com", "Mumbai"},
                {"user3", "stuv@stuv.com", "Delhi"}
        };
    }
}