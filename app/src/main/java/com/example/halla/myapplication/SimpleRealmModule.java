package com.example.halla.myapplication;

import com.example.halla.myapplication.model.Student;
import com.example.halla.myapplication.model.University;

import io.realm.annotations.RealmModule;

/**
 * Created by Halla on 18/11/2016.
 */
@RealmModule(classes = {Student.class, University.class})
public class SimpleRealmModule {}

