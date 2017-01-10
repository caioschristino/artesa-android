package com.v2.artesa.Service;

import com.v2.artesa.Model.Person;
import com.v2.artesa.Service.Request.ResultRequest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface IRetrofitService {
//    String SERVICE_ENDPOINT = "http://localhost:8080/simple-heroku-webapp";
    String SERVICE_ENDPOINT = "https://shrouded-sierra-90668.herokuapp.com";

    @FormUrlEncoded
    @POST("/authentication")
    Call<ResultRequest> auth(@Field("email") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("/authentication")
    Call<ResultRequest> auth(@Field("idIn") String idIn);

    @POST("/user/add")
    Call<ResultRequest> create(@Body Person person);
}