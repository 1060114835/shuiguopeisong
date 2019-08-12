package com.example.fruitdelivery.modules.home.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author: Richard
 * @date: 2019/8/12
 * @describe: 首页RecyclerView的适配器
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> urlList;
    private Context context;

    private static final int TYPE_BANNER = 0;
    private static final int TYPE_FUNCTION = 1;
    private static final int TYPE_SELLERS = 2;
    private static final int TYPE_FRUIT = 3;
    private static final int TYPE_FOOTER = 4;

    public HomeRecyclerViewAdapter(List<String> urlList, Context context) {
        this.urlList = urlList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return urlList.size() + 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        }else if (position == 1) {
            return TYPE_FUNCTION;
        }else if (position == 2) {
            return TYPE_SELLERS;
        }else if (position + 1 == getItemCount() ) {
            return TYPE_FOOTER;
        }else {
            return TYPE_FRUIT;
        }
    }

    class FunctionViewHolder {

    }

    class SellersViewHolder {

    }

    class FruitViewHolder {

    }

    class FooterViewHolder {

    }

}
