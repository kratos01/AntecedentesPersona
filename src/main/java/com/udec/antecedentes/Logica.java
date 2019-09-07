/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author David Arias
 */
public class Logica {
 
   List <Antecedente> lista = new ArrayList<>();
   Scanner entrada = new Scanner(System.in);
   File archivo= new File("Lista");
   int estado;
   
   public Logica(){
       while(estado == 0){
            System.out.println("Que desea hacer?");
            System.out.println("1.Crear Personas");
            System.out.println("2.Visualizar Informacion");
            int opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                   AgregarPersona();
                   crearArchivo(lista);
                    System.out.println("desea crear otra persona? 0= Si / 1= No");
                    estado = entrada.nextInt();                        
                break;
                case 2:
                    leerArchivo();
                break;
                
            }
       }
   }
   
   public void AgregarPersona(){
       
       System.out.println("---Ingrese Informacion---");
       
       System.out.println("Nombre: ");
       String nombre = entrada.next();
       System.out.println("Cedula: ");
       String cedula = entrada.next();
       System.out.println("Edad: ");
       int edad = entrada.nextInt();
       System.out.println("Genero: ");
       String genero = entrada.next();
       System.out.println("Fecha: ");
       String fecha = entrada.next();
       System.out.println("Descripcion: ");
       String descripcion = entrada.next();
       
       Antecedente persona = new Antecedente(fecha,descripcion, nombre, cedula, edad, genero);
       
       lista.add(persona);
             
   }
   
   public void crearArchivo(Object lista){
             
       try {
           ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo));
           salida.writeObject(lista);
           salida.close();
       } catch (Exception e) {
           
       }    
   }
   public void leerArchivo(){
       try {
           ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));
           lista=(List)entrada.readObject();
       } catch (Exception e) {
           
       }
       
       for (Antecedente a: lista) {
           System.out.println(" "+a.getNombre()+"  "+a.getCedula()+"   "+a.getDescripcion()+"  ");
       }
       
   }
}
