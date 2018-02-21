package samplesharedpreferences.com.loginmvp.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.net.URISyntaxException;

import samplesharedpreferences.com.loginmvp.R;
import samplesharedpreferences.com.loginmvp.helper.Sharepre;
import samplesharedpreferences.com.loginmvp.login.presenter.LoginDataImp;
import samplesharedpreferences.com.loginmvp.login.presenter.Logindata;
import samplesharedpreferences.com.loginmvp.login.provider.RetrofitLoginHelper;

/**
 * Created by neeraj on 20/2/18.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editmobile;
    private EditText editemail;
    private EditText editpass;
    private Sharepre sharepre;
    String mobile,email,pass;
    private ProgressBar progressBar;
    Logindata logindata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.login);
        final Context context = this;

       /* Intent intent= new Intent(this,WelCome.class);
        startActivity(intent);
        finish();*/

        sharepre=new Sharepre(this);
        initialise();


    }

    private void initialise() {
        editemail=findViewById( R.id.email );
        editmobile=findViewById(R.id.mobile);
        editpass=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);





    }

    public void proceed(View v) throws URISyntaxException {
        mobile = editmobile.getText().toString();
        email = editemail.getText().toString();
        pass = editpass.getText().toString();

        if (mobile.isEmpty() || email.isEmpty()|| pass.isEmpty()) {
            showProgressBar(false);
            showError("Fields cannot be empty");

        } else {
          logindata  = new LoginDataImp(this,new RetrofitLoginHelper());
            logindata.getLoginData(email, mobile,pass);
            hideKeyboard();
        }

    }


    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showLoginStatus(boolean login) {
        if (login) {


            sharepre.setEmailId(email);
            sharepre.setPass(pass);
            sharepre.setuName(mobile);

            Intent i = new Intent(LoginActivity.this, Otp.class);
            i.putExtra("Email", email);
            i.putExtra("pass", pass);
            i.putExtra("mobile",mobile);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
