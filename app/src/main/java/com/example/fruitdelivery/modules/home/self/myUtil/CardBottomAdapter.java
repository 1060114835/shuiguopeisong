package com.example.fruitdelivery.modules.home.self.myUtil;

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
import com.example.fruitdelivery.modules.home.self.MyEvaluateActivity;

import java.util.List;

/**
 * The type Card bottom adapter.
 */
public class CardBottomAdapter extends RecyclerView.Adapter<CardBottomAdapter.ViewHolder> {
    private List<Integer> uris;
    private Context mContext;
    private Handler mHandler;
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

        //设置Item中ImageView的点击事件
        viewHolder.bottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                //根据传入的item定义不同的点击逻辑
                switch (mBoolXml){
                    case R.layout.my_card_item:
                        switch (position){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            mContext.startActivity(new Intent(mContext, MyEvaluateActivity.class));
                            break;
                        case 4:
                            break;
                        default:
                            break;
                        }
                        break;
                    case R.layout.my_evaluate_star_item:
                        startMessage(position);
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
     * 发送Message更改星评
     *
     * @param position the position
     */
    public void startMessage(final int position){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.what = position;
                mHandler.sendMessage(message);
            }
        }).start();
    }

    /**
     * Instantiates a new Card bottom adapter.
     *
     * @param imageItemXml the image item xml
     * @param context      the context
     * @param uriList      the uri list
     * @param boolItem     the bool item
     */
    public CardBottomAdapter(int imageItemXml,Context context,List<Integer> uriList,int boolItem){
        this.uris = uriList;
        this.mContext = context;
        this.mBoolXml = boolItem;
        this.mImageItemXml = imageItemXml;
    }

    /**
     * 带有Handler的构造函数
     *
     * @param imageItemXml the image item xml
     * @param context      the context
     * @param uriList      the uri list
     * @param boolItem     the bool item
     * @param handler      the handler
     */
    public CardBottomAdapter(int imageItemXml,Context context,List<Integer> uriList,int boolItem,Handler handler){
        this.uris = uriList;
        this.mContext = context;
        this.mBoolXml = boolItem;
        this.mHandler = handler;
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
}
