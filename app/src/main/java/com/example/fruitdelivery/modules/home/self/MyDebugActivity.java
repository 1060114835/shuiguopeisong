package com.example.fruitdelivery.modules.home.self;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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
        View view = findViewById(R.id.recycler_kouwei);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        CardBottomAdapter cardBottomAdapter = new CardBottomAdapter(this,uriList,R.layout.my_evaluate_star_item);
        recyclerView.setAdapter(cardBottomAdapter);
        TextView textView = view.findViewById(R.id.text_recycler);
        textView.setText("口味");

        View view2 = findViewById(R.id.recycler_baozhuang);
        RecyclerView recyclerView2 = view2.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(cardBottomAdapter);
    }

    /**
     * 初始化图片Uri
     */
    public void initUris(){

        //防止过度加载
        uriList.clear();
        uriList.add(R.drawable.my_star);
        uriList.add(R.drawable.my_star);
        uriList.add(R.drawable.my_star);
        uriList.add(R.drawable.my_star);
        uriList.add(R.drawable.my_star);
    }
}
