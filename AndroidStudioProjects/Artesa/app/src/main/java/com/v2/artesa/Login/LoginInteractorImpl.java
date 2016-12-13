package com.v2.artesa.Login;

import android.os.Handler;
import android.text.TextUtils;

import com.v2.artesa.Service.IRetrofitService;
import com.v2.artesa.Service.Request.ResultRequest;
import com.v2.artesa.Service.ServiceFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by caios on 6/26/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
            listener.onUsernameError();
            error = true;
        }

        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            error = true;
        }

        if (!error) {
            IRetrofitService service = ServiceFactory
                    .createRetrofitService(IRetrofitService.class, IRetrofitService.SERVICE_ENDPOINT);

            service.getLogin().enqueue(new Callback<ResultRequest>() {
                @Override
                public void onResponse(Call<ResultRequest> call, Response<ResultRequest> response) {
                    if (response.isSuccessful()) {
                        listener.onSuccess(response.body().getResponse());
                    }
                }

                @Override
                public void onFailure(Call<ResultRequest> call, Throwable t) {
                    listener.onError("Impossível se conectar ao servidor no momento");
                }
            });
        }
    }
}