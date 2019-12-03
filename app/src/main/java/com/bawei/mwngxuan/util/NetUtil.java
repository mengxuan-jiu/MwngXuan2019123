package com.bawei.mwngxuan.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.bawei.mwngxuan.view.adapter.MyAdapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @包名 com.bawei.mwngxuan.util
 * @mengxuan
 * @日期2019/12/3
 * @日期2019 : 12:03
 * @项目名MwngXuan2019123
 * @类名NetUtil
 **/
public class NetUtil {
    static NetUtil netUtil = new NetUtil();

    public NetUtil() {

    }

    public static NetUtil getInstance() {
        return netUtil;
    }

    //
    public boolean hasNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }

    }

    //
    public boolean isWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        } else {
            return false;
        }

    }

    //
    public boolean ismoble(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        } else {
            return false;
        }
    }
    //
    public  void  getBitmap(final String s, ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap=null;
                HttpURLConnection http=null;
                InputStream inputStream=null;
                try {
                    URL url = new URL(s);
                    http= (HttpURLConnection) url.openConnection();
                    http.setRequestMethod("GET");
                    http.setConnectTimeout(5000);
                    http.setReadTimeout(5000);
                    http.connect();
                    inputStream=http.getInputStream();
                    if (http.getResponseCode()==200){
                        bitmap=io2Bitmap(inputStream);
                    }else {
                        Log.d("TAG", "doInBackground: 失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (http != null) {
                        http.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return bitmap;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private Bitmap io2Bitmap(InputStream inputStream) {

        return BitmapFactory.decodeStream(inputStream);
    }

    //
    public  void  get(final String s, final MyCoolBack myCoolBack){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                myCoolBack.git(s);
//                if (s != null) {
//
//                }else {
//                    Log.d("TAG", "doInBackground: 失败数据"+s);
//                    Throwable throwable = null;
//                    myCoolBack.failure(throwable);
//                }

            }

            @Override
            protected String doInBackground(Void... voids) {
                String json=null;
                HttpURLConnection http=null;
                InputStream inputStream=null;
                try {
                    URL url = new URL(s);
                    http= (HttpURLConnection) url.openConnection();
                    http.setRequestMethod("GET");
                    http.setConnectTimeout(5000);
                    http.setReadTimeout(5000);
                    http.connect();
                    inputStream=http.getInputStream();
                    if (http.getResponseCode()==200){
                        json=io2String(inputStream);
                    }else {
                        Log.d("TAG", "doInBackground: 失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (http != null) {
                        http.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return json;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    private String io2String(InputStream inputStream) {
        String json=null;
        byte[] bytes = new byte[1024];
        int tybe=-1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
           while ((tybe=inputStream.read(bytes))!=-1){
               byteArrayOutputStream.write(bytes,0,tybe);
           }
           json=new String(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public interface MyCoolBack{
        void git(String s);
        void failure(Throwable throwable);
    }
}
