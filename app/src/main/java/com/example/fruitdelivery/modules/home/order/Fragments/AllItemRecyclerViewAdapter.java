package com.example.fruitdelivery.modules.home.order.Fragments;

import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvStore;
        TextView tvUnit;
        TextView tvClassFruit;
        TextView tvFreight;
        TextView tvStartFreight;
        TextView tvSaleVolume;
        TextView tvPrice;
        TextView tvTotalPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class AllItemBean {
        public AllItemBean(String store, String unit, String classFruit,
                           String freight, String startFreight, String saleVolume,
                           String price, String number, String totalPrice) {
            this.store = store;
            this.unit = unit;
            this.classFruit = classFruit;
            this.freight = freight;
            this.startFreight = startFreight;
            this.saleVolume = saleVolume;
            Price = price;
            this.number = number;
            this.totalPrice = totalPrice;
        }

        String store;  //店铺名称
        String unit;//左边的单价
        String classFruit;//水果种类
        String freight;//运费
        String startFreight;//起送费
        String saleVolume;//销量
        String Price;//右边的单价
        String number;//数量
        String totalPrice;//下面的总价
    }
}
