package samplesharedpreferences.com.loginmvp.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import samplesharedpreferences.com.loginmvp.R;

/**
 * Created by neeraj on 21/2/18.
 */

public class Otp extends AppCompatActivity {
    EditText editText;
    Button b1;
    String otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp);

        editText=findViewById(R.id.otp);
        b1=findViewById(R.id.ok);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit=editText.getText().toString();
                Log.d( edit, "onClick: " );


                Intent intent=getIntent();
                Bundle bundle=intent.getExtras();
                if(bundle!=null){
                    otp= (String) bundle.get("OTP");
                }

                if(edit.equals(otp)){
                    Log.d("edit",otp);
                    Intent intent1 = new Intent(Otp.this, WelCome.class);
                    startActivity(intent1);
                    finish();


                }else{
                    Intent intent1 = new Intent(Otp.this, WelCome.class);
                    startActivity(intent1);
                    finish();

                }

            }
        });

    }
}
