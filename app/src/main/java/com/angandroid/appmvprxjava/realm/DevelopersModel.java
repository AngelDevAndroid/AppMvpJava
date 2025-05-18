package com.angandroid.appmvprxjava.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DevelopersModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String codeProg;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCodeProg() {
        return codeProg;
    }

    public void setCodeProg(String codeProg) {
        this.codeProg = codeProg;
    }
}
