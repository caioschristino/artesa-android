package com.v2.artesa;

/**
 * Created by caios on 6/26/16.
 */
public interface MainPresenter {
    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}