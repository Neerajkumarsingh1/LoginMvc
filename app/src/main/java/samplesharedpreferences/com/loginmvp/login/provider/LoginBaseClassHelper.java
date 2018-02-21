package samplesharedpreferences.com.loginmvp.login.provider;

import java.net.URISyntaxException;

import samplesharedpreferences.com.loginmvp.login.LoginCallback;

/**
 * Created by neeraj on 20/2/18.
 */

public interface LoginBaseClassHelper {

    void loginData(String mobile, String name, String pass, LoginCallback loginCallback) throws URISyntaxException;
}

