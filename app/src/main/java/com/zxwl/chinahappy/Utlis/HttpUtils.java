package com.zxwl.chinahappy.Utlis;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by sks on 2017/12/11.
 */

public class HttpUtils {
    private OkHttpClient client;
    private HttpUtils(){
        client = new OkHttpClient.Builder().build();
    }
    private static HttpUtils utils2;
    public static  HttpUtils getInstance(){
        if(utils2==null)
            utils2 = new HttpUtils();
        return utils2;
    }

    public void sendGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
//            call.execute()：同步方法
        call.enqueue(callback);
    }
    public void sendPost(String url, RequestBody body, Callback callback){
        //设置post请求有两种方式：1、post()，2、method方法
        Request request = new Request.Builder().url(url).method("POST",body).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
//    public  void postFile(String actionUrl, String filePath, Callback callBack){
//
//
//        File file = new File(filePath);
//        RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), file);
//        Request request = new Request.Builder().url(actionUrl).post(body).build();
//        Call call = client.newCall(request);
//        call.enqueue(callBack);
//    }


}
