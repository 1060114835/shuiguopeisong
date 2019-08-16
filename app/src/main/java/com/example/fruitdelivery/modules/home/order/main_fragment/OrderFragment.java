package com.example.fruitdelivery.modules.home.order.main_fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseActivityWithToolbar;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.base.IView;
import com.example.fruitdelivery.modules.home.order.fragments.AllItemBean;
import com.example.fruitdelivery.modules.home.order.fragments.TypeConstant;
import com.example.fruitdelivery.modules.home.order.fragments.accomplish.AccomplishFragment;
import com.example.fruitdelivery.modules.home.order.fragments.no_pay.NoPayFragment;
import com.example.fruitdelivery.modules.home.order.fragments.no_evaluate.NoEvaluateFragment;
import com.example.fruitdelivery.modules.home.order.fragments.no_sign.NoSignFragment;
import com.example.fruitdelivery.modules.home.order.fragments.total.TotalFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends BaseFragment<OrderPresenter> implements IView {
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

        ArrayList<AllItemBean> mData = new ArrayList<>();
        mPresenter.initData(mData);
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
            mFragmentData.add(new TotalFragment(mData));
            mFragmentData.add(new NoPayFragment(mPresenter.filtrateToNoPay(mData)));
            mFragmentData.add(new NoSignFragment(mPresenter.filtrateToNoSign(mData)));
            mFragmentData.add(new NoEvaluateFragment(mPresenter.filtrateToNoEvaluate(mData)));
            mFragmentData.add(new AccomplishFragment(mPresenter.filtrateAccomplish(mData)));
            flags = false;
        }
        mVpDisplay.setAdapter(new OrderViewPagerAdapter(getChildFragmentManager(), mFragmentData, mTitleData));
        tabLayout.setupWithViewPager(mVpDisplay);
    }
    @Override
    protected void onVisibleToUser() {
        BaseActivityWithToolbar activity = (BaseActivityWithToolbar) getBActivity();
        activity.setTitle("我的订单");
        activity.setStatusColor(Color.parseColor("#ffb62b"));
    }
}
