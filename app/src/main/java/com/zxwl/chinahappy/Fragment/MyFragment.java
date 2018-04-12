package com.zxwl.chinahappy.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zxwl.chinahappy.Activity.LoginActivity;
import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sks on 2018/4/11.
 */

public class MyFragment extends Fragment implements View.OnClickListener {
    /**
     * 用户名：阿昭
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

    private Button mSignout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_my_fragment, null);
        initView(inflate);
        hqxx();
        return inflate;
    }

    private void initView(View inflate) {

        mName = (TextView) inflate.findViewById(R.id.name);
        mMoney = (TextView) inflate.findViewById(R.id.money);
        mBranch = (TextView) inflate.findViewById(R.id.branch);
        mSignout = (Button) inflate.findViewById(R.id.signout);

        mSignout.setOnClickListener(this);

    }

    //  获取用户信息
    private void hqxx() {
        SharedPreferences userData = getActivity().getSharedPreferences("UserData", MODE_PRIVATE);
        String phone = userData.getString("phone", null);
        RequestBody body = new FormBody.Builder()
                .add("action", "hqxx")
                .add("phone", phone)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(), "网络不好请等待", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);

                            JSONArray datas = jsonObject.getJSONArray("datas");
                            String username = datas.getJSONObject(0).getString("username");
                            String money = datas.getJSONObject(0).getString("money");
                            String branch = datas.getJSONObject(0).getString("integral");
                            mName.setText("用户名：" + username);
                            mMoney.setText("金钱：" + money);
                            mBranch.setText("积分：" + branch);
                            Log.e("TTT",username+money+branch);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signout:
                SharedPreferences userData = getActivity().getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = userData.edit();
                                editor.clear();
                                editor.commit();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();

                break;
        }
    }
}