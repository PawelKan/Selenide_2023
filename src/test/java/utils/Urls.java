package utils;

import com.codeborne.selenide.Configuration;

public class Urls {
    public static final String HOME_PAGE = Configuration.baseUrl.toString();
    public static final String LOGIN_PAGE = HOME_PAGE + "/login";
}
