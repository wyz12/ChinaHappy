package com.zxwl.chinahappy.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;
import com.zxwl.chinahappy.Utlis.Validation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private String locationProvider;
    /**
     * 用户名：阿昭你好
     */
    private TextView mName;
    /**
     * 金钱：120.01
     */
    private TextView mMoney;
    /**
     * 积分；100000000
     */
    private TextView mBranch;
    private double jd;
    private double wd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        ObtainLocation();
        hqxx();
    }

    //    获取位置信息并上传
    private void ObtainLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);
        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        }

        try {
            //获取Location
            @SuppressLint("MissingPermission") Location location = locationManager.getLastKnownLocation(locationProvider);
            jd = location.getLatitude();
            wd = location.getLongitude();
        }catch (Exception e){
            Validation.verifyStoragePermissions(this);
            return;
        }

            SharedPreferences userData = getSharedPreferences("UserData", MODE_PRIVATE);
            String phone = userData.getString("phone", null);
            RequestBody body = new FormBody.Builder()
                    .add("action", "updateaddress")
                    .add("phone", phone)
                    .add("address", jd + "-" + wd)
                    .build();
            HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                }
            });


    }

    //  获取用户信息
    private void hqxx() {
        SharedPreferences userData = getSharedPreferences("UserData", MODE_PRIVATE);
        String phone = userData.getString("phone", null);
        RequestBody body = new FormBody.Builder()
                .add("action", "hqxx")
                .add("phone", phone)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(HomeActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);

                            JSONArray datas = jsonObject.getJSONArray("datas");
                            String username = datas.getJSONObject(0).getString("username");
                            String money = datas.getJSONObject(0).getString("money");
                            String branch = datas.getJSONObject(0).getString("branch");
                            mName.setText("用户名："+username);
                            mMoney.setText("金钱："+money);
                            mBranch.setText("积分："+branch);
                            startActivity(new Intent(HomeActivity.this, TigermacActivity.class));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }


    private void initView() {
        mName = (TextView) findViewById(R.id.name);
        mMoney = (TextView) findViewById(R.id.money);
        mBranch = (TextView) findViewById(R.id.branch);
    }
}
