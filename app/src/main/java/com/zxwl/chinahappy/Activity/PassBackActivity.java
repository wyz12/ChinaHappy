package com.zxwl.chinahappy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;
import com.zxwl.chinahappy.Utlis.Validation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PassBackActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入手机号
     */
    private EditText mPhone;
    /**
     * 请输入新密码
     */
    private EditText mPass;
    /**
     * 请确认输入的新密码
     */
    private EditText mCfpass;
    /**
     * 请输入验证码
     */
    private EditText mCode;
    /**
     * 获取验证码
     */
    private Button mHqcode;
    /**
     * 找回密码
     */
    private Button mSumbit;

    private String phone;
    private String pass1;
    private String pass2;
    private String code;
    private int i = 60;
    private Handler hann = new Handler();
    private Runnable runn = new Runnable() {
        @Override
        public void run() {

            if (i > 0) {
                i--;
                mHqcode.setText("(" + i + ")秒");
                mHqcode.setEnabled(false);
                hann.postDelayed(runn, 1000);
            } else {
                i = 60;
                mHqcode.setText("重新获取");
                mHqcode.setEnabled(true);
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_back);
        initView();

    }

    private void initView() {
        mPhone = (EditText) findViewById(R.id.phone);
        mPass = (EditText) findViewById(R.id.pass);
        mCfpass = (EditText) findViewById(R.id.cfpass);
        mCode = (EditText) findViewById(R.id.code);
        mHqcode = (Button) findViewById(R.id.hqcode);
        mHqcode.setOnClickListener(this);
        mSumbit = (Button) findViewById(R.id.sumbit);
        mSumbit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
//                获取验证码
            case R.id.hqcode:

                phone = mPhone.getText().toString();
                if(!Validation.isMobile(phone)){
                    Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                hann.postDelayed(runn, 1000);
                SMSSDK.getVerificationCode("86", mPhone.getText().toString()); // 发送验证码给号码的 phoneNumber 的手机
                Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
                mCode.requestFocus();
                break;
//                提交注册
            case R.id.sumbit:

                phone = mPhone.getText().toString();
                pass1 = mPass.getText().toString();
                pass2 = mCfpass.getText().toString();
                code = mCode.getText().toString();
                if(!Validation.isMobile(phone)){
                    Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Validation.StrPass(pass1)){
                    Toast.makeText(this, "密码不能小于六位", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Validation.StrCfPass(pass1, pass2)){
                    Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                submitCode("86", phone, code);
                break;
        }
    }
    public void submitCode(String country, String phone, String code) {
        // 注册一个事件回调，用于处理提交验证码操作的结果

        SMSSDK.registerEventHandler(new EventHandler() {

            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    resetpass();
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(PassBackActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                // 用完回调要注销，否则会造成泄露
                SMSSDK.unregisterEventHandler(this);
            }
        });
        // 触发操作
        SMSSDK.submitVerificationCode(country, phone, code);

    }


//      修改密码的提交
    private void resetpass() {

        RequestBody body = new FormBody.Builder()
                .add("action", "resetpass")
                .add("phone", phone)
                .add("pass", pass1)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(PassBackActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
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
                            boolean register_result = jsonObject.getBoolean("modify_result");
                            if(register_result){
                                startActivity(new Intent(PassBackActivity.this, LoginActivity.class));
                                finish();
                                Toast.makeText(PassBackActivity.this, "修改成功请登录", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(PassBackActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
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
