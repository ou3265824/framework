package com.example.framework.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.framework.R;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class OclickItem extends LinearLayout{

    private Context mContext;
    private View view;
    private int iv_left;
    private int iv_right;
    private String name;
    private String number;
    private TextView tv_item_number;

    public OclickItem(Context context) {
        super(context);
        mContext=context;
        getView();
    }

    public OclickItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        getStyledAttributes(attrs);
        getView();
    }

    public OclickItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        getStyledAttributes(attrs);
        getView();
    }

    private void getView(){
        view = inflate(mContext, R.layout.onclick_item,this);
        ImageView iv_item_left= (ImageView) view.findViewById(R.id.iv_item_left);
        iv_item_left.setImageResource(iv_left);
        TextView tv_item_name= (TextView) view.findViewById(R.id.tv_item_name);
        tv_item_name.setText(name);
        tv_item_number = (TextView) view.findViewById(R.id.tv_item_number);
        tv_item_number.setText(number);
        ImageView iv_item_right= (ImageView) view.findViewById(R.id.iv_item_right);
        iv_item_right.setImageResource(iv_right);
    }

    private void getStyledAttributes(AttributeSet attrs){
        TypedArray typedArray=mContext.obtainStyledAttributes(attrs,R.styleable.Oclick_Item);
        iv_left = typedArray.getResourceId(R.styleable.Oclick_Item_item_left_src,0);
        name = typedArray.getString(R.styleable.Oclick_Item_item_text_name);
        number = typedArray.getString(R.styleable.Oclick_Item_item_text_number);
        iv_right = typedArray.getResourceId(R.styleable.Oclick_Item_item_right_src,R.drawable.right_arrows);
        typedArray.recycle();
    }

    public void setRightText(CharSequence text){
        tv_item_number.setText(text);
    }

}
