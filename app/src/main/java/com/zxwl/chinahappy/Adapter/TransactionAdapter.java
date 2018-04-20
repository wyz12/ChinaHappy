package com.zxwl.chinahappy.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zxwl.chinahappy.Bean.TransactionBean;
import com.zxwl.chinahappy.R;

import java.util.List;

/**
 * Created by sks on 2018/4/20.
 */

public class TransactionAdapter extends BaseAdapter {
    private List<TransactionBean.DatasBean> list;
    private Context context;

    public TransactionAdapter(List<TransactionBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public void  sxadaptr(List<TransactionBean.DatasBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_listview_transaction, null);
            hh.yuanyin=convertView.findViewById(R.id.yuanyin);
            hh.time=convertView.findViewById(R.id.timess);
            hh.inte=convertView.findViewById(R.id.inte);
            hh.mon=convertView.findViewById(R.id.mon);
            hh.zfc=convertView.findViewById(R.id.zfs);
            convertView.setTag(hh);
        }else{
            hh = (HH) convertView.getTag();
        }
        if (list.get(position).getType().equals("0")){
            hh.yuanyin.setText("来源:"+"注册赠送");
            hh.zfc.setText("收入金钱:"+list.get(position).getNumber()+"");
        }
        if (list.get(position).getType().equals("1")){
            hh.yuanyin.setText("来源:"+"兑换积分");
            hh.zfc.setText("收入积分:"+list.get(position).getNumber()+"");
        }
        if (list.get(position).getType().equals("2")){
            hh.yuanyin.setText("来源:"+"兑换金币");
            hh.zfc.setText("收入金钱:"+list.get(position).getNumber()+"");
        }
        if (list.get(position).getType().equals("3")){
            hh.yuanyin.setText("来源:"+"老虎机下注金额");
            hh.zfc.setText("支出积分:"+list.get(position).getNumber()+"");

        }
        if (list.get(position).getType().equals("4")){
            hh.yuanyin.setText("来源:"+"老虎机赢注金额");
            hh.zfc.setText("收入积分:"+list.get(position).getNumber()+"");
        }
        Log.e("TTT",list.get(position).getTimesign());
        hh.time.setText("时间:"+list.get(position).getTimesign());
        hh.inte.setText("积分数:"+list.get(position).getIntegral());
        hh.mon.setText("金币数:"+list.get(position).getMoney());

        hh.yuanyin.setTextColor(context.getResources().getColor(R.color.qhs));
        hh.inte.setTextColor(context.getResources().getColor(R.color.sss));
        hh.mon.setTextColor(context.getResources().getColor(R.color.jinse));
        hh.time.setTextColor(context.getResources().getColor(R.color.lqingse));
        hh.zfc.setTextColor(context.getResources().getColor(R.color.colorred));



        return convertView;
    }

    class HH{
        TextView yuanyin;
        TextView time;
        TextView inte;
        TextView mon;
        TextView zfc;
    }
}
