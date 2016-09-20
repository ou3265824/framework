package com.example.framework.mvp.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;


import com.example.framework.R;
import com.example.framework.mvp.dialog.loading.LoadingView;
import com.example.framework.utils.ToastUtil;
import com.example.framework.widget.title.TopTitle;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/17.
 */
public abstract class BaseActivity extends AppCompatActivity {


    private TopTitle toolbarTop;
    private LinearLayout body;

    /*
                 * 设置布局
                 */
//    protected abstract int getLayout();
    protected abstract void setLayout();

    /**
     * onCreate方法
     *
     * @param
     */
    protected abstract void getonCreate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(true);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(android.R.color.transparent);
//        }

        BaseApplication.getInstance().addActivity(this);
        BaseApplication.getInstance().setActivity(this);
        setContentView(R.layout.base_layout);
        toolbarTop = (TopTitle) findViewById(R.id.toolbar_top);
        body = (LinearLayout) findViewById(R.id.body);
        if(getSupportActionBar()==null){
            setSupportActionBar(toolbarTop.getToolbar());
        }

        setLayout();
        getonCreate();
        setLeftOnBack();
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);

    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseApplication.getInstance().setActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        BaseApplication.getInstance().removeActivity(this);
        BaseApplication.getInstance().setActivity(null);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (layoutResID == R.layout.base_layout)
            super.setContentView(layoutResID);
        else {
            getLayoutInflater().inflate(layoutResID, body);
            ButterKnife.bind(this);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        body.removeAllViews();
        body.addView(view, params);
        getonCreate();
    }

    @Override
    public void setContentView(View view) {
        body.removeAllViews();
        body.addView(view);
        getonCreate();
    }

    public void setContentView(int layoutResId, boolean isShowTitle) {
        if (!isShowTitle) {
            toolbarTop.setVisibility(View.GONE);
        }
        this.setContentView(layoutResId);
    }

    public void setTitle(CharSequence text){
        toolbarTop.setTitle(text);
    }
    public void setTitle(int text){
        toolbarTop.setTitle(getString(text));
    }
    public void setTopView(int view){
        toolbarTop.setTopView(view);
    }
    public void setLeftOnBack(){
        toolbarTop.setOnClickLeftBack(this);
    }
    public void setrightOnClick(View.OnClickListener listener){
        toolbarTop.setOnClickRight(listener);
    }
    public void setLeftImage(int resid) {
        toolbarTop.setLeftImage(resid);
    }
    public void setRightImage(int resid) {
        toolbarTop.setRightImage(resid);
    }
    public void setRightText(CharSequence text) {
        toolbarTop.setRightText(text);
    }

    public void setLeftView(int view) {
        toolbarTop.setLeftView(view);
    }

    public <T extends View> T getFindViewByid(int id){
        return (T) findViewById(id);
    }

    public void getLoadingShow(){
//        if(!isFinishing()){
//            LoadingDialog.show();
//        }
        LoadingView.show();
    }
    public void getLoadingHide(){
//        LoadingDialog.dismiss();
        LoadingView.dismiss();
    }


    public void startActivity(Class<? extends Activity> target, Bundle bundle, boolean finish) {
        Intent intent = new Intent();
        intent.setClass(this, target);
        if (bundle != null)
            intent.putExtra(getPackageName(), bundle);
        startActivity(intent);
        if (finish)
            finish();
    }

    public void onToast(Object message){
        if(message instanceof String)
        {
            ToastUtil.show(this,(String) message);
        }else if(message instanceof Integer){
            ToastUtil.show(this, getString((Integer) message));
        }else{
            ToastUtil.show(this,(String) message);
        }
    }

    public void onToastLong(String message){
        ToastUtil.showLong(this,message);
    }

    long exitTime=0;
    public void onExit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            ToastUtil.show(this, "再按一次退出程序");
            exitTime = System.currentTimeMillis();
        }else {
            finish();
            System.exit(0);
        }
    }

}
