package com.zxwl.chinahappy.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.zxwl.chinahappy.Adapter.VpAdapter;
import com.zxwl.chinahappy.Fragment.MerchantsFragemnt;
import com.zxwl.chinahappy.Fragment.MoneyFragment;
import com.zxwl.chinahappy.Fragment.MovieFragment;
import com.zxwl.chinahappy.Fragment.MyFragment;
import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;
import com.zxwl.chinahappy.Utlis.Validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private String locationProvider;

    private double jd;
    private double wd;
    private ViewPager mViewpager;
    private TabLayout mTab;
    private ArrayList<String> list;
    private ArrayList<Fragment> fragments;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        ObtainLocation();


        list = new ArrayList<>();
        fragments = new ArrayList<>();

        list.add("娱乐");
        list.add("看片");
        list.add("好货");
        list.add("我的");

        fragments.add(new MoneyFragment());
        fragments.add(new MovieFragment());
        fragments.add(new MerchantsFragemnt());
        fragments.add(new MyFragment());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, list);
        mViewpager.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mViewpager);
        TabLayout.Tab  tab_one = mTab.getTabAt(0);
        TabLayout.Tab  tab_two = mTab.getTabAt(1);
        TabLayout.Tab  tab_three = mTab.getTabAt(2);
        TabLayout.Tab  tab_four = mTab.getTabAt(3);
        tab_one.setIcon(R.mipmap.b_77);
        tab_two.setIcon(R.mipmap.coconut);
        tab_three.setIcon(R.mipmap.apple);
        tab_four.setIcon(R.mipmap.alarm);
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
        } catch (Exception e) {
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


    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTab = (TabLayout) findViewById(R.id.tab);
    }
}
