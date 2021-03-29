package com.ebookfrenzy.asyncproject;

import java.util.ArrayList;

public class Data {

    public String name = "";

    public static ArrayList<String> names = new ArrayList<>();

    public ArrayList<String> getList() {
        return names;
    }

    public void addName(String name) {
        names.add(name);
    }

}
