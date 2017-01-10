package com.v2.artesa.Fragments.Login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import com.v2.artesa.Fragments.mFragment;
import com.v2.artesa.Login.LoginPresenter;
import com.v2.artesa.Model.Person;
import com.v2.artesa.R;

/**
 * Created by CaioSChristino on 09/01/17.
 */

public class ReviewFragment extends mFragment implements View.OnClickListener {
    private ProgressBar progressBar;
    private EditText username;
    private EditText email;
    private EditText password;
    private RadioGroup radioGroup;
    private TextInputLayout tTemplate;

    public ReviewFragment(LoginPresenter presenter) {
        super(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_review, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);
        updateProgressBar(progressBar);

        username = (EditText) rootView.findViewById(R.id.input_name);
        email = (EditText) rootView.findViewById(R.id.input_email);
        password = (EditText) rootView.findViewById(R.id.input_password);
        tTemplate = (TextInputLayout) rootView.findViewById(R.id.tTemplate);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.genderAccount);
        rootView.findViewById(R.id.btn_create).setOnClickListener(this);
        reviewInfos();

        return rootView;
    }

    private void reviewInfos() {
        Person person = getPresenter().getCacheAccount();
        if (person != null) {
            username.setText(person.getName());
            email.setText(person.getEmail());

            if (!TextUtils.isEmpty(person.getIdIn())) {
                tTemplate.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        String gender = "male";
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.rFemale) {
            gender = "female";
        }

        try {
            Person p;
            Person person = getPresenter().getCacheAccount();
            if (!TextUtils.isEmpty(person.getIdIn())) {
                p = new Person(person.getIdIn(), person.getFbToken(), username.getText().toString(),
                        email.getText().toString(), person.getPassword(), person.getGender(), person.getBirthday());
            } else {
                p = new Person(username.getText().toString(), email.getText().toString(), password.getText().toString(), gender);
            }

            getPresenter().createAccount(p);
        } catch (Exception e) {
            e.printStackTrace();
            getPresenter().showMessage(getContext().getString(R.string.error_create));
        }
    }
}