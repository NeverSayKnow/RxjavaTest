package com.yitianli.myapplication.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yitianli.myapplication.R;
import com.yitianli.myapplication.utils.DensityUtil;
import com.yitianli.myapplication.utils.ScreenUtil;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MovieBean.SubjectsBean> list;
    private Context context;

    public List<MovieBean.SubjectsBean> getList() {
        return list;
    }

    public void setList(List<MovieBean.SubjectsBean> list) {
        this.list = list;
    }

    public MovieAdapter(Context context, List<MovieBean.SubjectsBean> list){
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie,
                viewGroup,false);
        int height = ScreenUtil.getScreenHeight(viewGroup.getContext());
        int width = ScreenUtil.getScreenWidth(viewGroup.getContext());
        Log.e("TAG","=======" + height + "======" + width);
        Log.e("TAG","======="+ DensityUtil.dp2px(viewGroup.getContext(),10));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MovieBean.SubjectsBean bean = list.get(i);
        viewHolder.tv_movie_name_item.setText(bean.getTitle());
        Glide.with(context).load(bean.getImages().getSmall()).into(viewHolder.iv_movie_fm_item);
        viewHolder.tv_score_item.setText(String.valueOf(bean.getRating().getAverage()));
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_movie_fm_item;
        private TextView tv_movie_name_item;
        private TextView tv_score_item;
        private ImageView iv_star_1;
        private ImageView iv_star_2;
        private ImageView iv_star_3;
        private ImageView iv_star_4;
        private ImageView iv_star_5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_movie_fm_item = itemView.findViewById(R.id.iv_movie_fm_item);
            tv_movie_name_item = itemView.findViewById(R.id.tv_movie_name_item);
            tv_score_item = itemView.findViewById(R.id.tv_score_item);
            iv_star_1 = itemView.findViewById(R.id.iv_star_1);
            iv_star_2 = itemView.findViewById(R.id.iv_star_2);
            iv_star_3 = itemView.findViewById(R.id.iv_star_3);
            iv_star_4 = itemView.findViewById(R.id.iv_star_4);
            iv_star_5 = itemView.findViewById(R.id.iv_star_5);
//            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv_movie_fm_item.getLayoutParams();
        }
    }
}
