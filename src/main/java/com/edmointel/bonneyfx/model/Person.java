package com.edmointel.bonneyfx.model;


public class Person {
    private String name;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NL);
        result.append("Name: " + name + NL);
        result.append("}");

        return result.toString();
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
