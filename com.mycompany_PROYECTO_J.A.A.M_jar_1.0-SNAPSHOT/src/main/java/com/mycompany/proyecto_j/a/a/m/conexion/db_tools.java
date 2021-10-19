/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_j.a.a.m.conexion;

import com.mycompany.proyecto_j.a.a.m.conexion.main.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Jatziry Argueta
 */
public class db_tools {
    private ArrayList registers;
    
    public db_tools(){
        this.registers=new ArrayList<Item>();
    }
    
    public void cretable(){
        String create="CREATE TABLE IF NOT EXISTS LIBROS"
                + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "NOMBRE_LIBRO TEXT NOT NULL,"
                + "EDITORIAL TEXT NOT NULL,"
                + "AUTOR TEXT NOT NULL,"
                + "VALOR_PROM TEXT NOT NULL"
                + ")";
        try{
            Statement resume=Conexion.conexion_basedatos().createStatement();
            int res=resume.executeUpdate(create);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Item> getItems(boolean forceload){
        try{
            if(forceload){
                Statement resume= Conexion.conexion_basedatos().createStatement();
                ResultSet misRegistro=resume.executeQuery("SELECT * FROM LIBROS;");
                this.registers.clear();
                
                while(misRegistro.next()!=false)
                {
                    Item temp=new Item();
                    temp.setID(misRegistro.getInt("ID"));
                    temp.setNombre_Libro(misRegistro.getString("NOMBRE_LIBRO"));
                    temp.setEditorial(misRegistro.getString("EDITORIAL"));
                    temp.setAutor(misRegistro.getString("AUTOR"));
                    temp.setValor_prom(misRegistro.getDouble("VALOR_PROM"));
                    
                    this.registers.add(temp);
                }
                resume.close();
            }
            return this.registers;
            
        }catch(Exception ex){
            System.err.println("Error..."+ex.getMessage());
            return this.registers;
        }
    }
    
    public Item getItemsId(int id){
        try{
            
            String Sql_Id="SELECT * FROM LIBROS WHERE ID=?;";
            PreparedStatement comando=Conexion.conexion_basedatos().prepareStatement(Sql_Id);          //Ejecuta comandos SQL del Programa a la Base de Datos
            comando.setInt(1, id);
            ResultSet misRegistro=comando.executeQuery();                                          //permite el manejo de la Base de Datos, y trabaja de la Base de Datos al Programa
            Item temp= new Item();
            
            while(misRegistro.next())
            {
                temp.setID(misRegistro.getInt("ID"));
                temp.setNombre_Libro(misRegistro.getString("NOMBRE_LIBRO"));
                temp.setEditorial(misRegistro.getString("EDITORIAL"));
                temp.setAutor(misRegistro.getString("AUTOR"));
                temp.setValor_prom(misRegistro.getDouble("VALOR_PROM"));
                break;
            }
            
            comando.close();
            return temp;
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public int updateRegister(Item item_Update){
        try{
            String sql_Update="UPDATE LIBROS SET "
                    + "NOMBRE_LIBRO=?,"
                    + "EDITORIAL=?,"
                    + "AUTOR=?,"
                    + "VALOR_PROM=?"
                    + "WHERE ID=?;";
            
            PreparedStatement comando=Conexion.conexion_basedatos().prepareStatement(sql_Update);
            
            comando.setString(1, item_Update.getNombre_Libro());
            comando.setString(2, item_Update.getEditorial());
            comando.setString(3, item_Update.getAutor());
            comando.setDouble(4, item_Update.getValor_prom());
            comando.setInt(5, item_Update.getID());
            
            int RegistroAfectado=comando.executeUpdate();
            comando.close();
            return RegistroAfectado;
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int insertRegister(Item item_Update){
        try{
            
            String sql_insert="INSERT INTO Registros(NOMBRE_LIBRO, EDITORIAL, AUTOR, VALOR_PROM) VALUES (?, ?, ?, ?);";
            PreparedStatement comando = Conexion.conexion_basedatos().prepareStatement(sql_insert);
            
            comando.setString(1, item_Update.getNombre_Libro());
            comando.setString(2, item_Update.getEditorial());
            comando.setString(3, item_Update.getAutor());
            comando.setDouble(4, item_Update.getValor_prom());
            
            int RegistroAfectado=comando.executeUpdate();
            comando.close();
            return RegistroAfectado;
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int DeleteRegister(Item item_Delete){
        try{
            String Sql_Delete="DELETE FROM LIBROS WHERE ID = ?;";
            PreparedStatement comando = Conexion.conexion_basedatos().prepareStatement(Sql_Delete);
            
            comando.setInt(1, item_Delete.getID());
            
            int RegistroAfectado=comando.executeUpdate();
            comando.close();
            return RegistroAfectado;
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    } 
}

