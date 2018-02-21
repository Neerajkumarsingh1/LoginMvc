package samplesharedpreferences.com.loginmvp.login.presenter;

import java.net.URISyntaxException;

/**
 * Created by neeraj on 20/2/18.
 */

public interface Logindata {
    void getLoginData(String mobile, String name,String pass) throws URISyntaxException;
}


