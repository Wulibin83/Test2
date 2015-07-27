package com.example.admin.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private  int i=0;
    public MyService() {
    }

    private DownloadBinder mbinder=new DownloadBinder();

    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.i("TAG","22222");
        }
        public int stopDownload(){
            Log.i("TAG","33333");
            return 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        IBinder ib=mbinder;
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        do{
            i=i++;
        }while(i<=100);
        return super.onStartCommand(intent, flags, startId);
    }
}
