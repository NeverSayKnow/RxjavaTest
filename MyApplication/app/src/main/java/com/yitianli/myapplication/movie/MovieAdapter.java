package com.yitianli.myapplication.movie;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MovieBean.SubjectsBean bean = list.get(i);
        viewHolder.tv_movie_name_item.setText(bean.getTitle());
        Glide.with(context).load(bean.getImages().getSmall()).into(viewHolder.iv_movie_fm_item);
        viewHolder.tv_score_item.setText(String.valueOf(bean.getRating().getAverage()));
        ImageView[] imageViews = new ImageView[5];
        imageViews[0] = viewHolder.iv_star_1;
        imageViews[1] = viewHolder.iv_star_2;
        imageViews[2] = viewHolder.iv_star_3;
        imageViews[3] = viewHolder.iv_star_4;
        imageViews[4] = viewHolder.iv_star_5;
//        int[] show = MovieModel.getStarCount(bean.getRating().getStars());
        int[] show = MovieModel.getStarCount_score(bean.getRating().getAverage());

        for (int i1 = 0; i1 < 5; i1++) {
            Log.e("TAG","======="+show[i1]);
            switch (show[i1]){
                case 0:
                    Glide.with(context).load(R.drawable.star).into(imageViews[i1]);
                    break;
                case 1:
                    Glide.with(context).load(R.drawable.star2).into(imageViews[i1]);
                    break;
                case 2:
                    Glide.with(context).load(R.drawable.star3).into(imageViews[i1]);
                    break;
            }
        }

        viewHolder.iv_movie_fm_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieDetailActivity.class);
                context.startActivity(intent);
            }
        });

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

            int width = ScreenUtil.getScreenWidth(itemView.getContext());
            int imageWidth = (width - DensityUtil.dp2px(itemView.getContext(),15))/3;
            int imageHeight = (imageWidth * 40) / 27;
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv_movie_fm_item.getLayoutParams();
            params.width = imageWidth;
            params.height = imageHeight;
        }
    }
}
