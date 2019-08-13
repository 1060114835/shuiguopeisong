package com.example.fruitdelivery.modules.home.order.Fragments.accomplish;

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
import com.example.fruitdelivery.modules.home.order.Fragments.allitem.AllItemRecyclerViewAdapter;

import java.util.List;
import java.util.zip.Inflater;

public class AccomplishRecyclerViewAdapter extends RecyclerView.Adapter<AccomplishRecyclerViewAdapter.ViewHolder> {
    private List<AllItemRecyclerViewAdapter.AllItemBean> mList;
    private Context mContext;

    public AccomplishRecyclerViewAdapter(List<AllItemRecyclerViewAdapter.AllItemBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order_accomplish,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final int position = viewHolder.getAdapterPosition();
        AllItemRecyclerViewAdapter.AllItemBean itemBean = mList.get(i);
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
            }
        });
        /*
        跳转商品详情页
         */
        viewHolder.rlClickThing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "跳转商品详情页", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        LinearLayout lyClickStore;
        RelativeLayout rlClickThing;
        TextView tvStore;
        TextView tvUnit;
        TextView tvClassFruit;
        TextView tvFreight;
        TextView tvSaleVolume;
        TextView tvPrice;
        TextView tvTotalPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
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
