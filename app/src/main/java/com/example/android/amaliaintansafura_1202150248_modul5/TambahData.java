package com.example.android.amaliaintansafura_1202150248_modul5;

/**
 * Created by Amalia Intan Safura on 3/25/2018.
 */

public class TambahData {
    String todo, desc, prior;

    //konstruktor
    public TambahData(String todo, String desc, String prior){
        this.todo=todo;
        this.desc=desc;
        this.prior=prior;
    }

    //method setter dan getter untuk to do , description dan priority
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }
}
