package com.v2.artesa.Login;

import android.text.TextUtils;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.v2.artesa.Model.Person;
import com.v2.artesa.Service.IRetrofitService;
import com.v2.artesa.Service.Request.ResultRequest;
import com.v2.artesa.Service.ServiceFactory;
import com.v2.artesa.Utils.GsonUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by caios on 6/26/16.
 */
public class LoginInteractorImpl implements LoginInteractor {
    IRetrofitService service = ServiceFactory
            .createRetrofitService(IRetrofitService.class, IRetrofitService.SERVICE_ENDPOINT);

    @Override
    public AccessToken loggedInFacebook() {
        return AccessToken.getCurrentAccessToken();
    }

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
            listener.onError("Username cannot be empty");
            error = true;
        }

        if (TextUtils.isEmpty(password)) {
            listener.onError("Password cannot be empty");
            error = true;
        }

        if (!error) {
            service.auth(username, password).enqueue(new Callback<ResultRequest>() {
                @Override
                public void onResponse(Call<ResultRequest> call, Response<ResultRequest> response) {
                    if (response.isSuccessful()) {
                        listener.onSuccess();
                    } else if (response.code() == 401) {
                        listener.onError("Email or password invalid. Try again");
                    }
                }

                @Override
                public void onFailure(Call<ResultRequest> call, Throwable t) {
                    listener.onError("Problem to connect. Try again");
                }
            });
        }
    }

    @Override
    public void login(final AccessToken token, final OnLoginFinishedListener listener) {
        boolean error = false;
        if (token == null) {
            listener.onIgnoreSuccess();
            error = true;
        }

        if (!error) {
            service.auth(token.getUserId()).enqueue(new Callback<ResultRequest>() {
                @Override
                public void onResponse(Call<ResultRequest> call, Response<ResultRequest> response) {
                    if (response.isSuccessful()) {
                        listener.onSuccess();
                    } else {
                        new GraphRequest(token,
                                "/me/permissions/",
                                null,
                                HttpMethod.DELETE, new GraphRequest.Callback() {
                            @Override
                            public void onCompleted(GraphResponse graphResponse) {
                                LoginManager.getInstance().logOut();

                            }
                        }).executeAsync();
                        listener.onIgnoreSuccess();
                    }
                }

                @Override
                public void onFailure(Call<ResultRequest> call, Throwable t) {
                    listener.onIgnoreSuccess();
                }
            });
        }
    }

    @Override
    public void create(Person person, final OnLoginFinishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(person.getEmail())
                || TextUtils.isEmpty(person.getName())
                || TextUtils.isEmpty(person.getPassword())) {
            listener.onError("Error to create account");

            error = true;
        }

        if (!error) {
            service.create(person).enqueue(new Callback<ResultRequest>() {
                @Override
                public void onResponse(Call<ResultRequest> call, Response<ResultRequest> response) {
                    if (response.isSuccessful()) {
                        listener.onSuccess();
                    }
                }

                @Override
                public void onFailure(Call<ResultRequest> call, Throwable t) {
                    listener.onError("Problem to connect. Try again");
                }
            });
        }
    }
}