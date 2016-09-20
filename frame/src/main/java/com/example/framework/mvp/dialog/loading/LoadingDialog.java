package com.example.framework.mvp.dialog.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.framework.R;
import com.example.framework.mvp.base.BaseApplication;
import com.example.framework.utils.NetUtils;
import com.example.framework.utils.ToastUtil;


/**
 * Created by Administrator on 2016/7/8 0008.
 */
public class LoadingDialog {

    private  int LOAD_TIME=1000*15;
    private  AlertDialog.Builder builder;
    private  Dialog dialog;
//    private  Context mContext;
    private  Handler handler;
    private  Runnable run;

    public LoadingDialog() {
        show();
    }

    private  void getOverTimeHide(final Context context){
        if(handler==null)
            handler=new Handler();
        if(run==null){
            run=new Runnable() {
                @Override
                public void run() {
                    ToastUtil.show(context,context.getString(R.string.net_overtime));
                    if (dialog != null) {
                        if(dialog.isShowing()) {
                            dialog.dismiss();
                            dialog=null;
                        }
                    }
                }
            };
        }
    }

    public  void show(Activity context){
        if(!NetUtils.isConnected(context)){
            ToastUtil.show(context,"网络连接失败");
            return;
        }
        getOverTimeHide(context);
        if (handler != null && run != null) {
            handler.postDelayed(run, LOAD_TIME);
        }
        if(builder==null){
            builder = new AlertDialog.Builder(context);
            View view=LayoutInflater.from(context).inflate(R.layout.loading_dialog,null);
            builder.setView(view);
            builder.setCancelable(false);
            dialog=builder.create();
            dialog.show();
        }else{
            if(!context.isFinishing()&&!dialog.isShowing()){
                dialog.show();
            }
        }

    }

    public  void show(){
        show(BaseApplication.getInstance().getActivity());
    }

    public  void dismiss(){
        if (handler != null && run != null) {
            handler.removeCallbacks(run);
        }
        if (dialog != null) {
            if(dialog.isShowing()) {
                dialog.dismiss();
                dialog=null;
            }
        }
    }


}
