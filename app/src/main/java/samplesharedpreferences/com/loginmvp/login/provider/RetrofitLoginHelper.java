package samplesharedpreferences.com.loginmvp.login.provider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URISyntaxException;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import samplesharedpreferences.com.loginmvp.login.api.RequestLogin;
import samplesharedpreferences.com.loginmvp.login.LoginCallback;
import samplesharedpreferences.com.loginmvp.login.model.LoginDataResponse;
import samplesharedpreferences.com.loginmvp.login.view.Otp;

/**
 * Created by neeraj on 20/2/18.
 */

public class RetrofitLoginHelper extends AppCompatActivity  implements LoginBaseClassHelper {
    private static String TAG ="RetrofitLoginHelper";
    String mob,otp;
    Context context;

    @Override
    public void loginData(String mobile, String name, String pass, final LoginCallback loginCallback) throws URISyntaxException {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.msg91.com/api/")
                .addConverterFactory( GsonConverterFactory.create(gson)).build();
        RequestLogin requestLogin = retrofit.create(RequestLogin.class);

        Random random = new Random();
        int i = random.nextInt(999999);
        //int number = -782;
        otp = new Integer(i).toString();

       /* Intent intent=getIntent();
       // Bundle bd = intent.getExtras();
       // mob= (String) bd.get("mobile");
*/
      /*  Intent intent = getIntent();
        mob = intent.getStringExtra("mobile");
       */// Integer age = intent.getIntExtra("age");





        Log.d( otp, "otp" );
        Log.d( mobile, "loginData: " );


        Call<String> call= requestLogin.reposForUser("NEERAJ","4",mobile ,"197052A3ecHRtdISu95a7a8685",91,"your otp is "+otp);
        call.enqueue( new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
               // Toast.makeText(RetrofitLoginHelper.this, response.body(), Toast.LENGTH_LONG).show();
//

            loginCallback.onLoginSuccess( response.body() );

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                loginCallback.onLoginFailure(t.getMessage());

            }



        } );



    }
}
