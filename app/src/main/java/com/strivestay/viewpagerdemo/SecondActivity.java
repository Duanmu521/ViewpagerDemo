package com.strivestay.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.strivestay.viewpagerdemo.fragment.PagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Viewpager结合Fragment使用
 * @author StriveStay
 * @date 2018/2/23
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setToolbar("结合Fragment使用",ThirdActivity.class);

        setVp();

    }

    private void setVp() {
        final List<PagerFragment> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PagerFragment fragment = new PagerFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content","第"+i+"个Fragment");
            fragment.setArguments(bundle);

            list.add(fragment);
        }

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
//        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                return list.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//        });

        vp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

}
