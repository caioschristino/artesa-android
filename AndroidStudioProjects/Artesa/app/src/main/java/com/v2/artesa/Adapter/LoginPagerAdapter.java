package com.v2.artesa.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.v2.artesa.Fragments.Login.LoginFragment;
import com.v2.artesa.Fragments.Login.ReviewFragment;
import com.v2.artesa.Fragments.Login.SplashFragment;
import com.v2.artesa.Fragments.Login.TermsFragment;
import com.v2.artesa.Login.LoginPresenter;
import com.v2.artesa.Login.LoginPresenterImpl;

/**
 * Created by CaioSChristino on 09/01/17.
 */
public class LoginPagerAdapter extends FragmentPagerAdapter {
    private LoginPresenter presenter;

    public LoginPagerAdapter(FragmentManager fm, LoginPresenter presenter) {
        super(fm);
        this.presenter = presenter;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new SplashFragment(this.presenter);
            case 1:
                return new LoginFragment(this.presenter);
            case 2:
                return new TermsFragment(this.presenter);
            case 3:
                return new ReviewFragment(this.presenter);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
