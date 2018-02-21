package samplesharedpreferences.com.loginmvp.login;

import samplesharedpreferences.com.loginmvp.login.model.LoginDataResponse;

/**
 * Created by neeraj on 20/2/18.
 */

public interface LoginCallback {

    void onLoginSuccess(String loginResponse);
    void onLoginFailure(String error);
}
