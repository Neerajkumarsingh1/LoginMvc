package samplesharedpreferences.com.loginmvp.login.model;

/**
 * Created by neeraj on 20/2/18.
 */

public class LoginDataResponse {

    private boolean success;
    private String message;
    private boolean isRcCorrect;

    public LoginDataResponse(boolean success, String message, boolean isRcCorrect) {
        this.success = success;
        this.message = message;
        this.isRcCorrect = isRcCorrect;
    }

    public boolean isRcCorrect() {
        return isRcCorrect;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
