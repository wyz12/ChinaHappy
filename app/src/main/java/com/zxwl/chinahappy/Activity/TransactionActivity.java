package com.zxwl.chinahappy.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zxwl.chinahappy.Adapter.TransactionAdapter;
import com.zxwl.chinahappy.Adapter.TyAdapter;
import com.zxwl.chinahappy.Bean.TransactionBean;
import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;
import com.zxwl.chinahappy.Utlis.ViewHolder;

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

public class TransactionActivity extends AppCompatActivity {

    /**
     * 用户名
     */
    private TextView mName;
    /**
     * 金币余额
     */
    private TextView mMoney;
    /**
     * 积分余额
     */
    private TextView mIntegral;
    private ListView mListview;
    private SmartRefreshLayout mRefreshLayout;
    private int currentPage;
    private TransactionAdapter transactionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        initView();
        hqxx();
        Transctionxx("0");
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(1000/*,false*/);//传入false表示刷新失败


                currentPage = 0;
                Transctionxx(""+currentPage);
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(1000/*,false*/);//传入false表示加载失败
                currentPage++;

                Transctionxx(""+currentPage);


            }
        });

    }

    private void initView() {
        mName = (TextView) findViewById(R.id.name);
        mMoney = (TextView) findViewById(R.id.money);
        mIntegral = (TextView) findViewById(R.id.integral);
        mListview = (ListView) findViewById(R.id.listview);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
    }


    //  获取交易信息
    private void Transctionxx(String page) {
        SharedPreferences userData = getSharedPreferences("UserData", MODE_PRIVATE);
        String phone = userData.getString("phone", null);
        RequestBody body = new FormBody.Builder()
                .add("action", "userTsDt")
                .add("phone", phone)
                .add("page", page)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(TransactionActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("TTTT",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        TransactionBean transactionBean = gson.fromJson(string, TransactionBean.class);
                        List<TransactionBean.DatasBean> datas = transactionBean.getDatas();
                        if(transactionBean.getTotal()==0){
                            Toast.makeText(TransactionActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                        }else{
                            if(currentPage!=0){
                                transactionAdapter.sxadaptr(datas);
                            }else{
                                transactionAdapter = new TransactionAdapter(datas, TransactionActivity.this);
                                mListview.setAdapter(transactionAdapter);
                            }
                        }




                    }
                });


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
                Toast.makeText(TransactionActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
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
                            String branch = datas.getJSONObject(0).getString("integral");
                            mName.setText("用户名：" + username);
                            mMoney.setText("金钱：" + money);
                            mIntegral.setText("积分：" + branch);
                            Log.e("TTT", username + money + branch);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }
}
