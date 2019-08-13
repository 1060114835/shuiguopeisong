package com.example.fruitdelivery.modules.home.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fruitdelivery.R;

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

        if (i == TYPE_BANNER) {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_home,
                    viewGroup,false);
            return new BannerViewHolder(view);
        }else if (i == TYPE_FUNCTION) {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_home_function,
                    viewGroup,false);
            return new FunctionViewHolder(view);
        }else if (i == TYPE_SELLERS) {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_home_sellers,
                    viewGroup,false);
            return new SellersViewHolder(view);
        }else if (i == TYPE_FRUIT) {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_home_fruit,
                    viewGroup,false);
            return new FruitViewHolder(view);
        }else if (i == TYPE_FOOTER) {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_home_footer,
                    viewGroup,false);
            return new FooterViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof BannerViewHolder) {

        }else if (viewHolder instanceof FunctionViewHolder) {

        }else if (viewHolder instanceof SellersViewHolder) {

        }else if (viewHolder instanceof FruitViewHolder) {

            FruitViewHolder fruitViewHolder = (FruitViewHolder)viewHolder;
            Glide.with(context).load(urlList.get(i)).into(fruitViewHolder.imageView);

        }else if (viewHolder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder)viewHolder;

        }
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
        }else if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        }else {
            return TYPE_FRUIT;
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class FunctionViewHolder extends RecyclerView.ViewHolder {

        public FunctionViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class SellersViewHolder extends RecyclerView.ViewHolder {

        public SellersViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class FruitViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_home_fruit);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        ProgressBar progressBar;
        TextView textView;

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.pb_home_footer);
            textView = itemView.findViewById(R.id.tv_home_footer);
        }
    }

}
