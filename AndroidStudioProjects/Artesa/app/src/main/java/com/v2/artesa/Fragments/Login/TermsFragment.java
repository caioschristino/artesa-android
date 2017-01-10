package com.v2.artesa.Fragments.Login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.v2.artesa.Fragments.mFragment;
import com.v2.artesa.Login.LoginPresenter;
import com.v2.artesa.R;

/**
 * Created by CaioSChristino on 09/01/17.
 */

public class TermsFragment extends mFragment {
    public TermsFragment(LoginPresenter presenter) {
        super(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_terms, container, false);
        ((CheckBox) rootView.findViewById(R.id.cbTerms)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getPresenter().goToReviewFragment();
            }
        });

        return rootView;
    }
}