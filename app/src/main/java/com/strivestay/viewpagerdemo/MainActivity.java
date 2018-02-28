package com.strivestay.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.strivestay.viewpagerdemo.adapter.MyPagerAdapter;
import com.strivestay.viewpagerdemo.pagetransformer.RotateDownPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager 基本使用示例
 * @author StriveStay
 * @date 2018/2/6
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置toolbar
        setToolbar("Viewpager基本使用",SecondActivity.class);

        setVp();
    }

    private void setVp() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
           list.add("第"+i+"个View");
        }

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new MyPagerAdapter(this,list));
        vp.setPageTransformer(true,new RotateDownPageTransformer());

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("vp","滑动中=====position:"+ position + "   positionOffset:"+ positionOffset + "   positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("vp","显示页改变=====postion:"+ position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.e("vp","状态改变=====SCROLL_STATE_IDLE====静止状态");
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.e("vp","状态改变=====SCROLL_STATE_DRAGGING==滑动状态");
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.e("vp","状态改变=====SCROLL_STATE_SETTLING==滑翔状态");
                        break;
                }
            }
        });
    }


}
