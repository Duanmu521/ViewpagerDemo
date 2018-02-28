package com.strivestay.viewpagerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Activity基类
 * @author StriveStay
 * @date 2018/2/23
 */
public class BaseActivity extends AppCompatActivity {
    private Activity mActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    /**
     * Toolbar设置
     */
    protected void setToolbar(String toolbarTitle, final Class nextActivity) {
        // 设置标题
        ((TextView)findViewById(R.id.toolbar_title)).setText(toolbarTitle);

        // 设置Toolbar代替Actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // 设置返回按钮
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_left);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 设置下一步按钮
        ImageView ivNext = (ImageView) findViewById(R.id.iv_next);
        if(nextActivity!=null){
            ivNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(mActivity,nextActivity));
                }
            });

        }else{
            ivNext.setVisibility(View.GONE);
        }
    }
}
