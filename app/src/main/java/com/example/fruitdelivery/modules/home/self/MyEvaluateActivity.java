package com.example.fruitdelivery.modules.home.self;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseActivity;
import com.example.fruitdelivery.base.BasePresenter;
import com.example.fruitdelivery.modules.home.self.myUtil.CardBottomAdapter;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * The type My debug activity.
 */
public class MyEvaluateActivity extends BaseActivity {

    /**
     * 获取"口味"文字
     */
    TextView textKouwei;
    /**
     * 获取"包装"文字
     */
    TextView textBaozhuang;
    /**
     * 图片RecyclerView通用的Adapter
     */
    CardBottomAdapter cardBottomAdapter;
    /**
     * 图片RecyclerView通用的Adapter2
     */
    CardBottomAdapter cardBottomAdapter2;
    /**
     * "口味"的RecyclerView
     */
    RecyclerView recyclerView;
    /**
     * "包装的RecyclerView"
     */
    RecyclerView recyclerView2;
    /**
     * 不断复用的ImageView
     */
    private volatile ImageView imageView;

    private CardView cardCommit;

    /**
     * The Uri list.
     */
    List<Integer> uriList = new ArrayList<>();

    @Override
    protected int getContentLayoutId() {
        return R.layout.my_evaluate;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initUris();

        View view = findViewById(R.id.recycler_kouwei);
        TextView textView = view.findViewById(R.id.text_recycler);
        textView.setText("口味");
        textKouwei = view.findViewById(R.id.change_evaluate_common);
        recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        cardBottomAdapter = new CardBottomAdapter(R.id.my_star_image,this,uriList,R.layout.my_evaluate_star_item,getHandler(textKouwei,recyclerView));
        recyclerView.setAdapter(cardBottomAdapter);

        View view2 = findViewById(R.id.recycler_baozhuang);
        textBaozhuang = view2.findViewById(R.id.change_evaluate_common);
        recyclerView2 = view2.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);
        cardBottomAdapter2 = new CardBottomAdapter(R.id.my_star_image,this,uriList,R.layout.my_evaluate_star_item,getHandler(textBaozhuang,recyclerView2));
        recyclerView2.setAdapter(cardBottomAdapter2);

        //提交评价跳转至ShellActivity
        cardCommit = findViewById(R.id.commit_evaluate);
        cardCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyEvaluateActivity.this, ShellActivity.class));
            }
        });
    }

    /**
     * 初始化图片Uri
     */
    private void initUris(){
        //防止过度加载
        uriList.clear();
        for (int i = 0;i < 5;i++){
        uriList.add(R.drawable.my_star);
        }
    }

    /**
     * 得到Handler实例的方法
     *
     * @param tv the tv
     * @param rv the rv
     * @return the handler
     */
    private Handler getHandler(final TextView tv, final RecyclerView rv){
        return new Handler() {

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        changeImage(0,rv);
                        tv.setText("很差");
                        break;
                    case 1:
                        changeImage(1,rv);
                        tv.setText("一般");
                        break;
                    case 2:
                        changeImage(2,rv);
                        tv.setText("中等");
                        break;
                    case 3:
                        changeImage(3,rv);
                        tv.setText("满意");
                        break;
                    case 4:
                        changeImage(4,rv);
                        tv.setText("无可挑剔");
                        break;
                    default:
                        break;
                }
            }
        };
    }

    /**
     * 得到指定item的ImageView并设置要更改的图片
     *
     * @param imageView    the image view
     * @param recyclerView the recycler view
     * @param position     the position
     * @param imageUri     the image uri
     */
    private void getImage(ImageView imageView,RecyclerView recyclerView,int position,int imageUri){
        //得到不同位置item的方法非常重要，是我逻辑的核心
        imageView = recyclerView.getLayoutManager().findViewByPosition(position).findViewById(R.id.my_star_image);
        imageView.setImageResource(imageUri);
    }

    /**
     * 评价星点击的逻辑
     *
     * @param position     the position
     * @param recyclerView the recycler view
     */
    private void changeImage(int position,RecyclerView recyclerView){
        if (position >=0 && position <5){

            for (int i = position;i >= 0;i--){
                getImage(imageView,recyclerView,i,R.drawable.my_dizhi);
            }

            switch (position){
                case 0:
                    getImage(imageView,recyclerView,1,R.drawable.my_star);
                case 1:
                    getImage(imageView,recyclerView,2,R.drawable.my_star);
                case 2:
                    getImage(imageView,recyclerView,3,R.drawable.my_star);
                case 3:
                    getImage(imageView,recyclerView,4,R.drawable.my_star);
                    break;
                default:
                    break;
            }
        }
    }
}
