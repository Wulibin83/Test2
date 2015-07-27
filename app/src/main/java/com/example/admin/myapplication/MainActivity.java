package com.example.admin.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * 中文
     */

    private Button button1;
    private Button button2;
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            ;
            //downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
    }

    private void setListeners() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    private void findViews() {
        button1= (Button) this.findViewById(R.id.button1);
        button2=(Button)this.findViewById(R.id.button2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:{
                Intent startIntent=new Intent(this,MyService.class);
                bindService(startIntent,connection,BIND_AUTO_CREATE);
                //startService(startIntent);
                break;
            }
            case R.id.button2:{
                Intent stopIntent=new Intent(this,MyService.class);
                unbindService(connection);
                //stopService(stopIntent);
                break;
            }
            default:{
                break;
            }
        }

    }
}
