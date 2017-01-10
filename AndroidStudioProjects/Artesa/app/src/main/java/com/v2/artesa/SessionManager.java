package com.v2.artesa;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.v2.artesa.Model.Person;

/**
 * Created by CaioSChristino on 13/12/16.
 */

public class SessionManager extends Application {
    private Person user;
    private boolean load;

    public Person getPerson() {
        return user;
    }

    public void setPerson(Person user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.load = true;
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    public void setLoad(boolean load) {
        this.load = load;
    }

    public boolean load() {
        return this.load;
    }
}