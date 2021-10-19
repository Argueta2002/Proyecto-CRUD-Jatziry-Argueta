/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_j.a.a.m.conexion.Layout;

import java.util.*;
/**
 *
 * @author Jatziry Argueta
 */
public class Layout {
 
    public static void separator(){
        System.out.println("*******************************************************************************");
    }
    public static void printHeader(String header){
        int headerlen=header.length();
        int startpoint=(header.length()-80)/2;
        String present="";
        
        for(int i=0;i<startpoint;i++){
            present+=" ";
        }
        present+=header;
        
        for(int i=0;i<startpoint;i++){
            present+=" ";
        }
        System.out.println(present);
    }
    public static void menu(){
        Layout.separator();
        Layout.printHeader("Menu Principal");
        Layout.separator();
        
        System.out.println("\nIngresar Datos.................[I]"
                            + "\nMostrar Datos en Pantalla...[M]"
                            + "\nActualizar Datos............[A]"
                            + "\nEliminar Datos..............[E]"
                            + "\nSalir del Programa..........[S]");
        
        
        Layout.separator();
    }
    public static String data_enter(String etiqueta, String valor_predeterminado, Scanner enter){
        System.out.println(etiqueta + "(" + valor_predeterminado + ") : ");
        String valor=enter.nextLine();
        
        if(valor.isEmpty()){
            return valor_predeterminado;
        }
            
         return valor;
    }
    
    public static void insert_Data(ArrayList columnas, ArrayList anchos, String separator)throws Exception{
        if ( columnas.size() != anchos.size()) {
            throw new Exception("Las columnas no coinciden con los anchos");
        }
        System.out.print(separator);
        for (int i = 0; i < columnas.size(); i++){
            String columna = String.format("%1$" + String.valueOf(anchos.get(i)) +"s", columnas.get(i));
            
            
            System.out.print(columna);
            System.out.print(separator);
        
        }
        System.out.println();
    }
    public static void imprimirEnColumna(ArrayList<String> columnas, ArrayList<Integer> anchos, String separator) throws Exception{
        if ( columnas.size() != anchos.size()) {
            throw new Exception("Las columnas no coinciden con los anchos");
        }
        System.out.print(separator);
        for (int i = 0; i < columnas.size(); i++){
            String columna = String.format("%1$-" + String.valueOf(anchos.get(i)) +"s", columnas.get(i));
            columna = columna.substring(0, anchos.get(i));
            
            System.out.print(columna);
            System.out.print(separator);
        
        }
        System.out.println();
    }
    public static int data_enter_valid_int(String etiqueta, int valor_predeterminado, Scanner enter, int max, int min){
        
        String valor="";
        
        do{
            System.out.println(etiqueta + "(" + valor_predeterminado + ") : ");
            valor=enter.nextLine();
            
            if(Integer.parseInt(valor)>max || Integer.parseInt(valor)<min){
                System.out.printf("Error...Ingrese un valor entre %d-%d \n",max,min);
            }
            
            else if (valor.isEmpty()){   
                return valor_predeterminado;
            }
        }while(Integer.parseInt(valor)>max || Integer.parseInt(valor)<min);
        
        return Integer.valueOf(valor);
    }
}
