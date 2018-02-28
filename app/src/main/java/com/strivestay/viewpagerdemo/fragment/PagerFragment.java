package com.strivestay.viewpagerdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.strivestay.viewpagerdemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {
    String mContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContent = (String) getArguments().get("content");
        View view = inflater.inflate(R.layout.fragment_pager, container, false) ;
        TextView textView = (TextView) view.findViewById(R.id.tv);
        textView.setText(mContent);

        return view;
    }

}
