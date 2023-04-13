package com.example.back.model;

public class Empleado {

    private long id;
    private String nombre;
    private String password;
    private String email;

    public Empleado(){
    }

    public  Empleado (Long id, String nombre, String password, String email){
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    public long getId(){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password =password;
    }

    public  String toString(){
        return "Empleado(" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


