package com.zxwl.chinahappy.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;
import com.zxwl.chinahappy.Utlis.Validation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 注册
     */
    private TextView mRegister;
    /**
     * 请输入手机号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPass;
    /**
     * 登录
     */
    private Button mSumbit;
    /**
     * 忘记密码?
     */
    private TextView mPassback;
    private String phone;
    private String pass;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        pref = LoginActivity.this.getSharedPreferences("UserData",MODE_PRIVATE);
        String name = pref.getString("phone","");
        if(!Validation.StrisNull(name)){
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }


    }

    private void initView() {
        mRegister = (TextView) findViewById(R.id.register);
        mPhone = (EditText) findViewById(R.id.phone);
        mPass = (EditText) findViewById(R.id.pass);
        mSumbit = (Button) findViewById(R.id.sumbit);
        mPassback = (TextView) findViewById(R.id.passback);
        mSumbit.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mPassback.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
//                跳转修改密码页面
            case R.id.passback:
                startActivity(new Intent(LoginActivity.this, PassBackActivity.class));
                break;
//                登录提交
            case R.id.sumbit:
                phone = mPhone.getText().toString();
                pass = mPass.getText().toString();
                if(!Validation.isMobile(phone)){
                    Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Validation.StrPass(pass)){
                    Toast.makeText(this, "密码不能小于六位", Toast.LENGTH_SHORT).show();
                    return;
                }


                login();


                break;
//                跳转注册页面
            case R.id.register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }


    private void login() {

        RequestBody body = new FormBody.Builder()
                .add("action", "login")
                .add("phone", phone)
                .add("pass", pass)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(LoginActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            Log.e("TTTT",string);
                            boolean register_result = jsonObject.getBoolean("login_result");
                            if(register_result){
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("phone",phone);
                                editor.commit();
                                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                finish();

                            }else{
                                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }



}
