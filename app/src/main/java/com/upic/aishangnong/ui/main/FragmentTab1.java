package com.upic.aishangnong.ui.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.upic.aishangnong.R;
import com.upic.aishangnong.ui.base.BaseFragment;
import com.upic.aishangnong.ui.main.adapter.FragmentMainThemeTabAdapter;

/**
 * Created by ZYF on 2016/11/16.
 */
public class FragmentTab1 extends BaseFragment implements View.OnClickListener
{
    LinearLayout rl_title,citySelect;
    TextView tv_search;
    ImageView iv_msg,iv_more;//更多，消息
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentMainThemeTabAdapter fragmentMainThemeTabAdapter;
    private String[] mTabTitles;
    private Fragment[] mFragments;

    @Override
    public int getContentView() {
        return R.layout.fragment_main_1;
    }

    @Override
    public void initView() {
        rl_title = (LinearLayout) $(R.id.rl_title);//标题栏
        citySelect = (LinearLayout) $(R.id.left);
        rl_title.getBackground().setAlpha(0);
        tv_search = (TextView) $(R.id.tv_search);
        iv_msg = (ImageView) $(R.id.iv_msg);
        iv_more = (ImageView) $(R.id.iv_more);
        tabLayout = (TabLayout) $(R.id.fragmnet_1_tabLayout);
        viewPager = (ViewPager) $(R.id.fragmnet_1_viewpager);
        mTabTitles = new String[]{"出行圈","玩乐"};
        mFragments = new Fragment[]{new FragmentTab1_1() , new FragmentTab1_2()};
        setupViewPager();
        setupTabLayout();
        tabLayout.getTabAt(1).select();

//        mRecyclerView = (PullRecyclerView) $(R.id.mRecyclerView);
//        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
//        mRecyclerView.setOnHeaderRefreshListener(this);//设置下拉监听
//        mRecyclerView.setOnFooterRefreshListener(this);//设置上拉监听
//        mRecyclerView.setOnPullDownScrollListener(this);//设置下拉滑动监听
//        mRecyclerView.setCanScrollAtRereshing(false);//设置正在刷新时是否可以滑动，默认不可滑动
//        mRecyclerView.setCanPullDown(true);//设置是否可下拉
//        mRecyclerView.setCanPullUp(true);//设置是否可上拉
////        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
////            @Override
////            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
////                super.onScrollStateChanged(recyclerView, newState);
////            }
////
////            @Override
////            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {//监听滑动距离以改变标题栏透明度
////                super.onScrolled(recyclerView, dx, dy);
////                y += dy;
////                if (y >= bannerH) {
////                    rl_title.getBackground().setAlpha(255);
////                    rl_title.setVisibility(View.VISIBLE);
////                } else if (y >= 0 && y < bannerH) {
////                    if (isPullDown) {
////                        rl_title.setVisibility(View.GONE);
////                    } else {
////                        rl_title.getBackground().setAlpha((int) (255 * ((double) y / bannerH)));
////                        rl_title.setVisibility(View.VISIBLE);
////                    }
////                } else {
////                    rl_title.getBackground().setAlpha(0);
////                    rl_title.setVisibility(View.GONE);
////                }
////            }
////        });
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
            tab.setCustomView(fragmentMainThemeTabAdapter.getThemeTabView(i));//设置tab内容
        }
        tabLayout.requestFocus();
    }

    private void setupViewPager() {
        fragmentMainThemeTabAdapter = new FragmentMainThemeTabAdapter(context, getFragmentManager(), mFragments, mTabTitles);
        viewPager.setAdapter(fragmentMainThemeTabAdapter);
        viewPager.setOffscreenPageLimit(1);//设置相邻两个页面会被缓存
    }

    @Override
    public void initClick() {
        tv_search.setOnClickListener(this);
        iv_more.setOnClickListener(this);
        iv_msg.setOnClickListener(this);
        citySelect.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search:
                Toast.makeText(context, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_msg:
                Toast.makeText(context, "消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_more:
                Toast.makeText(context, "more", Toast.LENGTH_SHORT).show();
                break;
            case R.id.left:{
                Toast.makeText(context, "城市选择", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
