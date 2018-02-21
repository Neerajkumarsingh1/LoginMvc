package samplesharedpreferences.com.loginmvp.login.presenter;

import java.net.URISyntaxException;

import samplesharedpreferences.com.loginmvp.R;
import samplesharedpreferences.com.loginmvp.login.LoginCallback;
import samplesharedpreferences.com.loginmvp.login.model.LoginDataResponse;
import samplesharedpreferences.com.loginmvp.login.provider.LoginBaseClassHelper;
import samplesharedpreferences.com.loginmvp.login.provider.RetrofitLoginHelper;
import samplesharedpreferences.com.loginmvp.login.view.LoginView;

/**
 * Created by neeraj on 20/2/18.
 */

public class LoginDataImp implements Logindata {
    private LoginBaseClassHelper loginBaseClassHelper;
    private LoginView loginView;

    public LoginDataImp(LoginView loginView,LoginBaseClassHelper loginBaseClassHelper){
        this.loginView=loginView;
        this.loginBaseClassHelper=loginBaseClassHelper;
    }

    public LoginDataImp(RetrofitLoginHelper retrofitLoginHelper) {
    }

    @Override
    public void getLoginData(String email, String mobile, String pass) throws URISyntaxException {
        loginView.showProgressBar(true);
        loginBaseClassHelper.loginData( email, mobile, pass, new LoginCallback() {


            @Override
            public void onLoginSuccess(String  loginResponse) {
                    loginView.showProgressBar(false);
                    loginView.showProgressBar(false);


                loginView.showLoginStatus( true );

            }

            @Override
            public void onLoginFailure(String error) {
                loginView.showError("Cheek your Connection");
                loginView.showLoginStatus(false);
                loginView.showProgressBar(false);


            }
        } );


    }
}


