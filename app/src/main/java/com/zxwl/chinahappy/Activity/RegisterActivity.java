package com.zxwl.chinahappy.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zxwl.chinahappy.MainActivity;
import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;
import com.zxwl.chinahappy.Utlis.Validation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    /**
     * 请输入手机号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPass;
    /**
     * 请确认输入的密码
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
     * 注册
     */
    private Button mSumbit;
    private String phone;
    private String pass1;
    private String pass2;
    private String code;
    private boolean Prompt=false;
    private int i = 60;
    private LocationManager locationManager;
    private String locationProvider;
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
    /**
     * 该手机号码已经注册
     */
    private TextView mPromptphone;
    /**
     * 密码要大于六位小于十六位
     */
    private TextView mPromptpass;
    /**
     * 两次输入密码不一致
     */
    private TextView mPromptcfpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

        mPromptphone = (TextView) findViewById(R.id.Promptphone);
        mPromptpass = (TextView) findViewById(R.id.Promptpass);
        mPromptcfpass = (TextView) findViewById(R.id.Promptcfpass);

        UserPrompt();


    }

//    用户输入提示
    private void UserPrompt() {
        mPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("TTT",hasFocus+"");
                if(!hasFocus){
                    phone = mPhone.getText().toString();
                    if (!Validation.isMobile(phone)) {
                        mPromptphone.setText("请输入正确号码");
                        mPromptphone.setVisibility(View.VISIBLE);
                        return;
                    }

                    pdPhone();

                }
            }
        });

        mPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("TTT",hasFocus+"");
                if(!hasFocus){
                    pass1 = mPass.getText().toString();
                    if (!Validation.StrPass(pass1)) {
                        mPromptpass.setText("请输入正确密码");
                        mPromptpass.setVisibility(View.VISIBLE);
                        return;
                    }else{
                        mPromptpass.setVisibility(View.GONE);
                    }


                }
            }
        });

        mCfpass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("TTT",hasFocus+"");
                if(!hasFocus){
                    pass1 = mPass.getText().toString();
                    pass2 = mCfpass.getText().toString();
                    if (!Validation.StrCfPass(pass1, pass2)) {
                        mPromptcfpass.setText("两次输入密码不一致");
                        mPromptcfpass.setVisibility(View.VISIBLE);
                    }else{
                        mPromptcfpass.setVisibility(View.GONE);
                    }

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
//                获取验证码
            case R.id.hqcode:
                phone = mPhone.getText().toString();
                if (!Validation.isMobile(phone)) {
                    Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Prompt){
                    hann.postDelayed(runn, 1000);
                    SMSSDK.getVerificationCode("86", mPhone.getText().toString()); // 发送验证码给号码的 phoneNumber 的手机
                    Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
                    mCode.requestFocus();
                }else{
                    Toast.makeText(this, "该手机号已经注册", Toast.LENGTH_SHORT).show();
                }


                break;
//                注册提交
            case R.id.sumbit:
                phone = mPhone.getText().toString();
                pass1 = mPass.getText().toString();
                pass2 = mCfpass.getText().toString();
                code = mCode.getText().toString();
                if (!Validation.isMobile(phone)) {
                    Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Validation.StrPass(pass1)) {
                    Toast.makeText(this, "密码不能小于六位", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Validation.StrCfPass(pass1, pass2)) {
                    Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                submitCode("86", phone, code);

                break;
        }
    }

    private void pdPhone() {
        RequestBody body = new FormBody.Builder()
                .add("action", "phomecx")
                .add("phone", phone)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(RegisterActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            boolean register_result = jsonObject.getBoolean("register_result");
                            if(!register_result){
                                Prompt=false;
                                mPromptphone.setText("该手机号已经注册");
                                mPromptphone.setVisibility(View.VISIBLE);
                            }else{
                                Prompt=true;
                                mPromptphone.setVisibility(View.GONE);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }

    public void submitCode(String country, String phone, String code) {
        // 注册一个事件回调，用于处理提交验证码操作的结果

        SMSSDK.registerEventHandler(new EventHandler() {

            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    register();
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
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


    //      注册账号的提交
    private void register() {



        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);
        if(providers.contains(LocationManager.GPS_PROVIDER)){
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        }else if(providers.contains(LocationManager.NETWORK_PROVIDER)){
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        }else{
            Toast.makeText(this, "没有可用的位置提供器", Toast.LENGTH_SHORT).show();
            return ;
        }
        //获取Location
        @SuppressLint("MissingPermission") Location location = locationManager.getLastKnownLocation(locationProvider);


        TelephonyManager TelephonyMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") String szImei = TelephonyMgr.getDeviceId();
        String  model= android.os.Build.MODEL;

        String  xtbb=android.os.Build.VERSION.RELEASE;

        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            PackageManager packageManager = getPackageManager();
            packInfo = packageManager.getPackageInfo(getPackageName(),0);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = packInfo.versionName;
        RequestBody body = new FormBody.Builder()
                .add("action", "register")
                .add("phone", phone)
                .add("pass", pass1)
                .add("name", phone)
                .add("version",version+"-"+xtbb)
                .add("equipment",model+"-"+szImei )
                .add("address",location.getLatitude()+"-"+location.getLongitude() )
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(RegisterActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
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
                            boolean register_result = jsonObject.getBoolean("register_result");
                            if(register_result){
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                finish();
                                Toast.makeText(RegisterActivity.this, "注册成功请登录", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
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
