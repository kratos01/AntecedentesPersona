/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase contiene el menu y los metodos para manipular los datos.
 * @author David Arias
 */
public class Logica {
   /**
    * Atributo que guarda la lista de antecedentes*/
   List <Antecedente> lista = new ArrayList<>();
   /**
    * Atributo que guarda la lista de antecedentes*/
   List <Persona> listaper = new ArrayList<>();
   /**
    * Scanner para recibir datos por teclado*/
   Scanner entrada = new Scanner(System.in);
   /**
    * Archivo para guardar antecedentes*/
   File archivo = new File("Antecedente.txt");
   /**
    * Archivo para guardar personas*/
   File pers = new File("Persona.txt");
   
   
   /**
    * Constructor de la clase.
    */
   public Logica(){
       while(true){
           System.out.println("");
            System.out.println("Que desea hacer?");
            System.out.println(" 1.Crear Personas \n 2.Crear Antecedentes \n 3.Visualizar Todas las Personas "
                    + "\n 4.Visualizar todos antecedentes"
                    + "\n 5.Filtrar antecedentes por persona"
                    + "\n 6.Eliminar antecedente"
                    + "\n 7.Modificar antecedente");
            int opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                   AgregarPersona();
                break;
                case 2:
                   crearAntecedente();
                   
                break;
                case 3:
                   leerArchivoPersonas();     
                break;
                case 4:
                   leerArchivoAntecedentes();
                break;
                case 5:
                   filtrarPorPersona();
                break;
                case 6:
                   eliminarAntecedente();
                break;
                case 7:
                   modificarAntecedente();
                break;
                
            }
            crearArchivo(listaper);
            crearArchivoAntecedentes(lista);
        }
   }
     
   /**
    * Metodo para agregar personas.
    */
   public void AgregarPersona(){
       System.out.println("---Ingrese Informacion---");
       System.out.println("Nombre: ");
       String nombre = entrada.next();
       System.out.println("Cedula: ");
       int cedula = entrada.nextInt();
       System.out.println("Edad: ");
       int edad = entrada.nextInt();
       System.out.println("Genero: ");
       String genero = entrada.next();
       Persona p = new Persona(nombre, cedula, edad, genero);
       try {
        FileInputStream document = new FileInputStream(pers);
        ObjectInputStream leer = new ObjectInputStream(document);
        listaper = (ArrayList<Persona>)leer.readObject();
        listaper.add(p);
       } catch (Exception e) {
       }
   }
   /**
    * Metodo validar si existe cedula.
    * @param cedula cedula de la persona
    * @return true o false.
    */
   public boolean validarCedula(int cedula){
       try {
        FileInputStream document = new FileInputStream(pers);
        ObjectInputStream leer = new ObjectInputStream(document);
        listaper = (ArrayList<Persona>)leer.readObject();
           for (Persona per:listaper) {
               if(per.getCedula()==cedula){
                  return true;
               }
           } 
       } catch (Exception e) {
       } 
       return false;
   
   }
   /**
    * Metodo para crear antecedentes.
    */
     public void crearAntecedente(){
        System.out.println("---Ingrese los siguientes datos: \n Cedula de la persona ");
        int cedulaper=entrada.nextInt();
         if(validarCedula(cedulaper)==true){
        System.out.println("Fecha:");
        String fecha=entrada.next();
        System.out.println("Seleccione tipo de antecedente: 1. Al Dia 2. En mora 3. Aplazado ");
        int seleccion= entrada.nextInt();
        String tipoAn=null,descripcion=null;
        if(seleccion==1){
             tipoAn="Al Dia";
             descripcion="Esta al dia con los pagos";
        }else if(seleccion==2){
             tipoAn="Mora";
             descripcion="No ha realizado los pagos";
        }else if(seleccion==3){
             tipoAn="Aplazado";
             descripcion="Tiene plazo para realizar pagos";
        }else System.out.println("seleccion invalida");
              Antecedente antecedente=new Antecedente(fecha, descripcion, tipoAn,cedulaper);  
           try {
           FileInputStream document = new FileInputStream(archivo);
           ObjectInputStream leer = new ObjectInputStream(document);
           lista = (ArrayList<Antecedente>)leer.readObject();
           lista.add(antecedente);
         } catch (Exception e) {
         }
         }else System.out.println("No hay ninguna persona registrada con esta cedula");
    }
     /**
      * Metodo para filtrar datos de una persona.
      */
     public void filtrarPorPersona(){
         try {
           FileInputStream document = new FileInputStream(archivo);
           ObjectInputStream leer = new ObjectInputStream(document);
           lista = (ArrayList<Antecedente>)leer.readObject();    
           FileInputStream document2 = new FileInputStream(pers);
           ObjectInputStream leer2 = new ObjectInputStream(document2);
           listaper = (ArrayList<Persona>)leer2.readObject();      
             System.out.println("Ingrese la cedula de la persona");
             int cedula= entrada.nextInt();
              for(Persona a : listaper){
                  if (cedula==a.getCedula()) {
                  System.out.println("\t Persona");
                  System.out.println("Nombre: " + a.getNombre()+ "     Cedula: " 
                                + a.getCedula()+"      Edad:"+a.getEdad()+"     genero:"+a.getGenero());
             }}    
              System.out.println("\t Antecedentes");
             for(Antecedente p : lista){
               if(cedula==p.getCedulaper()){
               System.out.println("Cedula persona: "+p.getCedulaper()+"     Fecha: " + p.getFecha()+ "     Tipo antecedente: " 
                                + p.getTipoAntecedente()+"      Descripcion:"+p.getDescripcion()); 
               }}
         } catch (Exception e) {
         }
     }
     /**
      * Metodo para eliminar antedentes.
      */
     public void eliminarAntecedente(){
         System.out.println("Numero de Cedula:");
         int cedula=entrada.nextInt();
         System.out.println("Fecha de antecedente:");
         String fecha=entrada.next();
         try {
           FileInputStream document = new FileInputStream(archivo);
           ObjectInputStream leer = new ObjectInputStream(document);
           lista = (ArrayList<Antecedente>)leer.readObject();
           for(Antecedente p : lista){
               if(p.getCedulaper()==cedula && p.getFecha().equals(fecha)){
                   if(p.getTipoAntecedente().equals("Al dia")){
                    lista.remove(p);
                   System.out.println("Eliminado con exito");
                   } else System.out.println("No se puede eliminar antecedente");                 
               }
           }  
         } catch (Exception e) {
         }

     }
     /**
      * Metodo para modificar un antecedente.
      */
     public void modificarAntecedente(){
         System.out.println("Numero de Cedula:");
         int cedula=entrada.nextInt();
         System.out.println("Fecha de antecedente:");
         String fecha=entrada.next();
         try {
           FileInputStream document = new FileInputStream(archivo);
           ObjectInputStream leer = new ObjectInputStream(document);
           lista = (ArrayList<Antecedente>)leer.readObject();
           for(Antecedente p : lista){
               if(p.getCedulaper()==cedula && p.getFecha().equals(fecha)){
                   System.out.println("Escriba nueva fecha:");
                   p.setFecha(entrada.next());
                   System.out.print("Seleccione nuevo tipo 1. Al Dia 2. En mora 3. Aplazado: ");
                    int seleccion= entrada.nextInt();
                    String tipoAn=null,descripcion=null;
                    if(seleccion==1){
                         p.setTipoAntecedente("Al Dia");
                         p.setDescripcion("Esta al dia con los pagos");
                    }else if(seleccion==2){
                           p.setTipoAntecedente("Mora");
                          p.setDescripcion("No ha realizado los pagos");
                    }else if(seleccion==3){
                           p.setTipoAntecedente("Aplazado");
                          p.setDescripcion("Tiene plazo para realizar pagos");
                    }else System.out.println("seleccion invalida");
                    
                   System.out.println("Editado con exito");
               }
           }  
         } catch (Exception e) {
         }
     }
   /**
    * Metodo para crear archivo personas.
    * @param listaper lista de personas
    */
   public void crearArchivo(Object listaper){             
       try {
               ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(pers));
               salida.writeObject(listaper);
           }
        catch (Exception e) {
           e.getStackTrace();
       }    
   }
   /**
    * Metodo para crear archivo antecedentes.
    * @param lista lista de antecedentes.
    */
   public void crearArchivoAntecedentes(Object lista){             
       try {
               ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream(archivo));
               salida.writeObject(lista);
           }
        catch (Exception e) {
           e.getStackTrace();
       }    
   }
   /**
    * Metodo para leer archivo personas.
    */
   public void leerArchivoPersonas(){
       
       try {
           FileInputStream document = new FileInputStream(pers);
           ObjectInputStream leer = new ObjectInputStream(document);
           listaper = (ArrayList<Persona>)leer.readObject();
           
               for(Persona a : listaper)
                System.out.println("Nombre: " + a.getNombre()+ "     Cedula: " 
                                + a.getCedula()+"      Edad:"+a.getEdad()+"     genero:"+a.getGenero());  
               
       } catch (IOException | ClassNotFoundException e) {
           e.getStackTrace();
           System.out.println(e.getMessage());
       }
   }
   /**
    * Metodo para leer archivo de antecedentes.
    */
    public void leerArchivoAntecedentes(){
       
       try {
           FileInputStream document = new FileInputStream(archivo);
           ObjectInputStream leer = new ObjectInputStream(document);
           lista = (ArrayList<Antecedente>)leer.readObject();
           
               for(Antecedente p : lista)
               System.out.println("Cedula persona: "+p.getCedulaper()+"     Fecha: " + p.getFecha()+ "     Tipo antecedente: " 
                                + p.getTipoAntecedente()+"      Descripcion:"+p.getDescripcion()); 
               
       } catch (IOException | ClassNotFoundException e) {
           e.getStackTrace();
           System.out.println(e.getMessage());
       }
   }
    
}
