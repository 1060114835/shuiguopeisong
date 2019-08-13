package com.example.fruitdelivery.modules.home.self.myUtil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fruitdelivery.R;

import java.util.List;

public class CardBottomAdapter extends RecyclerView.Adapter<CardBottomAdapter.ViewHolder> {
    private List<Integer> uris;
    private Context mContext;
    int mBoolXml;

    @NonNull
    @Override
    public CardBottomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(mBoolXml,viewGroup,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.bottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                int uri = uris.get(position);

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


    public CardBottomAdapter(Context context,List<Integer> uriList,int boolitem){
        this.uris = uriList;
        this.mContext = context;
        this.mBoolXml = boolitem;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bottomItem;
        public ViewHolder(View view){
            super(view);
            bottomItem = view.findViewById(R.id.common_image);
        }
    }
}
