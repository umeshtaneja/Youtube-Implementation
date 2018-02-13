package com.example.sagoo.yogatutorial;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sagoo on 1/24/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] urls = {"KDH9yvnYT0o","ooLDtZok0Mc","X2koA7Kz61s","I-bG5E00PPY","suJqs4JZu1c"};
    private Context mContext;
    private int[] images;


    private Context getContext() {
        return mContext;
    }

    public MyAdapter(Context context, int[] images) {
        this.images = images;
        this.mContext = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            String url = urls[position];
            Log.d("url",url);
            launchVideoActivity(url);
            }
        }

    private void launchVideoActivity(String url) {
        Intent intent = new Intent(getContext(),PlayVideoActivity.class);
        intent.putExtra("URL",url);
        getContext().startActivity(intent);
    }
}



