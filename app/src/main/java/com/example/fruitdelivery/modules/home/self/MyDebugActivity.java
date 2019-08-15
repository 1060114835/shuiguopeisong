package com.example.fruitdelivery.modules.home.self;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.self.myUtil.CardBottomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyDebugActivity extends AppCompatActivity {

    TextView textKouwei;
    TextView textBaozhuang;
    CardBottomAdapter cardBottomAdapter;
    CardBottomAdapter cardBottomAdapter2;

    List<Integer> uriList = new ArrayList<>();

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    textKouwei.setText("很差");
                    break;
                case 1:
                    textKouwei.setText("一般");
                    break;
                case 2:
                    textKouwei.setText("中等");
                    break;
                case 3:
                    textKouwei.setText("满意");
                    break;
                case 4:
                    textKouwei.setText("无可挑剔");
                    break;
                default:
                    break;
            }
        }
    };
    private Handler handler2 = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        textBaozhuang.setText("很差");

                        break;
                    case 1:
                        textBaozhuang.setText("一般");
                        break;
                    case 2:
                        textBaozhuang.setText("中等");
                        break;
                    case 3:
                        textBaozhuang.setText("满意");
                        break;
                    case 4:
                        textBaozhuang.setText("无可挑剔");
                        break;
                    default:
                        break;
                }
            }
        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_evaluate);

        initUris();

        View view = findViewById(R.id.recycler_kouwei);
        TextView textView = view.findViewById(R.id.text_recycler);
        textView.setText("口味");
        textKouwei = view.findViewById(R.id.change_evaluate_common);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);


        View view2 = findViewById(R.id.recycler_baozhuang);
        textBaozhuang = view2.findViewById(R.id.change_evaluate_common);
        final RecyclerView recyclerView2 = view2.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);




        if (cardBottomAdapter == null || cardBottomAdapter2 == null){
            cardBottomAdapter = new CardBottomAdapter(this,uriList,R.layout.my_evaluate_star_item,handler);
            cardBottomAdapter2 = new CardBottomAdapter(this,uriList,R.layout.my_evaluate_star_item,handler2);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recyclerView.setAdapter(cardBottomAdapter);
                    recyclerView2.setAdapter(cardBottomAdapter2);
                }
            });
        }else {
            cardBottomAdapter.notifyDataSetChanged();
            cardBottomAdapter2.notifyDataSetChanged();
        }

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
