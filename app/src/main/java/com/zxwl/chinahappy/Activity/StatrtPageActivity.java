package com.zxwl.chinahappy.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.Validation;

public class StatrtPageActivity extends AppCompatActivity {


    private Handler hann = new Handler();
    private Runnable runn = new Runnable() {
        @Override
        public void run() {
            SharedPreferences pref = getSharedPreferences("UserData", MODE_PRIVATE);
            String name = pref.getString("phone","");
            if(!Validation.StrisNull(name)){
                startActivity(new Intent(StatrtPageActivity.this, HomeActivity.class));
                finish();
            }else{
                startActivity(new Intent(StatrtPageActivity.this, LoginActivity.class));
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statrt_page);

        hann.postDelayed(runn,1000);

    }
}
