package com.example.checkforupdate;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private DownloadManager downloadManager;
//    private SharedPreferences prefs;
//    private static final String DL_ID = "downloadId";
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
//        prefs = PreferenceManager.getDefaultSharedPreferences(this);
//    }
//    @Override
//    protected void onPause() {
//        // TODO Auto-generated method stub
//        super.onPause();
//        unregisterReceiver(receiver);
//    }
//    @Override
//    protected void onResume() {
//        // TODO Auto-generated method stub
//        super.onResume();
//        if(!prefs.contains(DL_ID)) {
//            String url = "http://ttbs.guangsuss.com/image/54a3228d143524f547ebec7af476ac89";
//            //开始下载
//            Uri resource = Uri.parse(encodeGB(url));
//            DownloadManager.Request request = new DownloadManager.Request(resource);
//            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
//            request.setAllowedOverRoaming(false);
//            //设置文件类型
//            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//            String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url));
//            request.setMimeType(mimeString);
//            //在通知栏中显示
//            request.setShowRunningNotification(true);
//            request.setVisibleInDownloadsUi(true);
//            //sdcard的目录下的download文件夹
//            request.setDestinationInExternalPublicDir("/download/", "G3.mp4");
//            request.setTitle("移动G3广告");
//            long id = downloadManager.enqueue(request);
//            //保存id
//            prefs.edit().putLong(DL_ID, id).commit();
//        } else {
//            //下载已经开始，检查状态
//            queryDownloadStatus();
//        }
//
//        registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
//    }
//
//    /**
//     * 如果服务器不支持中文路径的情况下需要转换url的编码。
//     * @param string
//     * @return
//     */
//    public String encodeGB(String string)
//    {
//        //转换中文编码
//        String split[] = string.split("/");
//        for (int i = 1; i < split.length; i++) {
//            try {
//                split[i] = URLEncoder.encode(split[i], "GB2312");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            split[0] = split[0]+"/"+split[i];
//        }
//        split[0] = split[0].replaceAll("\\+", "%20");//处理空格
//        return split[0];
//    }
//
//    private BroadcastReceiver receiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            //这里可以取得下载的id，这样就可以知道哪个文件下载完成了。适用与多个下载任务的监听
//            Log.v("intent", ""+intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0));
//            queryDownloadStatus();
//        }
//    };
//
//    private void queryDownloadStatus() {
//        DownloadManager.Query query = new DownloadManager.Query();
//        query.setFilterById(prefs.getLong(DL_ID, 0));
//        Cursor c = downloadManager.query(query);
//        if(c.moveToFirst()) {
//            int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
//            switch(status) {
//                case DownloadManager.STATUS_PAUSED:
//                    Log.v("down", "STATUS_PAUSED");
//                case DownloadManager.STATUS_PENDING:
//                    Log.v("down", "STATUS_PENDING");
//                case DownloadManager.STATUS_RUNNING:
//                    //正在下载，不做任何事情
//                    Log.v("down", "STATUS_RUNNING");
//                    break;
//                case DownloadManager.STATUS_SUCCESSFUL:
//                    //完成
//                    Log.v("down", "下载完成");
//                    break;
//                case DownloadManager.STATUS_FAILED:
//                    //清除已下载的内容，重新下载
//                    Log.v("down", "STATUS_FAILED");
//                    downloadManager.remove(prefs.getLong(DL_ID, 0));
//                    prefs.edit().clear().commit();
//                    break;
//            }
//        }
//    }


    Button content;
    ImageView image;
    Bitmap bitmap;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content=(Button)findViewById(R.id.content);
        image=(ImageView)findViewById(R.id.image);

        content.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    /**
     * 获取网络图片
     * @param imageurl 图片网络地址
     * @return Bitmap 返回位图
     */
    public Bitmap GetImageInputStream(String imageurl){
        URL url;
        HttpURLConnection connection=null;
        Bitmap bitmap=null;
        try {
            url = new URL(imageurl);
            connection=(HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(6000); //超时设置
            connection.setDoInput(true);
            connection.setUseCaches(false); //设置不使用缓存
            InputStream inputStream=connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.content:
                //加入网络图片地址
                new Task().execute("http://pic.4j4j.cn/upload/pic/20130617/55695c3c95.jpg");
                break;

            case R.id.image:
                //点击图片后将图片保存到SD卡跟目录下的Test文件夹内
                SavaImage(bitmap, Environment.getExternalStorageDirectory().getPath()+"/Test");
                Toast.makeText(getBaseContext(), "图片保存", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0x123){
                image.setImageBitmap(bitmap);
            }
        }
    };



    /**
     * 异步线程下载图片
     *
     */
    class Task extends AsyncTask<String, Integer, Void> {

        protected Void doInBackground(String... params) {
            bitmap=GetImageInputStream((String)params[0]);
            return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Message message=new Message();
            message.what=0x123;
            handler.sendMessage(message);
        }

    }

    /**
     * 保存位图到本地
     * @param bitmap
     * @param path 本地路径
     * @return void
     */
    public void SavaImage(Bitmap bitmap, String path){
        File file=new File(path);
        FileOutputStream fileOutputStream=null;
        //文件夹不存在，则创建它
        if(!file.exists()){
            file.mkdir();
        }
        try {
            fileOutputStream=new FileOutputStream(path+"/"+System.currentTimeMillis()+".png");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPermission(){

    }
}

