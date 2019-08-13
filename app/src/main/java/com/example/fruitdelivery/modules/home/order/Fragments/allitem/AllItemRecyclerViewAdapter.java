package com.example.fruitdelivery.modules.home.order.Fragments.allitem;

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

import java.util.List;

public class AllItemRecyclerViewAdapter extends RecyclerView.Adapter<AllItemRecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "chen";

    public interface OnClickListener {
        void onClickStore(int position);
        void onClickThing(int position);
        void onClickPay(int position);
        void onClickCancel(int position,View view);
    }
    private OnClickListener clickListener;
    private Context mContext;
    private List<AllItemBean> mList ;
    AllItemRecyclerViewAdapter(List<AllItemBean> listView) {
        super();
        mList = listView;
    }

    void setClickListener(OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order_allitem,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, int i) {
        final int position = viewHolder.getAdapterPosition();
        AllItemBean itemBean = mList.get(i);
        viewHolder.tvPrice.setText(itemBean.Price);
        viewHolder.tvTotalPrice.setText(itemBean.totalPrice);
        viewHolder.tvSaleVolume.setText(itemBean.saleVolume);
        viewHolder.tvFreight.setText(itemBean.freight);
        viewHolder.tvClassFruit.setText(itemBean.classFruit);
        viewHolder.tvStore.setText(itemBean.store);
        viewHolder.tvUnit.setText(itemBean.unit);
        /*
        跳转商店详情页
         */
        viewHolder.lyClickStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "跳转商店详情页", Toast.LENGTH_SHORT).show();
                clickListener.onClickStore(position);
            }
        });
        /*
        跳转商品详情页
         */
        viewHolder.rlClickThing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "跳转商品详情页", Toast.LENGTH_SHORT).show();
                clickListener.onClickThing(position);
            }
        });
        /*
        弹出底部弹窗，支付
         */
        viewHolder.btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClickPay(position);
            }
        });
        /*
        删除订单
         */
        viewHolder.btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "删除订单", Toast.LENGTH_SHORT).show();
                clickListener.onClickCancel(position,viewHolder.itemView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
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

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
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
    public static class AllItemBean {
        public AllItemBean(String store, String unit, String classFruit,
                           String freight, String saleVolume,
                           String price, String number, String totalPrice) {
            this.store = store;
            this.unit = unit;
            this.classFruit = classFruit;
            this.freight = freight;
            this.saleVolume = saleVolume;
            Price = price;
            this.number = number;
            this.totalPrice = totalPrice;
        }

        public String store;  //店铺名称
        public String unit;//左边的单价
        public String classFruit;//水果种类
        public String freight;//运费
        public String saleVolume;//销量
        public String Price;//右边的单价
        public String number;//数量
        public String totalPrice;//下面的总价
    }
}
