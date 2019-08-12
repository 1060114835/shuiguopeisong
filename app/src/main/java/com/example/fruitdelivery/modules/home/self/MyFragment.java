package com.example.fruitdelivery.modules.home.self;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * The type My fragment.
 */
public class MyFragment extends BaseFragment<MyPresenter> implements View.OnClickListener,ISelfView {


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



        //假如没有获取到订单数据
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

                //跳转至订单页
                Toast.makeText(getContext(),"跳转至订单页",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }


//    设置数据
    @Override
    public void setMyData(JsonRootBean jsonRootBean) {
        //具体关于设置头像、电话、昵称的逻辑
    }
}
