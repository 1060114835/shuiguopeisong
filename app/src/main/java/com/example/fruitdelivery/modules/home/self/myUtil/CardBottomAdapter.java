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

    @NonNull
    @Override
    public CardBottomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_card_item,viewGroup,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.bottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                int uri = uris.get(position);
                Toast.makeText(v.getContext(),"wadsd" + position,Toast.LENGTH_SHORT).show();
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


    public CardBottomAdapter(Context context,List<Integer> uriList){
        this.uris = uriList;
        this.mContext = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bottomItem;
        public ViewHolder(View view){
            super(view);
            bottomItem = view.findViewById(R.id.bottom_image);
        }
    }
}
