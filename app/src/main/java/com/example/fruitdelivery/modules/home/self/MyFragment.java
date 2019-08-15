package com.example.fruitdelivery.modules.home.self;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;
import com.example.fruitdelivery.modules.account.login.LoginActivity;
import com.example.fruitdelivery.modules.home.self.myUtil.BoolDataBack;
import com.example.fruitdelivery.modules.home.self.myUtil.CardBottomAdapter;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * The type My fragment.
 */
public class MyFragment extends BaseFragment<MyPresenter> implements View.OnClickListener,ISelfView {


    /**
     * The Uri list.
     */
    List<Integer> uriList = new ArrayList<>();

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

        //卡片底部的RecyclerView
        initUris();
        RecyclerView recyclerView = super.mView.findViewById(R.id.my_bottom_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        CardBottomAdapter cardBottomAdapter = new CardBottomAdapter(getContext(),uriList,R.layout.my_card_item);
        recyclerView.setAdapter(cardBottomAdapter);

        //假如没有获取到订单数据
        boolData = 0;
        new BoolDataBack(0,noOrder).showStub();

    }

    /**
     * 初始化图片Uri
     */
    public void initUris(){

        //防止过度加载
        uriList.clear();
        uriList.add(R.drawable.my_fukuan);
        uriList.add(R.drawable.my_fahuo);
        uriList.add(R.drawable.my_shouhuo);
        uriList.add(R.drawable.my_pingjia);
        uriList.add(R.drawable.my_tuikuan);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myHead.setOnClickListener(this);
        myOrder.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_order:
                Toast.makeText(getContext(),"跳转至订单页",Toast.LENGTH_SHORT).show();

                //活动与碎片的通信
                //跳转至订单页:0
                ShellActivity shellActivity = (ShellActivity)getActivity();
                shellActivity.getViewPager().setCurrentItem(0);
                shellActivity.getTabLayout().getTabAt(0).select();
                break;
            case R.id.my_head:
                startActivity(new Intent(getContext(), LoginActivity.class));
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
