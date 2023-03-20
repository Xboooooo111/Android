package com.example.myapplication0216;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * Description:
 */
public class MyAdapter extends RecyclerView.Adapter {
    private List<Fruit> mFruitList;

    public MyAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImg;
        TextView fruitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitImg = itemView.findViewById(R.id.fruit_img);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder reholder = (ViewHolder) holder;
        Fruit fruit = mFruitList.get(position);
        reholder.fruitImg.setImageResource(fruit.getImgId());
        reholder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
