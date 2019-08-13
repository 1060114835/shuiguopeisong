package com.example.fruitdelivery.modules.home.home;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

/**
 * @author: Richard
 * @date: 2019/8/12
 * @describe: 首页ViewPager轮播的适配器
 */
public class HomeViewPagerAdapter extends PagerAdapter {


    private List<ImageView> imageViewList;

    public HomeViewPagerAdapter(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        position %= imageViewList.size();
        if (position < 0) {
            position += imageViewList.size();
        }
        ImageView imageView = imageViewList.get(position);
        ViewParent parent = imageView.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup)parent;
            viewGroup.removeView(imageView);
        }
        container.addView(imageView);
        return imageView;
    }

}
