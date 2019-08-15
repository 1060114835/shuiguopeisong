package com.example.fruitdelivery.modules.home.order.fragments.total;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.order.fragments.AllItemBean;
import com.example.fruitdelivery.modules.home.order.fragments.no_pay.NoPayView;

import java.util.List;

public class TotalRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<AllItemBean> mData;
    private OnClickListener onClickListener;

    public interface OnClickListener {
        void onClickStore(int position);

        void onClickThing(int position);

        void onClickEvaluate(int position);

        void onClickPay(int position);

        void onClickSign(int position);

        void onClickDelete(int position, View view);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    TotalRecyclerViewAdapter(List<AllItemBean> mData) {
        this.mData = mData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view;
        switch (mData.get(i).typeConstant) {
            case NO_PAY:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_order_allitem, viewGroup, false);
                Log.d("chen", "onCreateViewHolder: " + mData.get(i).typeConstant + "  " + i);
                return new NoPayViewHolder(view);
            case NO_SIGN:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_order_no_sign, viewGroup, false);
                Log.d("chen", "onCreateViewHolder: " + mData.get(i).typeConstant + "  " + i);
                return new NoSignViewHolder(view);
            case ACCOMPLISH:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_order_accomplish, viewGroup, false);
                Log.d("chen", "onCreateViewHolder: " + mData.get(i).typeConstant + "  " + i);
                return new AccomplishViewHolder(view);
            case NO_EVALUATE:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_order_no_evaluate, viewGroup, false);
                Log.d("chen", "onCreateViewHolder: " + mData.get(i).typeConstant + "  " + i);
                return new NoEvaluateViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final int position = viewHolder.getAdapterPosition();
        AllItemBean itemBean = mData.get(i);

        switch (mData.get(i).typeConstant) {
            /*
            未评价页面
             */
            case NO_EVALUATE:
                Log.d("chen3", viewHolder.toString());
                NoEvaluateViewHolder noEvaluateViewHolder = (NoEvaluateViewHolder) viewHolder;
                noEvaluateViewHolder.tvPrice.setText(itemBean.Price);
                noEvaluateViewHolder.tvTotalPrice.setText(itemBean.totalPrice);
                noEvaluateViewHolder.tvSaleVolume.setText(itemBean.saleVolume);
                noEvaluateViewHolder.tvFreight.setText(itemBean.freight);
                noEvaluateViewHolder.tvClassFruit.setText(itemBean.classFruit);
                noEvaluateViewHolder.tvStore.setText(itemBean.store);
                noEvaluateViewHolder.tvUnit.setText(itemBean.unit);
                 /*
                跳转商店详情页
                 */
                noEvaluateViewHolder.lyClickStore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickEvaluate(position);
                    }
                });
                /*
                跳转商品详情页
                 */
                noEvaluateViewHolder.rlClickThing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickStore(position);
                    }
                });
                /*
                跳转评价页
                 */
                noEvaluateViewHolder.btEvaluate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickEvaluate(position);
                    }
                });
                break;
            /*
             已完成页面
             */
            case ACCOMPLISH:
                Log.d("chen1", "onBindViewHolder: " + viewHolder);
                AccomplishViewHolder accomplishViewHolder = (AccomplishViewHolder) viewHolder;
                Log.d("chen2", "onBindViewHolder: " + i + mData.get(i).typeConstant + "  " + viewHolder);
                accomplishViewHolder.tvPrice.setText(itemBean.Price);
                accomplishViewHolder.tvTotalPrice.setText(itemBean.totalPrice);
                accomplishViewHolder.tvSaleVolume.setText(itemBean.saleVolume);
                accomplishViewHolder.tvFreight.setText(itemBean.freight);
                accomplishViewHolder.tvClassFruit.setText(itemBean.classFruit);
                accomplishViewHolder.tvStore.setText(itemBean.store);
                accomplishViewHolder.tvUnit.setText(itemBean.unit);
                /*
                删除订单
                 */
                accomplishViewHolder.btDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickDelete(position, viewHolder.itemView);
                    }
                });
                 /*
                跳转商店详情页
                 */
                accomplishViewHolder.lyClickStore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickStore(position);
                    }
                });
                /*
                跳转商品详情页
                 */
                accomplishViewHolder.rlClickThing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickThing(position);
                    }
                });
                break;
             /*
             未签收页面
              */
            case NO_SIGN:
                NoSignViewHolder noSignViewHolder = (NoSignViewHolder) viewHolder;
                noSignViewHolder.tvPrice.setText(itemBean.Price);
                noSignViewHolder.tvTotalPrice.setText(itemBean.totalPrice);
                noSignViewHolder.tvSaleVolume.setText(itemBean.saleVolume);
                noSignViewHolder.tvFreight.setText(itemBean.freight);
                noSignViewHolder.tvClassFruit.setText(itemBean.classFruit);
                noSignViewHolder.tvStore.setText(itemBean.store);
                noSignViewHolder.tvUnit.setText(itemBean.unit);
                noSignViewHolder.btSign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickSign(position);
                    }
                });
                break;
             /*
             未支付页面
              */
            case NO_PAY:
                NoPayViewHolder noPayViewHolder = (NoPayViewHolder) viewHolder;
                noPayViewHolder.tvPrice.setText(itemBean.Price);
                noPayViewHolder.tvTotalPrice.setText(itemBean.totalPrice);
                noPayViewHolder.tvSaleVolume.setText(itemBean.saleVolume);
                noPayViewHolder.tvFreight.setText(itemBean.freight);
                noPayViewHolder.tvClassFruit.setText(itemBean.classFruit);
                noPayViewHolder.tvStore.setText(itemBean.store);
                noPayViewHolder.tvUnit.setText(itemBean.unit);
                /*
                跳转商店详情页
                 */
                noPayViewHolder.lyClickStore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickStore(position);
                    }
                });
                /*
                跳转商品详情页
                 */
                noPayViewHolder.rlClickThing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "跳转商品详情页", Toast.LENGTH_SHORT).show();
                        onClickListener.onClickThing(position);
                    }
                });
                /*
                弹出底部弹窗，支付
                 */
                noPayViewHolder.btPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickPay(position);
                    }
                });
                /*
                删除订单
                 */
                noPayViewHolder.btCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClickDelete(position, viewHolder.itemView);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    /*
        未支付页面子项
         */
    class NoPayViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        LinearLayout lyClickStore;
        RelativeLayout rlClickThing;
        Button btCancel;
        Button btPay;
        TextView tvStore;
        TextView tvUnit;
        TextView tvClassFruit;
        TextView tvFreight;
        TextView tvSaleVolume;
        TextView tvPrice;
        TextView tvTotalPrice;

        NoPayViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            setIsRecyclable(false);
            lyClickStore = itemView.findViewById(R.id.ly_order_pay);
            rlClickThing = itemView.findViewById(R.id.rl_click_thing);
            btPay = itemView.findViewById(R.id.bt_order_item_pay);
            btCancel = itemView.findViewById(R.id.bt_order_item_cancel);
            tvStore = itemView.findViewById(R.id.tv_order_item_store);
            tvUnit = itemView.findViewById(R.id.tv_order_unit);
            tvClassFruit = itemView.findViewById(R.id.tv_order_item_classFruit);
            tvFreight = itemView.findViewById(R.id.tv_order_item_freight);
            tvSaleVolume = itemView.findViewById(R.id.tv_order_item_sellNumber);
            tvPrice = itemView.findViewById(R.id.tv_order_item_price);
            tvTotalPrice = itemView.findViewById(R.id.tv_order_item_allPrice);

        }
    }

    /*
    未签收页面子项
     */
    class NoSignViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        Button btSign;
        LinearLayout lyClickStore;
        RelativeLayout rlClickThing;
        TextView tvStore;
        TextView tvUnit;
        TextView tvClassFruit;
        TextView tvFreight;
        TextView tvSaleVolume;
        TextView tvPrice;
        TextView tvTotalPrice;

        NoSignViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            setIsRecyclable(false);
            btSign = itemView.findViewById(R.id.bt_order_item_no_sign_pay);
            lyClickStore = itemView.findViewById(R.id.ly_order_no_sign_pay);
            rlClickThing = itemView.findViewById(R.id.rl_click_no_sign_thing);
            tvStore = itemView.findViewById(R.id.tv_order_item_no_sign_store);
            tvUnit = itemView.findViewById(R.id.tv_order_no_sign_unit);
            tvClassFruit = itemView.findViewById(R.id.tv_order_item_no_sign_classFruit);
            tvFreight = itemView.findViewById(R.id.tv_order_item_no_sign_freight);
            tvSaleVolume = itemView.findViewById(R.id.tv_order_item_no_sign_sellNumber);
            tvPrice = itemView.findViewById(R.id.tv_order_item_no_sign_price);
            tvTotalPrice = itemView.findViewById(R.id.tv_order_item_no_sign_allPrice);
        }
    }

    /*
    未评价页面子项
     */
    class NoEvaluateViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        Button btEvaluate;
        LinearLayout lyClickStore;
        RelativeLayout rlClickThing;
        TextView tvStore;
        TextView tvUnit;
        TextView tvClassFruit;
        TextView tvFreight;
        TextView tvSaleVolume;
        TextView tvPrice;
        TextView tvTotalPrice;

        NoEvaluateViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            setIsRecyclable(false);
            btEvaluate = itemView.findViewById(R.id.bt_order_item_evaluate);
            lyClickStore = itemView.findViewById(R.id.ly_order_evaluate_pay);
            rlClickThing = itemView.findViewById(R.id.rl_click_evaluate_thing);
            tvStore = itemView.findViewById(R.id.tv_order_item_evaluate_store);
            tvUnit = itemView.findViewById(R.id.tv_order_evaluate_unit);
            tvClassFruit = itemView.findViewById(R.id.tv_order_item_evaluate_classFruit);
            tvFreight = itemView.findViewById(R.id.tv_order_item_evaluate_freight);
            tvSaleVolume = itemView.findViewById(R.id.tv_order_item_evaluate_sellNumber);
            tvPrice = itemView.findViewById(R.id.tv_order_item_evaluate_price);
            tvTotalPrice = itemView.findViewById(R.id.tv_order_item_evaluate_allPrice);
        }
    }

    /*
    已完成页面子项
     */
    class AccomplishViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        Button btDelete;
        LinearLayout lyClickStore;
        RelativeLayout rlClickThing;
        TextView tvStore;
        TextView tvUnit;
        TextView tvClassFruit;
        TextView tvFreight;
        TextView tvSaleVolume;
        TextView tvPrice;
        TextView tvTotalPrice;

        AccomplishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            setIsRecyclable(false);
            btDelete = itemView.findViewById(R.id.bt_order_item_accomplish_pay);
            lyClickStore = itemView.findViewById(R.id.ly_order_accomplish_pay);
            rlClickThing = itemView.findViewById(R.id.rl_click_accomplish_thing);
            tvStore = itemView.findViewById(R.id.tv_order_item_accomplish_store);
            tvUnit = itemView.findViewById(R.id.tv_order_accomplish_unit);
            tvClassFruit = itemView.findViewById(R.id.tv_order_item_accomplish_classFruit);
            tvFreight = itemView.findViewById(R.id.tv_order_item_accomplish_freight);
            tvSaleVolume = itemView.findViewById(R.id.tv_order_item_accomplish_sellNumber);
            tvPrice = itemView.findViewById(R.id.tv_order_item_accomplish_price);
            tvTotalPrice = itemView.findViewById(R.id.tv_order_item_accomplish_allPrice);
        }
    }

}
