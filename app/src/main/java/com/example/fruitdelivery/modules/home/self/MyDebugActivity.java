package com.example.fruitdelivery.modules.home.self;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.self.myUtil.CardBottomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyDebugActivity extends AppCompatActivity {

    List<Integer> uriList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_evaluate);

        initUris();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_kouwei);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        CardBottomAdapter cardBottomAdapter = new CardBottomAdapter(this,uriList);
        recyclerView.setAdapter(cardBottomAdapter);
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
}
