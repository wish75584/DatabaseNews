package com.bytessystem.databasenews;

public class Post  {
    String sub,desc,date,counter,id;

    public Post(String id,String sub, String desc, String date, String counter) {
        this.id = id;
        this.sub = sub;
        this.desc = desc;
        this.date = date;
        this.counter = counter;
    }


    public String getSub() {
        return sub;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public String getCounter() {
        return counter;
    }

    public String getDate() {
        return date;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCounter(String counter) {
        this.counter = counter;

    }
}
