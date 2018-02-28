package com.strivestay.viewpagerdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.strivestay.viewpagerdemo.R;

import java.util.List;

/**
 * Viewpager基本使用适配器
 * @author StriveStay
 * @date 2018/2/6
 */
public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> mData;
    private String[] mTitles = {"标题一","标题二","标题三"};

    public MyPagerAdapter(Context context ,List<String> list) {
        mContext = context;
        mData = list;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.item_base,null);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(mData.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container,position,object); 这一句要删除，否则报错
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
