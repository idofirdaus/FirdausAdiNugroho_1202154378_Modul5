package com.example.idofirdaus.firdausadinugroho_1202154378_studycase5.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity {

    private long id;
    private String todo;
    private String description;
    private String priority;

    public Activity(){

    }

    public Activity(String todo, String description, String priority){
        this.todo = todo;
        this.description = description;
        this.priority = priority;
    }

    public Activity(int id, String todo, String description, String priority){
        this.id = id;
        this.todo = todo;
        this.description = description;
        this.priority = priority;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
