package com.example.fruitdelivery.modules.home.self.myUtil;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.self.MessageWrap;
import com.example.fruitdelivery.modules.home.self.MyEvaluateActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * The type Card bottom adapter.
 */
public class CardBottomAdapter extends RecyclerView.Adapter<CardBottomAdapter.ViewHolder> {
    private List<Integer> uris;
    private Context mContext;

    /**
     * 传入的标志位
     */
    private int DIF_FLAG;
    /**
     * 滑块ImageView
     */
    private ImageView mImageMove;

    /**
     * 设置点击item图标的标志位
     */
    private int FLAG;

    /**
     * 13dp换算的固定margin
     */
    final float INSTANCE = 45.5f;

    /**
     * 将上次滑动的终点设置为下一次滑动的起始位置
     */
    private volatile static float FLAG_FROM;

    /**
     * 单例的AnimatorSet
     */
    AnimatorSet commonSet;

    /**
     * 单例的ObjectAnimator
     */
    private volatile static ObjectAnimator animatorBlock,animatorItem;

    /**
     * 不同的item
     */
    int mBoolXml;

    /**
     * 不同item中的image
     */
    int mImageItemXml;

    @NonNull
    @Override
    public CardBottomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null){
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(mBoolXml,viewGroup,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        //设置Item中ImageView的点击事件,防连点
        viewHolder.bottomItem.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                int position = viewHolder.getAdapterPosition();
                //根据传入的item定义不同的点击逻辑
                switch (mBoolXml){
                    case R.layout.my_card_item:
                        //没搞懂getRight()方法，但这里返回的长度恰好为滑块长度，且因为指定了final，就不变
                        final float INSTANCE_LONG = mImageMove.getRight();

                        //item点击的效果
                        animatorItem = ObjectAnimator.ofFloat(viewHolder.bottomItem,"alpha",1f,0.5f,0.3f,0.5f,1f);
                        animatorItem.setDuration(500);
                        animatorItem.start();
                        switch (position){
                            case 0:
                                changePosition(INSTANCE_LONG,0);
                                break;
                            case 1:
                                changePosition(INSTANCE_LONG,1);
                                break;
                            case 2:
                                changePosition(INSTANCE_LONG,2);
                                break;
                            case 3:
                                changePosition(INSTANCE_LONG,3);
                                mContext.startActivity(new Intent(mContext,MyEvaluateActivity.class));
                                break;
                            case 4:
                                changePosition(INSTANCE_LONG,4);
                                break;
                            default:
                                break;
                        }
                        break;
                    case R.layout.my_evaluate_star_item:
                        startMessage(position,DIF_FLAG);
                        break;
                    default:
                        break;
                }
            }
        });
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CardBottomAdapter.ViewHolder viewHolder, int i) {
        int uri = uris.get(i);
        Glide.with(mContext).load(uri).into(viewHolder.bottomItem);
    }

    @Override
    public int getItemCount() {
        return uris.size();
    }

    /**
     * 用于卡片底栏
     *
     * @param imageItemXml the image item xml
     * @param context      the context
     * @param uriList      the uri list
     * @param boolItem     the bool item
     * @param imageView    the image view
     */
    public CardBottomAdapter(int imageItemXml,Context context,List<Integer> uriList,int boolItem,ImageView imageView){
        this.uris = uriList;
        this.mContext = context;
        this.mBoolXml = boolItem;
        this.mImageItemXml = imageItemXml;
        this.mImageMove = imageView;
    }

    /**
     * 带有flag的标志位,用于评价星
     *
     * @param imageItemXml the image item xml
     * @param context      the context
     * @param uriList      the uri list
     * @param boolItem     the bool item
     * @param flag         判断不同评价星级的标志位
     */
    public CardBottomAdapter(int imageItemXml,Context context,List<Integer> uriList,int boolItem,int flag){
        this.uris = uriList;
        this.mContext = context;
        this.mBoolXml = boolItem;
        this.DIF_FLAG = flag;
        this.mImageItemXml = imageItemXml;
    }

    /**
     * The type View holder.
     */
    protected class ViewHolder extends RecyclerView.ViewHolder{
        /**
         * ImageView
         */
        ImageView bottomItem;

        /**
         * Instantiates a new View holder.
         *
         * @param view the view
         */
        public ViewHolder(View view){
            super(view);
            bottomItem = view.findViewById(mImageItemXml);
        }
    }

    /**
     * 滑块改变动画的具体逻辑
     * @param instanceLong
     * @param times
     */
    private void changePosition(float instanceLong,int times){
        FLAG = times + 1;
        commonSet = MyInterpolater.getAnimatorSet();
        animatorBlock = ObjectAnimator.ofFloat(mImageMove,"x",FLAG_FROM, instanceLong*(FLAG - 1)+ INSTANCE*FLAG);
        animatorBlock.setDuration(200);
        animatorBlock.setInterpolator(MyInterpolater.getOvershootInterpolator());
        commonSet.play(animatorBlock);
        commonSet.start();
        FLAG_FROM = instanceLong*(FLAG - 1)+ INSTANCE*FLAG;
    }

    /**
     * 发送Message更改星评
     *
     * @param position the position
     */
    public void startMessage(final int position,int flag){
        //发送黏性事件
        EventBus.getDefault().postSticky(MessageWrap.getInstance(position,flag));
    }
}