package com.v2.artesa.Fragments.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.v2.artesa.Fragments.mFragment;
import com.v2.artesa.Login.LoginPresenter;
import com.v2.artesa.Model.Person;
import com.v2.artesa.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by CaioSChristino on 09/01/17.
 */

public class LoginFragment extends mFragment implements View.OnClickListener {
    private CallbackManager callbackManager;
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginButton fbLogin;

    public LoginFragment(LoginPresenter presenter) {
        super(presenter);
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);
        updateProgressBar(progressBar);

        username = (EditText) rootView.findViewById(R.id.input_email);
        password = (EditText) rootView.findViewById(R.id.input_password);
        fbLogin = (LoginButton) rootView.findViewById(R.id.fbLogin);
        fbLogin.setFragment(this);

        rootView.findViewById(R.id.btn_login).setOnClickListener(this);
        rootView.findViewById(R.id.link_signup).setOnClickListener(this);
        fbLogin.setReadPermissions(Arrays.asList("public_profile", "user_friends", "email", "user_birthday"));
        fbLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {

                                try {
                                    String id = loginResult.getAccessToken().getUserId();
                                    String password = randomString(8);
                                    String name = object.getString("name");
                                    String email = object.getString("email");
                                    String gender = object.getString("gender");
                                    String birthday = object.getString("birthday");

                                    Person person = new Person(id, name, email, password, gender, birthday);
                                    getPresenter().cacheAccount(person);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    onCancel();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    onCancel();
                                }

                                System.out.println(object.toString());
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,gender,birthday,email");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                getPresenter().showMessage(getContext().getString(R.string.error_sinc));
            }

            @Override
            public void onError(final FacebookException exception) {
                getPresenter().showMessage(getContext().getString(R.string.error_sinc));
            }
        });

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                getPresenter().validateCredentials(username.getText().toString(), password.getText().toString());
                break;

            case R.id.link_signup:
                getPresenter().goToTermsFragment();
                break;
        }
    }

    @Override
    public void onActivityResult(
            final int requestCode,
            final int resultCode,
            final Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    private String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}