package com.example.fruitdelivery.modules.home.order.Fragments.allitem;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.base.BasePresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AllItemFragment extends BaseFragment<AllItemPresenter> implements
        AllItemRecyclerViewAdapter.OnClickListener, AllItemView {
    private RecyclerView mRecyclerView;
    private PopupWindow popupWindow;
    private View popupView;
    private TranslateAnimation animation;
    private Drawable drawable;
    private List<AllItemRecyclerViewAdapter.AllItemBean> mList = new ArrayList<>();

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_allitem;
    }

    @Override
    protected AllItemPresenter createPresenter() {
        return new AllItemPresenter();
    }

    @Override
    protected void initView() {
        mPresenter.initData(mList);
        mRecyclerView = mView.findViewById(R.id.rv_order_allItem);
        drawable = new BitmapDrawable(mPresenter.getBitmap());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mView.getContext());
        AllItemRecyclerViewAdapter adapter = new AllItemRecyclerViewAdapter(mList);
        adapter.setClickListener(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public void onClickStore(int position) {

    }

    @Override
    public void onClickThing(int position) {

    }

    @Override
    public void onClickPay(int position) {
        popupPayPage();
    }

    @Override
    public void onClickCancel(int position) {

    }

    /**
     * 设置手机屏幕亮度变暗
     */
    @Override
    public void lightOff() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.3f;
        getActivity().getWindow().setAttributes(lp);
    }

    /**
     * 设置手机屏幕亮度显示正常
     */
    @Override
    public void lightOn() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 1f;
        getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void popupPayPage() {
        if (popupWindow == null) {
            popupView = View.inflate(getContext(), R.layout.pay_order, null);
            String[] prices = {"1500", "200", "3000"};
            String[] weights = {"1500g", "789g", "900g"};
            ArrayList<String> priceData = new ArrayList<>();
            priceData.add("1500元");
            priceData.add("200元");
            priceData.add("3000元");
            ArrayList<String> weightData = new ArrayList<>();
            weightData.add("1500g");
            weightData.add("789g");
            weightData.add("900g");
            RecyclerView weightRecyclerView = popupView.findViewById(R.id.ly_order_pay_addWeightText);
            RecyclerView priceRecyclerView = popupView.findViewById(R.id.ly_order_pay_addPriceText);
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(popupView.getContext());
            layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(popupView.getContext());
            layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
            weightRecyclerView.setLayoutManager(layoutManager1);
            priceRecyclerView.setLayoutManager(layoutManager2);
            weightRecyclerView.setAdapter(new TextRecyclerViewAdapter(weightData));
            priceRecyclerView.setAdapter(new TextRecyclerViewAdapter(priceData));

//            addPrice(prices);
//            addWeight(weights);
            popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    lightOn();
                }
            });
            popupWindow.setBackgroundDrawable(drawable);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
//            animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
//                    Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0);
//            animation.setInterpolator(new AccelerateInterpolator());
//            animation.setDuration(200);
        }
        popupWindow.showAtLocation(mView.findViewById(R.id.rv_order_allItem), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
//        popupView.startAnimation(animation);
        lightOff();
    }


    class TextRecyclerViewAdapter extends RecyclerView.Adapter<TextRecyclerViewAdapter.ViewHolder> {
        private List<String> mData;

        public TextRecyclerViewAdapter(List<String> mData) {
            this.mData = mData;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.fragment_textview_order, viewGroup,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(mData.get(i));
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_order_text);
            }
        }

    }
}


