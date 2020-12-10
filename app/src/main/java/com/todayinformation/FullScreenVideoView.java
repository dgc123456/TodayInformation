package com.todayinformation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * ================================================
 * 作    者：
 * 版    本：
 * 创建日期：
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class FullScreenVideoView extends VideoView {
    public FullScreenVideoView(Context context) {
        super(context);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //widthMeasureSpec:
        int height = getDefaultSize(0,heightMeasureSpec);
        int width = getDefaultSize(0,widthMeasureSpec);
        setMeasuredDimension(width,height);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
