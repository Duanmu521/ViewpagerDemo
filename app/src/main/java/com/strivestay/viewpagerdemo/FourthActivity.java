package com.strivestay.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.strivestay.viewpagerdemo.adapter.FourthPageAdapter;

/**
 * viewpager实现画廊效果
 * @author StriveStay
 * @date 2018/2/23
 */
public class FourthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        setToolbar("Viewpager实现画廊效果",null);

        setVp();
    }

    private void setVp() {
        final ViewPager vp = (ViewPager) findViewById(R.id.vp);

        // 设置适配器
        vp.setAdapter(new FourthPageAdapter(this));
//        vp.setAdapter(new FourthSmallPageAdapter(this));

        // page 边距
        vp.setPageMargin((int)(getResources().getDisplayMetrics().density * 15));

        // 显示在中间，且显示第一张
        int i = Integer.MAX_VALUE/2%4;
        vp.setCurrentItem(Integer.MAX_VALUE/2 + (4-i));

        // 解决page个数较少未占满全屏，滑动闪屏问题
//        vp.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                // vp中最多能放下2个page，则让vp中page个数 < 3时，让vp不能滑动
//                if(vp.getChildCount() < 3 && event.getAction() == MotionEvent.ACTION_MOVE){
//                    return true;
//                }
//                return false;
//            }
//        });

    }
}
