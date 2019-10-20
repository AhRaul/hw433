package com.example.hw433.retrofit;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    private static final String TAG = "RetrofitPresenter";

    private RetrofitApi retrofitApi;
    private String avatarAdres;

    public RetrofitPresenter() {
        retrofitApi = new RetrofitApi();
    }

    public void getString() {
        Observable<User> single = retrofitApi.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            avatarAdres = user.avatar_url;
            Log.d(TAG, "onNext: " + avatarAdres);
            getViewState().updateView(avatarAdres);
        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }

    public String getAvatarAdres() {
        return avatarAdres;
    }
}
