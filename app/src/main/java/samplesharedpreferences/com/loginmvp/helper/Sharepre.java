package samplesharedpreferences.com.loginmvp.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by neeraj on 20/2/18.
 */

public class Sharepre {
    private static final String mypreference = "Register";
    private static final String U_NAME = "userName";
    private static final String MOBILE_NO = "userMobile";
    private static final String EMAIL = "userEmail";
    private static final String AGE = "userAge";
    private static final String Pass = "userPass";


    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context1;


    public void setEmailId(String emailId) {
        editor.putString(EMAIL, emailId);
        editor.commit();

    }
    public void setuName(String name) {

        editor.putString(U_NAME,name);
        editor.commit();
    }
    public void setPass(String pass) {

        editor.putString(Pass,pass);
        editor.commit();
    }


    int PRIVATE_MODE = 0;

    public static String getuName() {
        return U_NAME;
    }

    public static String getMobileNo() {
        return MOBILE_NO;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static String getAGE() {
        return AGE;
    }

    public static String getPass() {
        return Pass;
    }


    public Sharepre(Context context) {
        this.context1 = context;
        preferences = context1.getSharedPreferences( mypreference, PRIVATE_MODE );
        editor = preferences.edit();

    }


}