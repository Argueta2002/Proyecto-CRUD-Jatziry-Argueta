package com.mycompany.proyecto_j.a.a.m.conexion.main;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jatziry Argueta
 */
public class Item {
    int ID;
    double valor_prom;
    String Nombre_Libro;
    String Editorial;
    String Autor;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getValor_prom() {
        return valor_prom;
    }

    public void setValor_prom(double valor_prom) {
        this.valor_prom = valor_prom;
    }

    public String getNombre_Libro() {
        return Nombre_Libro;
    }

    public void setNombre_Libro(String Nombre_Libro) {
        this.Nombre_Libro = Nombre_Libro;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    
    
    public Item (){
        this.ID=0;
        this.Nombre_Libro="";
        this.Autor="";
        this.Editorial="";
        this.valor_prom=0;
    }

    public Item(int ID, double valor_prom, String Nombre_Libro, String Editorial, String Autor) {
        this.ID = ID;
        this.valor_prom = valor_prom;
        this.Nombre_Libro = Nombre_Libro;
        this.Editorial = Editorial;
        this.Autor = Autor;
    }
    
    public ArrayList<String> receive_values(){
        ArrayList campos=new ArrayList<String>();
        campos.add(this.ID);
        campos.add(this.Nombre_Libro);
        campos.add(this.Autor);
        campos.add(this.Editorial);
        campos.add(this.valor_prom);
        return campos;
    }
   
}
