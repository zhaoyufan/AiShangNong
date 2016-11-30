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
public class FragmentMainThemeTabAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    private Fragment[] mFragments = null;
    private String[] mFragmentTitles =null;
    //没有图片的Tab
    public FragmentMainThemeTabAdapter(Context mContext, FragmentManager fm, Fragment[] mFragments, String[] mFragmentTitles) {
        super(fm);
        this.mContext = mContext;
        this.mFragments = mFragments;
        this.mFragmentTitles = mFragmentTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    public View getThemeTabView(int position) {
        View tab = LayoutInflater.from(mContext).inflate(R.layout.item_theme_tab, null);
        TextView tabText = (TextView) tab.findViewById(R.id.theme_tab_title);
        tabText.setText(mFragmentTitles[position]);
        if (position == 2) {
            tab.setSelected(true);
        }
        return tab;
    }
}
