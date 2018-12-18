package com.yitianli.myapplication.movie;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.yitianli.myapplication.R;
import com.yitianli.myapplication.base.BaseActivity;
import com.yitianli.myapplication.utils.DensityUtil;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class MovieDetailActivity extends BaseActivity implements MovieDetailContract.View {


    @BindView(R.id.iv_movie_fm)
    ImageView ivMovieFm;
    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;
    @BindView(R.id.tv_movie_name_another)
    TextView tvMovieNameAnother;
    @BindView(R.id.tv_movie_time)
    TextView tvMovieTime;
    @BindView(R.id.btn_want_to_watch)
    Button btnWantToWatch;
    @BindView(R.id.btn_had_watch)
    Button btnHadWatch;
    @BindView(R.id.tv_line5)
    TextView tvLine5;
    @BindView(R.id.tv_line4)
    TextView tvLine4;
    @BindView(R.id.tv_line3)
    TextView tvLine3;
    @BindView(R.id.tv_line2)
    TextView tvLine2;
    @BindView(R.id.tv_line1)
    TextView tvLine1;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.iv_star_1)
    ImageView ivStar1;
    @BindView(R.id.iv_star_2)
    ImageView ivStar2;
    @BindView(R.id.iv_star_3)
    ImageView ivStar3;
    @BindView(R.id.iv_star_4)
    ImageView ivStar4;
    @BindView(R.id.iv_star_5)
    ImageView ivStar5;
    @BindView(R.id.tv_how_many_people)
    TextView tvHowManyPeople;

    private MovieDetailPresenter presenter;

    @Override
    protected void initView() {
        MovieBean.SubjectsBean bean = getIntent().getParcelableExtra("movie");
        presenter = new MovieDetailPresenter();
        presenter.attachView(this);
        showData(bean);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected String getTittleName() {
        return "电影详情";
    }

    @OnClick({R.id.btn_want_to_watch, R.id.btn_had_watch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_want_to_watch:
                break;
            case R.id.btn_had_watch:
                break;
        }
    }

    @Override
    public void showData(MovieBean.SubjectsBean bean) {

        //设置圆角
        RoundedCorners roundedCorners = new RoundedCorners(DensityUtil.dp2px(this, 5));
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(this).load(bean.getImages().getSmall()).apply(options).into(ivMovieFm);
        tvMovieName.setText(bean.getTitle());
        tvMovieNameAnother.setText(bean.getOriginal_title());
        StringBuilder builder = new StringBuilder();
        for (String genres : bean.getGenres()) {
            builder.append(genres);
            builder.append(" ");
        }
        builder.append(" / 上映时间：");
        builder.append(bean.getPubdates().get(0));
        builder.append(" / 片长：");
        builder.append(bean.getDurations());
        builder.append(" ＞");
        tvMovieTime.setText(builder.toString());
        tvScore.setText(String.valueOf(bean.getRating().getAverage()));

        //多少人看过
        double d = bean.getCollect_count() / 1000.0;
        DecimalFormat df = new DecimalFormat("#.0");
        String s = "有"+ df.format(d) + "k人已看过";
        tvHowManyPeople.setText(s);
        //获取各个星数的人数
        presenter.getStarNum(bean.getRating().getDetails());
        //获取分数
        presenter.getStar(bean.getRating().getAverage());

    }

    @Override
    public void showStarNum(float[] ints) {
        Log.e("TAG", "showStarNum" + ints[0]);
        tvLine5.setWidth(DensityUtil.dp2px(this, ints[4] * 150));
        tvLine4.setWidth(DensityUtil.dp2px(this, ints[3] * 150));
        tvLine3.setWidth(DensityUtil.dp2px(this, ints[2] * 150));
        tvLine2.setWidth(DensityUtil.dp2px(this, ints[1] * 150));
        tvLine1.setWidth(DensityUtil.dp2px(this, ints[0] * 150));
    }

    @Override
    public void showStar(int[] ints) {
        ImageView[] imageViews = new ImageView[5];
        imageViews[0] = ivStar1;
        imageViews[1] = ivStar2;
        imageViews[2] = ivStar3;
        imageViews[3] = ivStar4;
        imageViews[4] = ivStar5;
        for (int i1 = 0; i1 < 5; i1++) {
            switch (ints[i1]){
                case 0:
                    Glide.with(this).load(R.drawable.star).into(imageViews[i1]);
                    break;
                case 1:
                    Glide.with(this).load(R.drawable.star2).into(imageViews[i1]);
                    break;
                case 2:
                    Glide.with(this).load(R.drawable.star3).into(imageViews[i1]);
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

}
