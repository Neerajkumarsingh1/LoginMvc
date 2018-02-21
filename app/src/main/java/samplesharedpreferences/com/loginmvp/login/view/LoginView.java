package samplesharedpreferences.com.loginmvp.login.view;

/**
 * Created by neeraj on 20/2/18.
 */

public interface LoginView {
    void showProgressBar(boolean show);
    void showLoginStatus(boolean login);
    void showError(String message);
}

