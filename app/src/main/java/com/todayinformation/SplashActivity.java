package com.todayinformation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
import java.net.URL;

public class SplashActivity extends AppCompatActivity {

    FullScreenVideoView mVideoView;
    TextView tvTiaoGuo;
    CustomCountDownTimer mTimer = null;

    Handler myHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoView = findViewById(R.id.vvPlayer);
        mVideoView.setVideoURI(Uri.parse("android.resource://"
                +getPackageName()+ File.separator+R.raw.jiejing_one));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        tvTiaoGuo = findViewById(R.id.tvTiaoGuo);
        tvTiaoGuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvTiaoGuo.getText().toString().equals("跳过"))
                {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
                else{
                    if (mTimer!=null)
                    {
                        mTimer.cancel();
                    }
                }

            }
        });

        mTimer = new CustomCountDownTimer(10, new ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                tvTiaoGuo.setText(time+" 秒");
            }

            @Override
            public void onFinish() {
                tvTiaoGuo.setText("跳过");

            }
        });
        mTimer.start();

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer!=null)
        {
            mTimer.cancel();
            mTimer = null;
        }

    }
}
