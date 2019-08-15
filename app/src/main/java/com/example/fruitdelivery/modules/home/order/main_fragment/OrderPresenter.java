package com.example.fruitdelivery.modules.home.order.main_fragment;

import com.example.fruitdelivery.base.BasePresenter;
import com.example.fruitdelivery.modules.home.order.fragments.AllItemBean;
import com.example.fruitdelivery.modules.home.order.fragments.TypeConstant;
import com.example.fruitdelivery.modules.home.order.main_fragment.OrderFragment;
import com.example.fruitdelivery.modules.home.order.main_fragment.OrderModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderPresenter extends BasePresenter<OrderFragment, OrderModel> {
    @Override
    protected OrderModel createModel() {
        return new OrderModel();
    }

    void initData(List<AllItemBean> list) {
        AllItemBean allItemBean = new AllItemBean("喜悦水果店", "七元一斤", "苹果"
                , "起送￥51|配送￥18", "233", "￥19", "x12", "合计：￥250", TypeConstant.NO_PAY);
        AllItemBean allItemBean1 = new AllItemBean("历时达水果店", "七元二斤", "栗子"
                , "起送￥52|配送￥8", "553", "￥23", "x13", "合计：￥123",TypeConstant.ACCOMPLISH);
        AllItemBean allItemBean2 = new AllItemBean("再擦水果店", "三元一斤", "香蕉"
                , "起送￥51|配送￥82", "166", "￥13", "x1", "合计：￥423",TypeConstant.NO_SIGN);
        AllItemBean allItemBean3 = new AllItemBean("无数次水果店", "五元一斤", "猕猴桃"
                , "起送￥10|配送￥12", "2339", "￥42", "x2", "合计：￥131",TypeConstant.ACCOMPLISH);
        AllItemBean allItemBean4 = new AllItemBean("偶是水果店", "十元一斤", "桃"
                , "起送￥12|配送￥10", "2883", "￥8", "x3", "合计：￥944",TypeConstant.NO_PAY);
        AllItemBean allItemBean5 = new AllItemBean("希望水果店", "四二元一斤", "苹"
                , "起送￥12|配送￥8", "2313", "￥9", "x7", "合计：￥524",TypeConstant.NO_EVALUATE);

        for (int i = 0; i < 2; i++) {
            list.add(allItemBean);
            list.add(allItemBean1);
            list.add(allItemBean2);
            list.add(allItemBean3);
            list.add(allItemBean4);
            list.add(allItemBean5);
        }
    }

    List<AllItemBean> filtrateToNoPay(List<AllItemBean> mData) {
        List<AllItemBean> temporary = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).typeConstant == TypeConstant.NO_PAY)
                temporary.add(mData.get(i));
        }
        return temporary;
    }
    List<AllItemBean> filtrateToNoSign(List<AllItemBean> mData) {
        List<AllItemBean> temporary = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).typeConstant == TypeConstant.NO_SIGN)
                temporary.add(mData.get(i));
        }
        return temporary;
    }
    List<AllItemBean> filtrateToNoEvaluate(List<AllItemBean> mData) {
        List<AllItemBean> temporary = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).typeConstant == TypeConstant.NO_EVALUATE)
                temporary.add(mData.get(i));
        }
        return temporary;
    }
    List<AllItemBean> filtrateAccomplish(List<AllItemBean> mData) {
        List<AllItemBean> temporary = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).typeConstant == TypeConstant.ACCOMPLISH)
                temporary.add(mData.get(i));
        }
        return temporary;
    }
}
