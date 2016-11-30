package com.upic.aishangnong.ui.main.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.upic.aishangnong.R;


/**
 * Created by ZYF on 2016/11/16.
 */
public class FragmentMainTabAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    private Fragment[] mFragments = null;
    private String[] mFragmentTitles =null;
    private Integer[] mFragmentIcons = null;

    //带图片的Tab
    public FragmentMainTabAdapter(Context mContext, FragmentManager fm, Fragment[] mFragments, String[] mFragmentTitles, Integer[] mFragmentIcons) {
        super(fm);
        this.mContext = mContext;
        this.mFragments = mFragments;
        this.mFragmentTitles = mFragmentTitles;
        this.mFragmentIcons = mFragmentIcons;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    public View getTabView(int position) {
        View tab = LayoutInflater.from(mContext).inflate(R.layout.item_main_tab, null);
        TextView tabText = (TextView) tab.findViewById(R.id.main_tab_title);
        ImageView tabImage = (ImageView) tab.findViewById(R.id.main_tab_icon);
        tabText.setText(mFragmentTitles[position]);
        tabImage.setBackgroundResource(mFragmentIcons[position]);
        if (position == 0) {
            tab.setSelected(true);
        }
        return tab;
    }

}
