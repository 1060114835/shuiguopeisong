package com.example.fruitdelivery.modules.home.order.main_fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.modules.home.order.Fragments.accomplish.AccomplishFragment;
import com.example.fruitdelivery.modules.home.order.Fragments.allitem.AllItemFragment;
import com.example.fruitdelivery.modules.home.order.Fragments.no_evaluate.NoEvaluateFragment;
import com.example.fruitdelivery.modules.home.order.Fragments.no_sign.NoSignFragment;
import com.example.fruitdelivery.util.AnalysisUtil;
import com.example.fruitdelivery.util.TestBean.JsonRootBean;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends BaseFragment<OrderPresenter> implements OrderView {
    private List<Fragment> mFragmentData = new ArrayList<>();
    private List<String> mTitleData = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager mVpDisplay;
    private boolean flags = true;

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
        if (flags) {
            mTitleData.add("全部");
            mTitleData.add("待付款");
            mTitleData.add("待签收");
            mTitleData.add("待评价");
            mTitleData.add("已完成");
            for (int i = 0; i < 5; i++)
                tabLayout.addTab(tabLayout.newTab().setText(mTitleData.get(i)));
            mFragmentData.add(new AllItemFragment());
            mFragmentData.add(new AllItemFragment());
            mFragmentData.add(new NoSignFragment());
            mFragmentData.add(new NoEvaluateFragment());
            mFragmentData.add(new AccomplishFragment());
            flags = false;
        }
        mVpDisplay.setAdapter(new OrderViewPagerAdapter(getChildFragmentManager(), mFragmentData, mTitleData));
        tabLayout.setupWithViewPager(mVpDisplay);
    }
}
