package com.example.hw433.retrofit;

import moxy.MvpView;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface RetrofitView extends MvpView {

    @StateStrategyType(value = SkipStrategy.class)
    void updateView(String avatarAdress);
}
