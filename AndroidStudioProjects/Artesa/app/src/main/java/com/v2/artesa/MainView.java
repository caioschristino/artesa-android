package com.v2.artesa;

import java.util.List;

/**
 * Created by caios on 6/26/16.
 */
public interface MainView {
    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}