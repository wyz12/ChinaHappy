package com.zxwl.chinahappy.GameActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zxwl.chinahappy.R;

import java.util.ArrayList;
import java.util.List;

public class TigermacActivity extends AppCompatActivity {


    private int i = Color.parseColor("#55ff0000");
    private int x = 0;
    private   int y=0;
    private Handler hann = new Handler();
    private Runnable runn = new Runnable() {
        @Override
        public void run() {

            switch (x) {
                case 0:

                    if(y>3){
                        if (x==xxx){
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
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }


                    break;
                case 1:
                    if(y>3){
                        if (x==xxx){
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
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 2:

                    if(y>3){
                        if (x==xxx){
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
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 3:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 4:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 5:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 6:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 7:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 8:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 9:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 10:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 11:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 12:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 13:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 14:
                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x - 3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
                        hann.postDelayed(runn, 350);
                    }
                    break;
                case 15:

                    if(y>3){
                        if (x==xxx){
                            imageViews.get(x).setBackgroundColor(i);
                            imageViews.get(x-1).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-2).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                            return;
                        }
                    }
                    imageViews.get(x).setBackgroundColor(i);
                    imageViews.get(x-3).setBackgroundResource(R.drawable.shape_gray_square_bg);
                    x = 0;
                    y++;
                    if(y==0){
                        hann.postDelayed(runn, 250);
                    }else if(y==1){
                        hann.postDelayed(runn, 150);
                    }else if(y==2){
                        hann.postDelayed(runn, 150);
                    }else if(y==3){
                        hann.postDelayed(runn, 150);
                    }else{
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

        xxx = 3;
        hann.postDelayed(runn,1000);

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
    }
}
