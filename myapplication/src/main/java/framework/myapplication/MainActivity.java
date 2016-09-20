package framework.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.framework.mvp.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_main);
        setTitle("aaa");
    }

    @Override
    protected void getonCreate() {

    }


}
