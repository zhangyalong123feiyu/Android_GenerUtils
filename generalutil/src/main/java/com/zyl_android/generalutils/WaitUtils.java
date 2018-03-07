package com.zyl_android.generalutils;

import android.view.View;

import com.zyl_android.generalutils.coustomview.WaitView;


/**
 * Created by bibinet on 2017-5-3.
 */

public class WaitUtils {
    public WaitView view;

    public WaitUtils(WaitView view){
        this.view = view;
    }

    public void open(){
        view.start();
        view.setVisibility(View.VISIBLE);
    }

    public void close(){
        view.stop();
        view.setVisibility(View.GONE);
    }

}
