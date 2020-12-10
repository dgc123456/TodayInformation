package com.todayinformation;


import android.os.Handler;
import android.os.Looper;

/**
 * ================================================
 * 作    者：
 * 版    本：
 * 创建日期：
 * 描    述：计时器
 * 修订历史：
 * ================================================
 */
public class CustomCountDownTimer implements Runnable {
    private int mTime = 0;
    private ICountDownHandler mICountDownHandler;
    Handler myHandler;
    boolean bRunFlag = false;
    int mCurrentTime = 0;

    public CustomCountDownTimer() {
    }

    public CustomCountDownTimer(int maxTime, ICountDownHandler iCountDownHandler) {
        myHandler = new Handler();
        mTime = maxTime;
        mCurrentTime = maxTime;
        mICountDownHandler = iCountDownHandler;

    }

    @Override
    public void run() {
        if (!bRunFlag) {
            return;
        }

        if (mCurrentTime == 0) {
            cancel();
            if (mICountDownHandler != null) {
                mICountDownHandler.onFinish();
            }
            return;
        }

        if (mICountDownHandler != null) {
            mICountDownHandler.onTicker(mCurrentTime);
        }
        mCurrentTime--;
        //myHandler的作用是让run一直运行
        myHandler.postDelayed(this, 1000);
    }

    public void start() {
        bRunFlag = true;
        myHandler.post(this);
    }

    public void cancel() {
        bRunFlag = false;
        myHandler.removeCallbacks(this);
    }
}
