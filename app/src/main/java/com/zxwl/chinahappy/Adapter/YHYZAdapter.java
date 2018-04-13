package com.zxwl.chinahappy.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zxwl.chinahappy.Bean.TigerUserYzBean;
import com.zxwl.chinahappy.R;

import java.util.List;

/**
 * Created by sks on 2018/4/13.
 */

public class YHYZAdapter extends BaseAdapter{
    private Context context;
    private List<TigerUserYzBean.DatasBean> list;

    public YHYZAdapter(Context context, List<TigerUserYzBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HH hh;
        if(convertView==null){
            hh = new HH();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_user_yzxx, null);
            hh.qh = convertView.findViewById(R.id.qh);
            hh.anwers = convertView.findViewById(R.id.ansewe);
            convertView.setTag(hh);
        }else{
            hh = (HH) convertView.getTag();
        }
            hh.qh.setText("期号:"+list.get(position).getId());
        if("16".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#000000");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大酒");
        }
        if("1".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ff0000");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小77");
        }
        if("2".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ffff00");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大星星");
        }
        if("3".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ffff00");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小星星");
        }
        if("4".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ff6600");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小橘子");
        }
        if("5".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ff6600");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大橘子");
        }
        if("6".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ff0000");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小苹果");
        }
        if("7".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ff0000");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大苹果");
        }
        if("8".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#000000");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小酒");
        }
        if("9".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#66ff00");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小西瓜");
        }
        if("10".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#66ff00");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大西瓜");
        }
        if("11".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#00ff00");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小木瓜");
        }
        if("12".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#00ff00");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大木瓜");
        }
        if("13".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#666600");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:小铃铛");
        }
        if("14".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#666600");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大铃铛");
        }
        if("15".equals(list.get(position).getAnswer())){
            hh.anwers.setText(list.get(position).getAnswer());
            int i = Color.parseColor("#ff0000");
            hh.anwers.setTextColor(i);
            hh.anwers.setText("结果:大77");
        }
        if("0".equals(list.get(position).getAnswer())){
            hh.anwers.setText("等待开奖");
        }



        return convertView;
    }


    class HH{
        TextView qh;
        TextView anwers;
    }
}
