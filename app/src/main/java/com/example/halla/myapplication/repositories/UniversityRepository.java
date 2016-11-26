package com.example.halla.myapplication.repositories;

import com.example.halla.myapplication.SimpleRealmApp;
import com.example.halla.myapplication.model.University;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Halla on 18/11/2016.
 */
public class UniversityRepository {
    public void addUniversity(University university) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        University u = realm.createObject(University.class);
        u.setId(UUID.randomUUID().toString());
        u.setName(university.getName());
        realm.commitTransaction();
    }
    public void deleteUniversityById(String Id) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        University university = realm.where(University.class).equalTo("id", Id).findFirst();
        university.removeFromRealm();
        realm.commitTransaction();

    }
    public void deleteUniversityByPosition(int position) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        RealmQuery query = realm.where(University.class);
        RealmResults results = query.findAll();
        results.remove(position);
        realm.commitTransaction();

    }

    public void getUniversityById(String id) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        University result = realm.where(University.class).equalTo("id", id).findFirst();
    }

    public void getAllUniversities() {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        RealmQuery query = realm.where(University.class);
        RealmResults results = query.findAll();


    }


}
