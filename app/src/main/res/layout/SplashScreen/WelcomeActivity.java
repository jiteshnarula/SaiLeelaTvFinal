package com.devicedisk.saileelatv.SplashScreen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.devicedisk.saileelatv.R;

public class WelcomeActivity extends AppCompatActivity {

    public static int spash_screen_time_out = 2000;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        progressBar = (ProgressBar) findViewById(R.id.progress);


        if(!isConnected(com.devicedisk.saileelatv.SplashScreen.WelcomeActivity.this)){
            buildDialog(com.devicedisk.saileelatv.SplashScreen.WelcomeActivity.this).show();
            progressBar.setVisibility(View.INVISIBLE);
        }
        else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(com.devicedisk.saileelatv.SplashScreen.WelcomeActivity.this, com.devicedisk.saileelatv.MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            },spash_screen_time_out);

        }
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            NetworkInfo wifi = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
            NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) {
                return true;
            }
        }
        return false;
    }


    public AlertDialog.Builder buildDialog(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need an internet connection to access this app. Press ok to Exit or Close");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });


        return builder;
    }
}
