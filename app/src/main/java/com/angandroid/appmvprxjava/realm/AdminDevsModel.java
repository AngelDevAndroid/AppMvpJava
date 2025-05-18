package com.angandroid.appmvprxjava.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AdminDevsModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<DevelopersModel> listDevs;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public RealmList<DevelopersModel> getListDevs() {
        return listDevs;
    }
    public void setListDevs(RealmList<DevelopersModel> listDevs) {
        this.listDevs = listDevs;
    }
}
