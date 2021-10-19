package com.mycompany.proyecto_j.a.a.m.conexion.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import com.mycompany.proyecto_j.a.a.m.conexion.Layout.*;
/**
 *
 * @author Jatziry Argueta
 */
public class Main {
    public static void main (String args[]){
       String ans="";
        int opcion=0;
        Scanner enter=new Scanner(System.in);
        Aplicacion app=new Aplicacion(enter);
       
       Layout.separator();
       Layout.printHeader("Libreria");
       
       while(!(ans.toUpperCase().equals("S"))){
           Layout.menu();
           ans=enter.nextLine();
           
           System.out.println("Texto ingresado es igual a " + ans);
           app.activarEvento(ans);
       }
    }
}
