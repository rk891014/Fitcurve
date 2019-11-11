package com.example.girls_fitness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.girls_fitness.Model.Model;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final String TAG = "recyclerAdapter";

    public List<Model> imageList;
    public Context context;

    public MyAdapter(List<Model> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
        Log.e("listsize",String.valueOf(imageList.size()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.crabwalk);
        requestOptions.error(R.drawable.calf);

        Model model = imageList.get(position);
        holder.textViewHead.setText(model.getTitle());
        holder.textViewDesc.setText(imageList.get(position).getDescription());
        Glide.with(context).load(imageList.get(position%imageList.size()).getUrl()).apply(requestOptions)
        .thumbnail(0.5f).skipMemoryCache(false).into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewHead;
         TextView textViewDesc;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textviewhead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textviewdesc);
            imageView = (ImageView)itemView.findViewById(R.id.rimageView);

        }
    }


}