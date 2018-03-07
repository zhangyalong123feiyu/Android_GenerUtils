package com.zyl_android.generalutils.coustomview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.zyl_android.generalutils.R;


/**
 * Created by Wh on 2017-7-13.
 */

public class WaitView extends AppCompatImageView {
    private boolean isStart = false;
    private int cnt = 0;

    private final static int csp = 6;
    private final static int sp = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setRotation(cnt);
            cnt+=csp;
            if(isStart){
                handler.sendEmptyMessageDelayed(0, sp);
            }
        }
    };

    public synchronized void start(){
        if(!isStart){
            isStart = true;
            handler.sendEmptyMessageDelayed(0,sp);
        }
    }

    public synchronized void stop(){
        isStart = false;
    }

    public WaitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setImageResource(R.mipmap.img_wait_icon);
    }
}
