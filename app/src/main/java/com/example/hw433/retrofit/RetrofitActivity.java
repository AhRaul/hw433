package com.example.hw433.retrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hw433.R;

public class RetrofitActivity extends MvpAppCompatActivity implements RetrofitView {

    private static final String TAG = "RetrofitDifActivity";

    private String avatarAdres;

//    private RetrofitPresenter retrofitPresenter;

    @BindView(R.id.imageViewPhoto)
    ImageView imageView;

    @InjectPresenter
    RetrofitPresenter retrofitPresenter;

    @ProvidePresenter
    public RetrofitPresenter providePresenter() {
        return new RetrofitPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

//        retrofitPresenter = new RetrofitPresenter();
    }

    @OnClick(R.id.buttonShowPhoto)
    public void onClickButton(View view) {
        Log.d(TAG, "onClickButton: ");
        retrofitPresenter.getString();
    }

    @Override
    public void updateView(String avatarAdress) {
        Log.d(TAG, "updateView: ");
        Glide
                .with(this)
                .load(avatarAdress)
                .into(imageView);
    }

}
