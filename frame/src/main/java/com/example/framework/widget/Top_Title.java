package com.example.framework.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.framework.R;

/**
 * Created by Administrator on 2016/6/8 0008.
 */
public class Top_Title extends LinearLayout {


    private Context mContext;
    private TextView top_title;
    private Toolbar toolbar;
    private ImageView top_back;
    private View mView;
    private RelativeLayout top_right;
    private ImageView top_right_image;
    private TextView top_right_text;

    public Top_Title(Context context) {
        super(context);
        mContext = context;
        getView();
    }

    public Top_Title(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        getView();
    }

    public Top_Title(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        getView();
    }

    private void getView() {
        mView = inflate(mContext, R.layout.top_title, this);
        toolbar = (Toolbar) mView.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        top_title = (TextView) mView.findViewById(R.id.top_title);
        top_back = (ImageView) mView.findViewById(R.id.top_back);
        top_right = (RelativeLayout) mView.findViewById(R.id.top_right);
        top_right_image = (ImageView) mView.findViewById(R.id.top_right_image);
        top_right_text = (TextView) mView.findViewById(R.id.top_right_text);

//        initTopBar(view);
    }

    public void setOnClickLeftBack(final Activity activity) {
        top_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity != null) {
                    activity.finish();
                }
            }
        });
    }

    public void setOnClickRight(OnClickListener onClickRight) {
        top_right.setOnClickListener(onClickRight);
    }

    public void setLeftView(int visibility) {
        top_back.setVisibility(visibility);
    }

    public void setRightView(int visibility) {
        top_right.setVisibility(visibility);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setTitle(CharSequence text) {
        top_title.setText(text);
    }

    public void setTitle(int text) {
        top_title.setText(text);
    }

    public void setTopView(int view) {
        mView.setVisibility(view);
    }

    public void setLeftImage(int resid) {
        top_back.setImageResource(resid);
    }

    public void setRightImage(int resid) {
        top_right_image.setImageResource(resid);
        top_right_text.setVisibility(View.GONE);
    }
    public void setRightText(CharSequence text) {
        top_right_text.setText(text);
        top_right_image.setVisibility(View.GONE);
    }


//    private void initTopBar(View view) {
//        int height= ScreenUtils.getScreenHeight(mContext);
//        view.setLayoutParams(new LinearLayout.LayoutParams(
//                LayoutParams.MATCH_PARENT, height / 2, 0));
//    }
}
