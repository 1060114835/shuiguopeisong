package com.example.fruitdelivery.modules.home.order.fragments.total;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.modules.home.order.fragments.AllItemBean;
import com.example.fruitdelivery.modules.home.order.fragments.no_pay.NoPayFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressLint("ValidFragment")
public class TotalFragment extends BaseFragment<TotalPresenter> implements TotalRecyclerViewAdapter.OnClickListener {
    private RecyclerView mRecyclerView;
    private TotalRecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<AllItemBean> mData;
    private PopupWindow mPopupWindow;
    private View mPopupView;
    private ArrayList<String> mPriceData = new ArrayList<>();
    private ArrayList<String> mWeightData = new ArrayList<>();


    @SuppressLint("ValidFragment")
    public TotalFragment(List<AllItemBean> mData) {
        this.mData = mData;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_total;
    }

    @Override
    protected TotalPresenter createPresenter() {
        return new TotalPresenter();
    }

    @Override
    protected void initView() {
        initPayData();
        mRecyclerView = mView.findViewById(R.id.rv_order_total);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new TotalRecyclerViewAdapter(mData);
        mAdapter.setOnClickListener(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClickStore(int position) {
        toast("跳转店铺详情页");
    }

    @Override
    public void onClickThing(int position) {
        toast("跳转商品详情页");
    }

    @Override
    public void onClickEvaluate(int position) {
        toast("跳转评价页");
    }

    @Override
    public void onClickPay(int position) {
        popupPayPage(mPriceData,mWeightData);
    }

    @Override
    public void onClickSign(int position) {
        toast("跳转签收页");
    }

    @Override
    public void onClickDelete(final int position, final View view) {
        final AlertDialog.Builder alterDialog = new AlertDialog.Builder(getContext());
        alterDialog.setTitle("订单");
        alterDialog.setMessage("你确认取消该订单吗?");
        alterDialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Animation animation = AnimationUtils
                        .loadAnimation(getContext(), R.anim.order_cancel_anim);
                view.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mData.remove(position);
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        alterDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {

            }
        }).show();
    }

    /**
     * 设置手机屏幕亮度变暗
     */
    public void lightOff() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.3f;
        getActivity().getWindow().setAttributes(lp);
    }

    /**
     * 设置手机屏幕亮度显示正常
     */
    public void lightOn() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 1f;
        getActivity().getWindow().setAttributes(lp);
    }


    public void initPayData() {
        mPriceData.add("1500元");
        mPriceData.add("200元");
        mPriceData.add("3000元");
        mWeightData.add("1500g");
        mWeightData.add("789g");
        mWeightData.add("900g");
    }
    public void popupPayPage(ArrayList<String> priceData,ArrayList<String> weightData) {
        if (mPopupWindow == null) {
            mPopupView = View.inflate(getContext(), R.layout.pay_order, null);
            RecyclerView weightRecyclerView = mPopupView.findViewById(R.id.ly_order_pay_addWeightText);
            RecyclerView priceRecyclerView = mPopupView.findViewById(R.id.ly_order_pay_addPriceText);
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(mPopupView.getContext());
            layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(mPopupView.getContext());
            layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
            weightRecyclerView.setLayoutManager(layoutManager1);
            priceRecyclerView.setLayoutManager(layoutManager2);
            weightRecyclerView.setAdapter(new NoPayFragment.TextRecyclerViewAdapter(weightData));
            priceRecyclerView.setAdapter(new NoPayFragment.TextRecyclerViewAdapter(priceData));
            mPopupWindow = new PopupWindow(mPopupView, WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setAnimationStyle(R.style.popWindow);
            mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    lightOn();
                }
            });
            mPopupWindow.setFocusable(true);
            mPopupWindow.setOutsideTouchable(true);
            Button btPay = mPopupView.findViewById(R.id.bt_order_pay_sure);
            btPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopupWindow.dismiss();
                }
            });
        }
        mPopupWindow.showAtLocation(mView.findViewById(R.id.rv_order_total),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        lightOff();
    }
}
