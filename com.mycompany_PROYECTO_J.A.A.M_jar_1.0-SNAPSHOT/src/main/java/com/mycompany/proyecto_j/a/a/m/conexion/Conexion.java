/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_j.a.a.m.conexion;
import java.sql.*;
/**
 *
 * @author Jatziry Argueta
 */
public class Conexion {
    private static Connection conexion=null;   
    
    private Conexion(){
        
    }
    
    public static Connection conexion_basedatos(){
        try{
            if(conexion == null){
                Class.forName("org.sqlite.JDBC");
                conexion=DriverManager.getConnection("jdbc:sqlite:libreria.db");  
                return conexion;
            }
            
            else{
                return conexion;
            }
        }
        catch(Exception ex){
            System.err.println("Error:...."+ex.getMessage());
            return null;
        }
    }
    
}
