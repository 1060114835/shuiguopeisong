package com.example.fruitdelivery.modules.home.self;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyFragment extends BaseFragment<MyPresenter> implements View.OnClickListener {


    //boolData为判断参数返回的标志；
    private static int boolData;

    /**
     * 我的头像
     */
    CircleImageView myHead;
    /**
     * 跳转至订单页
     */
    TextView myOrder;
    /**
     * 判断是否返回到了数据
     */
    ViewStub noOrder;


    @Override
    protected int getContentLayoutId() {
        return R.layout.my_fragment;
    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        if (mView == null)return;
        myHead = super.mView.findViewById(R.id.my_head);
        myOrder = super.mView.findViewById(R.id.my_order);
        noOrder = super.mView.findViewById(R.id.no_order_bool);



        //假如没有获取到数据
        boolData = 0;
        new BoolDataBack(0,noOrder).showStub();

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_order:
                Toast.makeText(getContext(),"跳转至订单页",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

}
