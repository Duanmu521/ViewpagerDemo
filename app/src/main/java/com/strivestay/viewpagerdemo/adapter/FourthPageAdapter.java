package com.strivestay.viewpagerdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.strivestay.viewpagerdemo.R;

/**
 * 画廊效果，page宽度占满vp
 * @author StriveStay
 * @date 2018/2/24
 */
public class FourthPageAdapter extends PagerAdapter {
    private Context mContext;

    public FourthPageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 就4张图片
        position %= 4;

        View view = View.inflate(mContext,R.layout.item_banner,null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_banner);
        int resourceId = mContext.getResources().getIdentifier("img" + (position + 1), "drawable", mContext.getPackageName());
        Glide.with(mContext).load(resourceId).into(iv);
        //            iv.setImageResource(resourceId);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

}
