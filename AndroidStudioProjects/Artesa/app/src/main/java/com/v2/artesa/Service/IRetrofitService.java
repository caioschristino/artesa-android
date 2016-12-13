package com.v2.artesa.Service;

import com.v2.artesa.Service.Request.ResultRequest;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface IRetrofitService {
    String SERVICE_ENDPOINT = "http://www.mocky.io";

    @GET("/v2/583f019e240000ab0883b401")
    Call<ResultRequest> getLogin();
}