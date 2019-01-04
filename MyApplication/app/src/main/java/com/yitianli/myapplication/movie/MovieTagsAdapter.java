package com.yitianli.myapplication.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yitianli.myapplication.R;

import java.util.List;

public class MovieTagsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_TEXT = 0;
    private static final int TYPE_TAG = 1;
    private List<String> list;
    private Context context;

    public MovieTagsAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        //由于固定的第一个位置肯定是“所属频道”，所以只需要根据下标即可判断类型
        if (position == 0){
            return TYPE_TEXT;
        }else {
            return TYPE_TAG;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TYPE_TEXT){
            View view = LayoutInflater.from(context).inflate(R.layout.item_movie_tags_text,viewGroup,false);
            return new MovieTagsTextViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_movie_tags,viewGroup,false);
            return new MovieTagsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MovieTagsTextViewHolder){
            ((MovieTagsTextViewHolder) viewHolder).textView.setText(list.get(i));
        }else if (viewHolder instanceof MovieTagsViewHolder){
            ((MovieTagsViewHolder) viewHolder).textView.setText(list.get(i));
        }
    }


    @Override
    public int getItemCount() {
        return null == list ? 0 : list.size();
    }

    class MovieTagsViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public MovieTagsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_tag_item_movie_tags);
        }
    }

    class MovieTagsTextViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public MovieTagsTextViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_sspd_item_movie_tags_text);
        }
    }


}
