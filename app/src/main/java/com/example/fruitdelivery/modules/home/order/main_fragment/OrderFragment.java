package com.example.fruitdelivery.modules.home.order.main_fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;
import com.example.fruitdelivery.modules.home.order.Fragments.allitem.AllItemFragment;
import com.example.fruitdelivery.util.AnalysisUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends BaseFragment<OrderPresenter> implements OrderView {
    private List<Fragment> mFragmentData = new ArrayList<>();
    private List<String> mTitleData = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager mVpDisplay;
    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected OrderPresenter createPresenter() {
        return new OrderPresenter();
    }

    @Override
    protected void initView() {
        mVpDisplay = mView.findViewById(R.id.vp_order);
        tabLayout = mView.findViewById(R.id.tl_order_tab);
        mTitleData.add("全部");
        mTitleData.add("待付款");
        mTitleData.add("待签收");
        mTitleData.add("待评价");
        mTitleData.add("已完成");
        for (int i = 0;i < 5;i++) {
            mFragmentData.add(new AllItemFragment());
            tabLayout.addTab(tabLayout.newTab().setText(mTitleData.get(i)));
        }
        mVpDisplay.setAdapter(new OrderViewPagerAdapter(getActivity().getSupportFragmentManager(),mFragmentData,mTitleData));
        tabLayout.setupWithViewPager(mVpDisplay);
    }
}
