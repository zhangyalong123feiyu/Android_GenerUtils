package com.zyl_android.generalutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseArray;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by bibinet on 2017-4-22.
 */

public class DialogUtils {
    private DialogListioner dialogListioner;
    private View view;
    private AlertDialog dialog;
    private ProgressDialog progressDialog;
    private View bottomView;
    private Dialog bottomDialog;

    public <T>T getDialogView(int id) {
        SparseArray<View> views=new SparseArray<>();
       View childView=views.get(id);
        if (childView==null) {
            childView=view.findViewById(id);
            views.put(id,childView);
        		}
        return (T)childView;
    }

    public void setDialogText(int id,String descrp){
        TextView textView=(TextView)view.findViewById(id);
        textView.setText(descrp);
    }
    public void settDialogImageView(int id,int resouce){
        AppCompatImageView imageView = view.findViewById(id);
        imageView.setImageResource(resouce);
    }

    public void diloagShow(Context context, int ResuoreceId) {
        AlertDialog.Builder dialogBuider = new AlertDialog.Builder(context);
        dialog = dialogBuider.create();
        view = LayoutInflater.from(context).inflate(ResuoreceId, null);
        dialog.setView(view);
        dialog.show();
    }


    public void dialogDismiss() {
        dialog.dismiss();
    }

    public void setDialoglistioner(DialogListioner listioner) {
        this.dialogListioner = listioner;
    }

    public interface DialogListioner {
        void onDialogClickListioner(View view);
    }

/*  -------------------------------------- ------------bottomdialog ----------------------------------------------------------------------------*/

    public void showBottomDiaglog(Context context, int layoutId) {
        bottomDialog = new Dialog(context);
        bottomView = LayoutInflater.from(context).inflate(layoutId, null, false);
        bottomDialog.setContentView(bottomView);
        Window window = bottomDialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        WindowManager.LayoutParams params = window.getAttributes();
        WindowManager m = ((Activity) context).getWindowManager();
        Display display = m.getDefaultDisplay();
        int widith = (int) (display.getWidth());
        int hight = (int) (WindowManager.LayoutParams.WRAP_CONTENT);
        params.width = widith;
        params.height = hight;
        window.setAttributes(params);
        bottomDialog.show();
        bottomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListioner.onDialogClickListioner(v);
            }
        });
    }
    public View getBottomView() {
        return bottomView;
    }
    public void disBottomDiaglog() {
        bottomDialog.dismiss();
    }

    public void showProgressDialog(Context context, String dscrp,int icon) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(dscrp);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
        progressDialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        progressDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        progressDialog.setIcon(icon);//
        progressDialog.show();
    }

    public void disProgressDialog() {
        progressDialog.dismiss();
    }
}
