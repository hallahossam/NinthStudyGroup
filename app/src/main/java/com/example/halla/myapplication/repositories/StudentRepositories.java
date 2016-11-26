package com.example.halla.myapplication.repositories;

import com.example.halla.myapplication.SimpleRealmApp;
import com.example.halla.myapplication.model.Student;
import com.example.halla.myapplication.model.University;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Halla on 18/11/2016.
 */
public class StudentRepositories {

    Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());

    public void addStudent(Student student) {
        realm.beginTransaction();
        Student u = realm.createObject(Student.class);
        u.setId(UUID.randomUUID().toString());
        u.setName(student.getName());
        u.setEmail(student.getEmail());
        realm.commitTransaction();
    }

    public void deleteStudentById(String Id) {
        realm.beginTransaction();
        Student student = realm.where(Student.class).equalTo("id", Id).findFirst();
        student.removeFromRealm();
        realm.commitTransaction();

    }
    public void deleteStudentByPosition(int position) {
        realm.beginTransaction();

        RealmResults results = realm.where(Student.class).findAll();
        results.remove(position);
        realm.commitTransaction();

    }

    public void getStudentById(String id) {
        Student result = realm.where(Student.class).equalTo("id", id).findFirst();
    }

    public RealmResults getAllStudents() {
        RealmResults results = realm.where(Student.class).findAll();
return results;

    }
}
