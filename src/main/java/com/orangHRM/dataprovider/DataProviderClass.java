package com.orangHRM.dataprovider;

public class DataProviderClass {

    @org.testng.annotations.DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return new Object[][] {
            { "Admin", "pass1" },
            { "user2@example.com", "pass2" },
            { "user3@example.com", "pass3" }
        };
    }
}
