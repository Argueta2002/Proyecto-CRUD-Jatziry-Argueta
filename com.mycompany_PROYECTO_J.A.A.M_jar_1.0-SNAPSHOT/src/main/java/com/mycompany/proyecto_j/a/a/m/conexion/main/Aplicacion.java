package com.mycompany.proyecto_j.a.a.m.conexion.main;

import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.proyecto_j.a.a.m.conexion.Layout.Layout;  
import com.mycompany.proyecto_j.a.a.m.conexion.db_tools;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jatziry Argueta
 */
public class Aplicacion {
    private Scanner _EntradaTeclado;
    private ArrayList NItems;
    private int IdCounter;
    private db_tools Model;
    

    
    public Aplicacion(Scanner EntradaTeclado){
        this._EntradaTeclado=EntradaTeclado;
        this.NItems = new ArrayList<Item>();  
        this.IdCounter = 0;
        this.Model = new db_tools();
        this.Model.cretable();
        this.NItems = this.Model.getItems(true);
    }
   public void activarEvento(String opcionMenu){
        switch(opcionMenu.toUpperCase()){
            case "M":
                this.mostrarLenguajes();
                break;
            case "I":
                this.ingresarNuevoRegistro();
                break;
            case "A":
                this.actualizarRegistro();
                break;
            case "E":   
                this.eliminarRegistro();
                break;
            case "S":
                break;
            default:
                System.out.println("Opción no reconocida!!!");
                break;
        }
        }
   private void ingresarNuevoRegistro(){
        Layout.printHeader("Nuevo Registro de Canción");
        Item nuevoLenguajeItem =  new Item();
        // el Id es autoincrementable
        nuevoLenguajeItem.setAutor(Layout.data_enter("Valor_Prom", "Autor X", this._EntradaTeclado));  
        nuevoLenguajeItem.setEditorial(Layout.data_enter("Editorial", "Editorial Y", this._EntradaTeclado));
        nuevoLenguajeItem.setValor_prom(Double.parseDouble(Layout.data_enter("Valor del libro", "0.00", this._EntradaTeclado))); 
        nuevoLenguajeItem.setAutor(Layout.data_enter("Autor", "Autor X", this._EntradaTeclado)); 
        //Siga solo hace falta un valor mas
        
        this.Model.insertRegister(nuevoLenguajeItem);       
        this.NItems=this.Model.getItems(true);              
    }
     
      private void mostrarLenguajes(){
        Layout.separator();    
        ArrayList<String> columnas = new ArrayList<String>();
        columnas.add("Codigo");
        columnas.add("Nombre de Libro");
        columnas.add("Editorial");
        columnas.add("Autor");
        columnas.add("Valor del libro");          
        
        ArrayList<Integer> anchos = new ArrayList<Integer>();
        anchos.add(7);
        anchos.add(20);
        anchos.add(20);
        anchos.add(20);
        anchos.add(20);
        
        try {
            Layout.imprimirEnColumna(columnas, anchos, "|");
            Layout.separator();
            for(int i = 0; i< this.NItems.size(); i++){
                columnas =((Item)this.NItems.get(i)).receive_values();     
                Layout.imprimirEnColumna(columnas, anchos, "|");
            }
            
        } catch(Exception ex) {
            System.err.println("Error al imprimir " + ex.getMessage());
        }
    }
      
      private void actualizarRegistro(){
        Layout.printHeader("Actualizar Registro");
        int selectedId = Integer.valueOf(Layout.data_enter("Ingrese Codigo Registro", "0", this._EntradaTeclado));
        Item selectlenguaje = null;
        for( int i=0; i < this.NItems.size(); i++){
            if( selectedId == ((Item)this.NItems.get(i)).getID()) {
                selectlenguaje = (Item)this.NItems.get(i);
                break;
            }
        }
        if (selectlenguaje == null ) {
            System.out.println("Registro solicitado no existe!!!");
        } else {
            selectlenguaje.setNombre_Libro(Layout.data_enter("Nombre del libro", selectlenguaje.getNombre_Libro(), this._EntradaTeclado));
            selectlenguaje.setAutor(Layout.data_enter("Nombre del Autor", selectlenguaje.getAutor(), this._EntradaTeclado));
            selectlenguaje.setEditorial(Layout.data_enter("Editorial", selectlenguaje.getEditorial(), this._EntradaTeclado));
           
             
            Layout.separator();
            System.out.println("Registro Actualizado Correctamente!!!");
        }
        
    }
      
       private void eliminarRegistro(){
        Layout.printHeader("Eliminar Registro");
        int selectedId = Integer.valueOf(Layout.data_enter("Ingrese Codigo Registro", "0", this._EntradaTeclado));
        int encontradoEnIndice = -1;
        for( int i=0; i < this.NItems.size(); i++){
            if( selectedId == ((Item)this.NItems.get(i)).getID()) {
                encontradoEnIndice = i;
                break;
            }
        }
        if (encontradoEnIndice>=0){
            Layout.separator();
            String confirmado = Layout.data_enter("¿Desea Eliminar este Registro? S - N", "N", this._EntradaTeclado);
            if (confirmado.toUpperCase().equals("S")){
                this.NItems.remove(encontradoEnIndice);
                Layout.separator();
                System.out.println("Registro Eliminado Satisfactoriamente!!!");
            }
        } else {
            System.out.println("Registro solicitado no existe!!!");
        }
    
    }
}

   
    
   



