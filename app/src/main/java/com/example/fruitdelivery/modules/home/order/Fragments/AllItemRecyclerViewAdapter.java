package com.example.fruitdelivery.modules.home.order.Fragments;

import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fruitdelivery.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AllItemRecyclerViewAdapter extends RecyclerView.Adapter<AllItemRecyclerViewAdapter.MyViewHolder> {
    List<AllItemBean> mList ;
    public AllItemRecyclerViewAdapter(List<AllItemBean> listView) {
        super();
        mList = listView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        AllItemBean itemBean = mList.get(i);
        myViewHolder.tvPrice.setText(itemBean.Price);
        myViewHolder.tvTotalPrice.setText(itemBean.totalPrice);
        myViewHolder.tvSaleVolume.setText(itemBean.saleVolume);
        myViewHolder.tvFreight.setText(itemBean.freight);
        myViewHolder.tvClassFruit.setText(itemBean.classFruit);
        myViewHolder.tvStore.setText(itemBean.store);
        myViewHolder.tvUnit.setText(itemBean.unit);


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
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
    static class AllItemBean {
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

        String store;  //店铺名称
        String unit;//左边的单价
        String classFruit;//水果种类
        String freight;//运费
        String saleVolume;//销量
        String Price;//右边的单价
        String number;//数量
        String totalPrice;//下面的总价
    }
}
