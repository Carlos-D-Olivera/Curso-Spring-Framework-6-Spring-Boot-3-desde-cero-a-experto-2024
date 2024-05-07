package com.carlos.curso.springboot.webapp.springbootweb.models;

public class User {
    private String name;
    private String lastname;
    private int age;
    private String email;


    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName(){
        return this.name;    
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
