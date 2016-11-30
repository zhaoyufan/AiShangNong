package com.upic.aishangnong.ui.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.upic.aishangnong.R;
import com.upic.aishangnong.ui.base.BaseActivity;
import com.upic.aishangnong.ui.main.adapter.FragmentMainTabAdapter;

public class MainActivity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentMainTabAdapter fragmentMainTabAdapter;
    private String[] mTabTitles;
    private Fragment[] mFragments;
    private Integer[] mTabIcons;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tabLayout = (TabLayout) $(R.id.tabl_navigation);
        viewPager = (ViewPager) $(R.id.vp_content);
    }

    @Override
    public void initClick() {

    }

    @Override
    public void initData() {
        mTabTitles = new String[]{"1","2","+","1","2"};
        mFragments = new Fragment[]{new FragmentTab1(),new FragmentTab2(),new FragmentTab3(),new FragmentTab4()};
        mTabIcons = new Integer[]{R.drawable.tab1_selector,R.drawable.tab2_selector,R.drawable.tab1_selector,R.drawable.tab2_selector};
        setupViewPager();
        setupTabLayout();
        tabLayout.getTabAt(0).select();
    }
    private void setupTabLayout() {
        //TabGravity:放置Tab的Gravity,有GRAVITY_CENTER 和 GRAVITY_FILL两种效果。顾名思义，一个是居中，另一个是尽可能的填充
        //（注意，GRAVITY_FILL需要和MODE_FIXED一起使用才有效果）
        //TabMode:布局中Tab的行为模式（behavior mode），有两种值：MODE_FIXED 和 MODE_SCROLLABLE。
        //MODE_FIXED:固定tabs，并同时显示所有的tabs。
        //MODE_SCROLLABLE：可滚动tabs，显示一部分tabs，在这个模式下能包含长标签和大量的tabs，最好用于用户不需要直接比较tabs
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(fragmentMainTabAdapter.getTabView(i));//设置tab内容
        }
        tabLayout.requestFocus();
    }

    private void setupViewPager() {
        fragmentMainTabAdapter = new FragmentMainTabAdapter(context, getSupportFragmentManager(), mFragments, mTabTitles, mTabIcons);
        viewPager.setAdapter(fragmentMainTabAdapter);
        viewPager.setOffscreenPageLimit(2);//设置相邻两个页面会被缓存
    }
}
