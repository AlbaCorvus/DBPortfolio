package com.cjmulcahy.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Chris on 1/23/2017.
 */
public class DataHolder implements Serializable{

    private ArrayList<Object> data;



    public DataHolder(){
        data= new ArrayList<>();
    }

    public ArrayList<Object> getData() {
        return data;
    }

    public void setData(ArrayList<Object> data) {
        this.data = data;
    }
}
