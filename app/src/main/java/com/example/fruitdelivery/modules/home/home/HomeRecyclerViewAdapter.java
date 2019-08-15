package com.example.fruitdelivery.modules.home.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fruitdelivery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Richard
 * @date: 2019/8/12
 * @describe: 首页RecyclerView的适配器
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ImageView>  imageViewList;
    private List<String> urlList;
    private Context context;

    private static final int TYPE_BANNER = 0;
    private static final int TYPE_FUNCTION = 1;
    private static final int TYPE_SELLERS = 2;
    private static final int TYPE_FRUIT = 3;
    private static final int TYPE_FOOTER = 4;

    public final int STATE_LOADING = 0;
    public final int STATE_FINISH  = 1;
    private int state = STATE_LOADING;
    private boolean isFirst = true;

    public HomeRecyclerViewAdapter(List<String> urlList, Context context) {
        this.urlList = urlList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i == TYPE_BANNER) {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_home_banner,
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

            final BannerViewHolder bannerViewHolder = (BannerViewHolder)viewHolder;
//            bannerViewHolder.viewPager.setId(i);
            imageViewList = HomeFragment.getBannerData(bannerViewHolder.viewPager.getContext());
            HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(imageViewList);
            bannerViewHolder.viewPager.setAdapter(adapter);
            int firstPosition = Integer.MAX_VALUE/2;
            bannerViewHolder.viewPager.setCurrentItem(firstPosition);

            //避免每次刷新都会执行此代码，导致UI上出现很多的指示器
            if (isFirst) {
                for (int j = 0; j < HomeFragment.getImages().length; j++) {
                    ImageView imageView = new ImageView(bannerViewHolder.linearLayout.getContext());
                    imageView.setImageResource(R.drawable.home_banner_indicrator);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(38,
                            8);
                    if (j > 0) {
                        params.leftMargin = 15;
                    }
                    bannerViewHolder.linearLayout.addView(imageView,params);
                }

                isFirst = false;
            }

            bannerViewHolder.viewPager.addOnPageChangeListener(
                    new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                int lastPosition;

                @Override
                public void onPageSelected(int i) {

                    bannerViewHolder.linearLayout.getChildAt(i % imageViewList.size()).
                            setSelected(true);
                    bannerViewHolder.linearLayout.getChildAt(lastPosition).setSelected(false);
                    lastPosition = i % imageViewList.size();
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                }

            });


        }else if (viewHolder instanceof FunctionViewHolder) {

            FunctionViewHolder functionViewHolder = (FunctionViewHolder)viewHolder;

        }else if (viewHolder instanceof SellersViewHolder) {

            SellersViewHolder sellersViewHolder = (SellersViewHolder)viewHolder;

        }else if (viewHolder instanceof FruitViewHolder) {

            FruitViewHolder fruitViewHolder = (FruitViewHolder)viewHolder;
//            Glide.with(context).load(urlList.get(i)).into(fruitViewHolder.imageView);

        }else if (viewHolder instanceof FooterViewHolder) {

            FooterViewHolder footerViewHolder = (FooterViewHolder)viewHolder;
            switch (state) {
                case STATE_LOADING:
                    footerViewHolder.progressBar.setVisibility(View.VISIBLE);
                    footerViewHolder.textView.setText("正在加载...");
                    break;
                case STATE_FINISH:
                    footerViewHolder.progressBar.setVisibility(View.GONE);
                    footerViewHolder.textView.setText("我也是有底线的哦~");
                default:
                    break;
            }

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

        ViewPager viewPager;
        LinearLayout linearLayout;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.home_view_pager);
            linearLayout = itemView.findViewById(R.id.home_ll_indicator);
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


    /**
     * 设置当前的加载状态，主要为了设置底部的Footer的样式
     */
    public void setLoadState(int state) {
        this.state = state;
    }

}
