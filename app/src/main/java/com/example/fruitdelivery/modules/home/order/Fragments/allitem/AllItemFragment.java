package com.example.fruitdelivery.modules.home.order.Fragments.allitem;


import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class AllItemFragment extends BaseFragment<AllItemPresenter> implements
        AllItemRecyclerViewAdapter.OnClickListener, AllItemView {
    private Animation animation;
    private RecyclerView mRecyclerView;
    private PopupWindow popupWindow;
    private View popupView;
    private AllItemRecyclerViewAdapter mAdapter;

    private List<AllItemRecyclerViewAdapter.AllItemBean> mList = new ArrayList<>();
    private boolean flags = true;

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
        if (flags) {
            mPresenter.initData(mList);
            flags = false;
        }
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.order_cancel_anim);
        mRecyclerView = mView.findViewById(R.id.rv_order_allItem);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mView.getContext());
        mAdapter = new AllItemRecyclerViewAdapter(mList);
        mAdapter.setClickListener(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
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
    public void onClickCancel(final int position, final View v) {
        final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(getContext());
        alterDiaglog.setTitle("订单");//文字
        alterDiaglog.setMessage("你确认取消该订单吗?");//提示消息
        //积极的选择
        alterDiaglog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mList.remove(position);
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        //消极的选择
        alterDiaglog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {

            }
        }).show();


        //显示
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
            popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.setAnimationStyle(R.style.popWindow);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    lightOn();
                }
            });
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            Button btPay = popupView.findViewById(R.id.bt_order_pay_sure);
            btPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    toast("跳转支付页面");
                }
            });
        }
        popupWindow.showAtLocation(mView.findViewById(R.id.rv_order_allItem), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
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
                    .inflate(R.layout.fragment_textview_order, viewGroup, false);
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


