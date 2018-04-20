package com.zxwl.chinahappy.GameActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.zxwl.chinahappy.Adapter.TyAdapter;
import com.zxwl.chinahappy.Adapter.VpAdapter;
import com.zxwl.chinahappy.Adapter.YHYZAdapter;
import com.zxwl.chinahappy.Bean.TigerUserYzBean;
import com.zxwl.chinahappy.Bean.TigerdataBean;
import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;
import com.zxwl.chinahappy.Utlis.ViewHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;



public class TigermacActivity extends AppCompatActivity implements View.OnClickListener {


    private int i = Color.parseColor("#55ff0000");
    private int x = 0;
    private int y = 0;
    private int yzjf=0;
    private int yzzjf=0;
    private Handler hann = new Handler();
    private Runnable runnn = new Runnable() {
        @Override
        public void run() {

            RequestBody body = new FormBody.Builder()
                    .add("action","TigerData")
                    .build();
            HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String string = response.body().string();
                    Log.e("TTT",string);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            TigerdataBean tigerdataBean = gson.fromJson(string, TigerdataBean.class);
                            String countdown = tigerdataBean.getDatas().get(0).getCountdown();
                            id = tigerdataBean.getDatas().get(0).getId();

                            hqzt(id);
                            String answer = tigerdataBean.getDatas().get(0).getAnswer();
                            String xapple = tigerdataBean.getDatas().get(0).getXapple();
                            String xorange = tigerdataBean.getDatas().get(0).getXorange();
                            String xcoconut = tigerdataBean.getDatas().get(0).getXcoconut();
                            String xwatermelons = tigerdataBean.getDatas().get(0).getXwatermelons();
                            String xqq = tigerdataBean.getDatas().get(0).getXqq();
                            String xstar = tigerdataBean.getDatas().get(0).getXstar();
                            String xbar = tigerdataBean.getDatas().get(0).getXbar();
                            String xalarm = tigerdataBean.getDatas().get(0).getXalarm();

                            mWApple.setText("苹果\n"+xapple);
                            mWOrange.setText("橘子\n"+xorange);
                            mWCoconut.setText("柚子\n"+xcoconut);
                            mWWatermelons.setText("西瓜\n"+xwatermelons);
                            mW77.setText("七七\n"+xqq);
                            mWStar.setText("星星\n"+xstar);
                            mWBar.setText("酒\n"+xbar);
                            mWAlarm.setText("铃铛\n"+xalarm);
                            int i = Integer.parseInt(xapple) + Integer.parseInt(xorange) + Integer.parseInt(xcoconut) + Integer.parseInt(xwatermelons) + Integer.parseInt(xqq) + Integer.parseInt(xstar) + Integer.parseInt(xbar) + Integer.parseInt(xalarm);

                            mWSun.setText("总金额\n"+i);




                            if("0".equals(countdown)){
                                mTrainTime.setText("开奖中\n请等待");

                                    mMoney500.setClickable(false);
                                    mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                                    mMoney100.setClickable(false);
                                    mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                                    mMoney50.setClickable(false);
                                    mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                                    mMoney10.setClickable(false);
                                    mMoney10.setBackgroundResource(R.drawable.shape_yz_k);
                                    mMoneyCon.setClickable(false);
                                    mMoneyCon.setBackgroundResource(R.drawable.shape_yz_k);


                            }else{

                                mTrainTime.setText("押注时间\n"+countdown);
                            }
                            mTrainCode.setText("期号:"+id);

                            xxx = Integer.parseInt(answer);
                            if("1".equals(countdown)){
                                mMoney500.setClickable(false);
                                mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney100.setClickable(false);
                                mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney50.setClickable(false);
                                mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney10.setClickable(false);
                                mMoney10.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoneyCon.setClickable(false);
                                mMoneyCon.setBackgroundResource(R.drawable.shape_yz_k);
                                yzjf=0;
                                yzzjf=0;
                                hann.postDelayed(runn,1000);
                            }
                            if("30".equals(countdown)){
                                ksyz();
                                hquseryzxx();
                            }


                        }
                    });


                }
            });
            hann.postDelayed(runnn,1000);
        }
    };



    private Runnable runn = new Runnable() {
        @Override
        public void run() {

            switch (x) {
                case 0:

                    if (y > 3) {
                        if (x == xxx) {
                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(13).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(14).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(15).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(13).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }


                    break;
                case 1:
                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(14).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(15).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(0).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(14).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 2:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(15).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(15).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 3:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 4:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 5:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 6:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 7:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 8:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 9:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 10:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 11:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 12:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 13:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 14:
                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 15:

                    if (y > 3) {
                        if (x == xxx) {

                            tjbh();
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x - 1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x = 0;
                    y++;
                    if (y == 0) {
                        hann.postDelayed(runn, 250);
                    } else if (y == 1) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 2) {
                        hann.postDelayed(runn, 150);
                    } else if (y == 3) {
                        hann.postDelayed(runn, 150);
                    } else {
                        hann.postDelayed(runn, 350);
                    }
                    break;

            }

        }
    };
    private List<ImageView> imageViews;
    private ImageView mSApple;
    private ImageView mBApple;
    private ImageView mSBar;
    private ImageView mSAlarm;
    private ImageView mBAlarm;
    private ImageView mBOrange;
    private ImageView mSCoconut;
    private ImageView mSOrange;
    private ImageView mBCoconut;
    private ImageView mSStar;
    private ImageView mSWatermelons;
    private ImageView mBStar;
    private ImageView mS77;
    private ImageView mBBar;
    private ImageView mB77;
    private ImageView mBWatermelons;
    private int xxx;
    /**
     * 苹果
     */
    private TextView mWApple;
    /**
     * 酒
     */
    private TextView mWBar;
    /**
     * 西瓜
     */
    private TextView mWWatermelons;
    /**
     * 橘子
     */
    private TextView mWOrange;
    /**
     * 全部
     */
    private TextView mWSun;
    /**
     * 木瓜
     */
    private TextView mWCoconut;
    /**
     * 星星
     */
    private TextView mWStar;
    /**
     * 七七
     */
    private TextView mW77;
    /**
     * 铃铛
     */
    private TextView mWAlarm;
    /**
     * 期号
     */
    private TextView mTrainCode;
    /**
     * 下注时间
     */
    private TextView mTrainTime;
    /**
     * 积分
     */
    private TextView mIntegral;
    private ImageView mYztApple;
    private ImageView mYztOrange;
    private ImageView mYztWatermelons;
    private ImageView mYztCoconut;
    /**
     * 0
     */
    private TextView mWyzApple;
    /**
     * 0
     */
    private TextView mWyzOrange;
    /**
     * 0
     */
    private TextView mWyzWatermelons;
    /**
     * 0
     */
    private TextView mWyzCoconut;
    private ImageView mYzt77;
    private ImageView mYztStar;
    private ImageView mYztAlarm;
    private ImageView mYztBar;
    /**
     * 0
     */
    private TextView mWyzZ77;
    /**
     * 0
     */
    private TextView mWyzStar;
    /**
     * 0
     */
    private TextView mWyzAlarm;
    /**
     * 0
     */
    private TextView mWyzBar;
    /**
     * 10
     */
    private Button mMoney10;
    /**
     * 50
     */
    private Button mMoney50;
    /**
     * 100
     */
    private Button mMoney100;
    /**
     * 500
     */
    private Button mMoney500;
    /**
     * 倍率说明
     */
    private Button mExplain;
    /**
     * 确认
     */
    private Button mMoneyCon;
    private ListView mListview;
    private String branch;
    private int i2;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigermac);
        initView();


        imageViews = new ArrayList<>();
        imageViews.add(mBBar);
        imageViews.add(mS77);
        imageViews.add(mBStar);
        imageViews.add(mSStar);
        imageViews.add(mSOrange);
        imageViews.add(mBOrange);
        imageViews.add(mSApple);
        imageViews.add(mBApple);
        imageViews.add(mSBar);
        imageViews.add(mSWatermelons);
        imageViews.add(mBWatermelons);
        imageViews.add(mSCoconut);
        imageViews.add(mBCoconut);
        imageViews.add(mSAlarm);
        imageViews.add(mBAlarm);
        imageViews.add(mB77);


        boolean wifiConnected = isNetworkConnected(this);
        if(wifiConnected){
            hqxx();
            hquseryzxx();
            hann.postDelayed(runnn,100);
        }else{
            Toast.makeText(this, "请链接网络", Toast.LENGTH_SHORT).show();


        }





    }

    public boolean isNetworkConnected(Context context) {
             if (context != null) {
                     ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                             .getSystemService(Context.CONNECTIVITY_SERVICE);
                     NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
                     if (mNetworkInfo != null) {
                             return mNetworkInfo.isAvailable();
                         }
                 }
             return false;
         }

    private void initView() {

        mSApple = (ImageView) findViewById(R.id.s_apple);
        mBApple = (ImageView) findViewById(R.id.b_apple);
        mSBar = (ImageView) findViewById(R.id.s_bar);
        mSAlarm = (ImageView) findViewById(R.id.s_alarm);
        mBAlarm = (ImageView) findViewById(R.id.b_alarm);
        mBOrange = (ImageView) findViewById(R.id.b_orange);
        mSCoconut = (ImageView) findViewById(R.id.s_coconut);
        mSOrange = (ImageView) findViewById(R.id.s_orange);
        mBCoconut = (ImageView) findViewById(R.id.b_coconut);
        mSStar = (ImageView) findViewById(R.id.s_star);
        mSWatermelons = (ImageView) findViewById(R.id.s_watermelons);
        mBStar = (ImageView) findViewById(R.id.b_star);
        mS77 = (ImageView) findViewById(R.id.s_77);
        mBBar = (ImageView) findViewById(R.id.b_bar);
        mB77 = (ImageView) findViewById(R.id.b_77);
        mBWatermelons = (ImageView) findViewById(R.id.b_watermelons);
        mWApple = (TextView) findViewById(R.id.w_apple);
        mWBar = (TextView) findViewById(R.id.w_bar);
        mWWatermelons = (TextView) findViewById(R.id.w_watermelons);
        mWOrange = (TextView) findViewById(R.id.w_orange);
        mWSun = (TextView) findViewById(R.id.w_sun);
        mWCoconut = (TextView) findViewById(R.id.w_coconut);
        mWStar = (TextView) findViewById(R.id.w_star);
        mW77 = (TextView) findViewById(R.id.w_77);
        mWAlarm = (TextView) findViewById(R.id.w_alarm);
        mTrainCode = (TextView) findViewById(R.id.train_code);
        mTrainTime = (TextView) findViewById(R.id.train_time);
        mIntegral = (TextView) findViewById(R.id.integral);
        mYztApple = (ImageView) findViewById(R.id.yzt_apple);
        mYztApple.setOnClickListener(this);
        mYztOrange = (ImageView) findViewById(R.id.yzt_orange);
        mYztOrange.setOnClickListener(this);
        mYztWatermelons = (ImageView) findViewById(R.id.yzt_watermelons);
        mYztWatermelons.setOnClickListener(this);
        mYztCoconut = (ImageView) findViewById(R.id.yzt_coconut);
        mYztCoconut.setOnClickListener(this);
        mWyzApple = (TextView) findViewById(R.id.wyz_apple);
        mWyzOrange = (TextView) findViewById(R.id.wyz_orange);
        mWyzWatermelons = (TextView) findViewById(R.id.wyz_watermelons);
        mWyzCoconut = (TextView) findViewById(R.id.wyz_coconut);
        mYzt77 = (ImageView) findViewById(R.id.yzt_77);
        mYzt77.setOnClickListener(this);
        mYztStar = (ImageView) findViewById(R.id.yzt_star);
        mYztStar.setOnClickListener(this);
        mYztAlarm = (ImageView) findViewById(R.id.yzt_alarm);
        mYztAlarm.setOnClickListener(this);
        mYztBar = (ImageView) findViewById(R.id.yzt_bar);
        mYztBar.setOnClickListener(this);
        mWyzZ77 = (TextView) findViewById(R.id.wyz_z77);
        mWyzStar = (TextView) findViewById(R.id.wyz_star);
        mWyzAlarm = (TextView) findViewById(R.id.wyz_alarm);
        mWyzBar = (TextView) findViewById(R.id.wyz_bar);
        mMoney10 = (Button) findViewById(R.id.money10);
        mMoney10.setOnClickListener(this);
        mMoney50 = (Button) findViewById(R.id.money50);
        mMoney50.setOnClickListener(this);
        mMoney100 = (Button) findViewById(R.id.money100);
        mMoney100.setOnClickListener(this);
        mMoney500 = (Button) findViewById(R.id.money500);
        mMoney500.setOnClickListener(this);
        mExplain = (Button) findViewById(R.id.explain);
        mExplain.setOnClickListener(this);
        mMoneyCon = (Button) findViewById(R.id.money_con);
        mMoneyCon.setOnClickListener(this);
        mListview = (ListView) findViewById(R.id.listview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.money10:
                if(Integer.parseInt(branch)-yzzjf>10){
                    yzjf=10;
                    mMoney10.setBackgroundResource(R.drawable.ic_launcher_background);
                    if(Integer.parseInt(branch)-yzzjf<500){
                        mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                    }else{
                        mMoney500.setBackgroundResource(R.drawable.shape_yz_mz);
                    }
                    if(Integer.parseInt(branch)-yzzjf<100){
                        mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                    }else{
                        mMoney100.setBackgroundResource(R.drawable.shape_yz_mz);
                    }
                    if(Integer.parseInt(branch)-yzzjf<50){
                        mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                    }else{
                        mMoney50.setBackgroundResource(R.drawable.shape_yz_mz);
                    }

                }else{
                    yzjf=0;
                    mMoney10.setClickable(false);
                    mMoney10.setBackgroundResource(R.drawable.shape_yz_k);
                    mMoney50.setClickable(false);
                    mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                    mMoney100.setClickable(false);
                    mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                    mMoney500.setClickable(false);
                    mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                    Toast.makeText(this, "积分不够请兑换", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.money50:
                if(Integer.parseInt(branch)-yzzjf>50){
                    yzjf=50;
                    mMoney10.setBackgroundResource(R.drawable.shape_yz_mz);
                    mMoney50.setBackgroundResource(R.drawable.ic_launcher_background);
                    if(Integer.parseInt(branch)-yzzjf<500){
                        mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                    }else{
                        mMoney500.setBackgroundResource(R.drawable.shape_yz_mz);
                    }
                    if(Integer.parseInt(branch)-yzzjf<100){
                        mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                    }else{
                        mMoney100.setBackgroundResource(R.drawable.shape_yz_mz);
                    }
                }else{
                    yzjf=0;
                    mMoney50.setClickable(false);
                    mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                    mMoney100.setClickable(false);
                    mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                    mMoney500.setClickable(false);
                    mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                    Toast.makeText(this, "积分不够请兑换", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.money100:
                if(Integer.parseInt(branch)-yzzjf>100){
                    yzjf=100;
                    mMoney10.setBackgroundResource(R.drawable.shape_yz_mz);
                    mMoney50.setBackgroundResource(R.drawable.shape_yz_mz);
                    mMoney100.setBackgroundResource(R.drawable.ic_launcher_background);
                    if(Integer.parseInt(branch)-yzzjf<500){
                        mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                    }else{
                        mMoney500.setBackgroundResource(R.drawable.shape_yz_mz);
                    }



                }else{

                    yzjf=0;
                    mMoney100.setClickable(false);
                    mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                    mMoney500.setClickable(false);
                    mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                    Toast.makeText(this, "积分不够请兑换", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.money500:
                if(Integer.parseInt(branch)-yzzjf>500){
                    yzjf=500;
                    mMoney10.setBackgroundResource(R.drawable.shape_yz_mz);
                    mMoney50.setBackgroundResource(R.drawable.shape_yz_mz);
                    mMoney100.setBackgroundResource(R.drawable.shape_yz_mz);
                    mMoney500.setBackgroundResource(R.drawable.ic_launcher_background);

                }else{
                    yzjf=0;
                    mMoney500.setClickable(false);
                    mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                    Toast.makeText(this, "积分不够请兑换", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.explain:

                break;
            case R.id.money_con:

                tjyzxx();




                break;


            case R.id.yzt_apple:
                yzpd(mWyzApple);
                break;
            case R.id.yzt_orange:
                yzpd(mWyzOrange);
                break;
            case R.id.yzt_watermelons:
                yzpd(mWyzWatermelons);
                break;
            case R.id.yzt_coconut:
                yzpd(mWyzCoconut);
                break;
            case R.id.yzt_77:
                yzpd(mWyzZ77);
                break;
            case R.id.yzt_star:
                yzpd(mWyzStar);
                break;
            case R.id.yzt_alarm:
                yzpd(mWyzAlarm);
                break;
            case R.id.yzt_bar:
                yzpd(mWyzBar);
                break;


        }
    }

    private void yzpd(TextView name) {
        if(yzjf==0){
            if (Integer.parseInt(branch)<10){
                Toast.makeText(this, "积分不够请兑换", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "请选择押注金额", Toast.LENGTH_SHORT).show();
            }

        }else{
            String s = name.getText().toString();
            int i = Integer.parseInt(s);
            yzzjf+=yzjf;
            int i1 = yzjf + i;
            name.setText(i1+"");

        }
        try {
            int userbranch = Integer.parseInt(branch);
            int i = userbranch - yzzjf;

            mIntegral.setText("积分剩余:\n"+i);
       if(userbranch-yzzjf<=10){
                mMoney500.setClickable(false);
                mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                mMoney100.setClickable(false);
                mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                mMoney50.setClickable(false);
                mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                mMoney10.setClickable(false);
                mMoney10.setBackgroundResource(R.drawable.shape_yz_k);
                 yzjf=10;
            } if(userbranch-yzzjf<50){
                mMoney500.setClickable(false);
                mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                mMoney100.setClickable(false);
                mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                mMoney50.setClickable(false);
                mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                yzjf=10;
            }else if(userbranch-yzzjf<100){
                mMoney500.setClickable(false);
                mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                mMoney100.setClickable(false);
                mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                yzjf=50;
            }else if(userbranch-yzzjf<500){
                mMoney500.setClickable(false);
                mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                yzjf=100;
            }
        }catch (Exception e){
            mMoney500.setClickable(false);
            mMoney100.setClickable(false);
            mMoney50.setClickable(false);
            mMoney10.setClickable(false);
            mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
            mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
            mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
            mMoney10.setBackgroundResource(R.drawable.shape_yz_k);
        }
    }

    private void tjyzxx() {
        SharedPreferences userData =getSharedPreferences("UserData", MODE_PRIVATE);
        String phone = userData.getString("phone", null);
        String s1 = mWyzApple.getText().toString();
        String s2 = mWyzOrange.getText().toString();
        String s3 = mWyzCoconut.getText().toString();
        String s4 = mWyzWatermelons.getText().toString();
        String s5 = mWyzZ77.getText().toString();
        String s6 = mWyzStar.getText().toString();
        String s7 = mWyzBar.getText().toString();
        String s8 = mWyzAlarm.getText().toString();
        RequestBody body = new FormBody.Builder()
                .add("action", "TigeruserData")
                .add("phone", phone)
                .add("qh", id)
                .add("apple", s1)
                .add("dorange", s2)
                .add("coconut", s3)
                .add("watermelons", s4)
                .add("star", s6)
                .add("qq", s5)
                .add("bar", s7)
                .add("alarm", s8)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(TigermacActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("TTAAAT",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            boolean register_result = jsonObject.getBoolean("register_result");
                            if(register_result){
                                Toast.makeText(TigermacActivity.this, "下注提交成功,请等待开奖", Toast.LENGTH_SHORT).show();
                                mMoney500.setClickable(false);
                                mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney100.setClickable(false);
                                mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney50.setClickable(false);
                                mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney10.setClickable(false);
                                mMoney10.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoneyCon.setClickable(false);
                                mMoneyCon.setBackgroundResource(R.drawable.shape_yz_k);
                                yzjf=0;
                                yzzjf=0;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });



            }
        });
    }

    private void tjbh() {
        y = 0;
        hqxx();
    }
    private void ksyz() {
        mMoney500.setClickable(true);
        mMoney500.setBackgroundResource(R.drawable.shape_yz_mz);
        mMoney100.setClickable(true);
        mMoney100.setBackgroundResource(R.drawable.shape_yz_mz);
        mMoney50.setClickable(true);
        mMoney50.setBackgroundResource(R.drawable.shape_yz_mz);
        mMoney10.setClickable(true);
        mMoney10.setBackgroundResource(R.drawable.shape_yz_mz);
        mMoneyCon.setClickable(true);
        mMoneyCon.setBackgroundResource(R.drawable.shape_yz_mz);
        mWyzApple.setText("0");
        mWyzOrange.setText("0");
        mWyzCoconut.setText("0");
        mWyzWatermelons.setText("0");
        mWyzZ77.setText("0");
        mWyzStar.setText("0");
        mWyzBar.setText("0");
        mWyzAlarm.setText("0");
    }

    private void hqxx() {
        SharedPreferences userData =getSharedPreferences("UserData", MODE_PRIVATE);
        String phone = userData.getString("phone", null);
        RequestBody body = new FormBody.Builder()
                .add("action", "hqxx")
                .add("phone", phone)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(TigermacActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
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
                            branch = datas.getJSONObject(0).getString("integral");
                            mIntegral.setText("积分剩余：\n"+ branch);
                            Log.e("TTT",username+money+ branch);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }




    private void hqzt(String qh) {
        SharedPreferences userData =getSharedPreferences("UserData", MODE_PRIVATE);
        String phone = userData.getString("phone", null);
        RequestBody body = new FormBody.Builder()
                .add("action", "JdTigeruseryz")
                .add("phone", phone)
                .add("qh", qh)
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(TigermacActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
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
                                mMoney500.setClickable(false);
                                mMoney500.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney100.setClickable(false);
                                mMoney100.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney50.setClickable(false);
                                mMoney50.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoney10.setClickable(false);
                                mMoney10.setBackgroundResource(R.drawable.shape_yz_k);
                                mMoneyCon.setClickable(false);
                                mMoneyCon.setBackgroundResource(R.drawable.shape_yz_k);
                                yzjf=0;
                                yzzjf=0;
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }


    private void hquseryzxx() {

        RequestBody body = new FormBody.Builder()
                .add("action", "TigerAnswerData")
                .build();
        HttpUtils.getInstance().sendPost(HttpApi.ADDRESS, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(TigermacActivity.this, "网络不好请等待", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Gson gson = new Gson();
                        TigerUserYzBean tigerUserYzBean = gson.fromJson(string, TigerUserYzBean.class);
                        List<TigerUserYzBean.DatasBean> datas = tigerUserYzBean.getDatas();
                        YHYZAdapter yhyzAdapter = new YHYZAdapter(TigermacActivity.this, datas);
                        mListview.setAdapter(yhyzAdapter);






                    }
                });


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hann.removeCallbacks(runn);
        hann.removeCallbacks(runnn);
    }
}
