package samplesharedpreferences.com.loginmvp.login.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import samplesharedpreferences.com.loginmvp.login.model.LoginDataResponse;

/**
 * Created by neeraj on 20/2/18.
 */

public interface RequestLogin {
    @GET("sendhttp.php")
    Call<String> reposForUser(
            @Query("sender") String sender,
            @Query("route") String route,
            @Query("mobiles")  String mobiles,
            @Query("authkey") String authkey,
            @Query("country") Number country,
            @Query("message") String message


    );
}
