package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdaptor extends RecyclerView.Adapter<CustomvVewHolder> {

    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListener listener;

    public CustomAdaptor(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener=listener;

    }

    @NonNull
    @Override
    public CustomvVewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomvVewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomvVewHolder holder, int position) {
    holder.text_title.setText(headlines.get(position).getTitle());
    holder.text_source.setText(headlines.get(position).getSource().getName());
     if(headlines.get(position).getUrlToImage()!=null)
     {
         Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
     }
     holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             listener.OnNewsClicked(headlines.get(position));
         }
     });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
