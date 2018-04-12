package com.zxwl.chinahappy.GameActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zxwl.chinahappy.Bean.TigerdataBean;
import com.zxwl.chinahappy.R;
import com.zxwl.chinahappy.Utlis.HttpApi;
import com.zxwl.chinahappy.Utlis.HttpUtils;

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
                    String string = response.body().string();
                    Log.e("TTT",string);
                    Gson gson = new Gson();
                    TigerdataBean tigerdataBean = gson.fromJson(string, TigerdataBean.class);
                    String countdown = tigerdataBean.getDatas().get(0).getCountdown();
                    String id = tigerdataBean.getDatas().get(0).getId();
                    mTrainCode.setText(id);
                    mTrainTime.setText(countdown);

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
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(14).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(15).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(1).setBackgroundResource(R.drawable.shape_gray_square_bg);
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

//        xxx = 3;
//        hann.postDelayed(runn,1000);

        hann.postDelayed(runnn,100);

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
        mYztOrange = (ImageView) findViewById(R.id.yzt_orange);
        mYztWatermelons = (ImageView) findViewById(R.id.yzt_watermelons);
        mYztCoconut = (ImageView) findViewById(R.id.yzt_coconut);
        mWyzApple = (TextView) findViewById(R.id.wyz_apple);
        mWyzOrange = (TextView) findViewById(R.id.wyz_orange);
        mWyzWatermelons = (TextView) findViewById(R.id.wyz_watermelons);
        mWyzCoconut = (TextView) findViewById(R.id.wyz_coconut);
        mYzt77 = (ImageView) findViewById(R.id.yzt_77);
        mYztStar = (ImageView) findViewById(R.id.yzt_star);
        mYztAlarm = (ImageView) findViewById(R.id.yzt_alarm);
        mYztBar = (ImageView) findViewById(R.id.yzt_bar);
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
                break;
            case R.id.money50:
                break;
            case R.id.money100:
                break;
            case R.id.money500:
                break;
            case R.id.explain:
                break;
            case R.id.money_con:
                break;
        }
    }
}
