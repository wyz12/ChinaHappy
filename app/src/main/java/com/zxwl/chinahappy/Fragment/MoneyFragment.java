package com.zxwl.chinahappy.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zxwl.chinahappy.Activity.HomeActivity;
import com.zxwl.chinahappy.GameActivity.TigermacActivity;
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

public class MoneyFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView mQianDao;
    /**
     * 水果老虎机
     */
    private LinearLayout mFruitsTiger;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_money_fragment, null);
        initView(inflate);


        return inflate;
    }

    private void initView(View inflate) {
        mQianDao = (ImageView) inflate.findViewById(R.id.qian_dao);
        mFruitsTiger = (LinearLayout) inflate.findViewById(R.id.fruits_tiger);
        mFruitsTiger.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.fruits_tiger:
                    startActivity(new Intent(getActivity(), TigermacActivity.class));
                    break;
            }
    }
}
