package com.v2.artesa.Login;

import com.v2.artesa.Model.Response;
import com.v2.artesa.Service.Request.ResultRequest;

/**
 * Created by caios on 6/26/16.
 */
public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(Response response);

        void onError(String s);
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}