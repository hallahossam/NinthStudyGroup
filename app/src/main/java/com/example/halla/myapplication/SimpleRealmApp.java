package com.example.halla.myapplication;

import android.app.Application;

/**
 * Created by Halla on 18/11/2016.
 */


import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SimpleRealmApp extends Application {

    private static SimpleRealmApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RealmConfiguration config = new RealmConfiguration
                .Builder(getApplicationContext()).
                setModules(new SimpleRealmModule()).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }

    public static SimpleRealmApp getInstance() {
        return instance;
    }
}

