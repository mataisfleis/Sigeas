/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sigeas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Darkode
 */
public class Sigeas {
    // ALUMNOS
    static ArrayList<Integer> boletas = new ArrayList<>();   
    static ArrayList<String> nombres = new ArrayList<>();   
    static ArrayList<String> apellidosPaterno = new ArrayList<>();   
    static ArrayList<String> apellidosMaterno = new ArrayList<>();   
    static ArrayList<String> grupos = new ArrayList<>();   
    // PROFESORES
    static ArrayList<String> profesores = new ArrayList<>();
    static ArrayList<String> contrasenas = new ArrayList<>();
    // ADMINISTRADOR
    static final String CONTRASENA_ADMINISTRADOR = "MeiMei2077";
            
    static void crearAlumno(int boleta, String nombre, String apellidoPaterno, String apellidoMaterno, String grupo){
        boletas.add(boleta);
        nombres.add(nombre);
        apellidosPaterno.add(apellidoPaterno);
        apellidosMaterno.add(apellidoMaterno);
        grupos.add(grupo);
    }
    
    static void crearProfesor(String usuario, String contrasena){
        profesores.add(usuario);
        contrasenas.add(contrasena);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        
        String opcionMenuInicioDeSesion, usuario, contrasena;
        // INICIO DE SESION
        
        // NOTE: Este usuario es de testeo, una vez implementada la logica de creacion de profesores hay que quitarlo
        crearProfesor("pablo", "tacos_de_carnitas");
        
        int indiceUsuario;
        do{
            System.out.println("INICIO DE SESION");
            System.out.println("Inicio de sesion");
            System.out.println("a) Iniciar sesion como profesor");
            System.out.println("b) Iniciar sesion como administrador");
            System.out.println("c) Salir");       
            opcionMenuInicioDeSesion = escaner.next().toLowerCase();
            switch(opcionMenuInicioDeSesion){
                case "a": {
                    System.out.print("Usuario > ");
                    usuario = escaner.next();
                    System.out.print("Contraseña > ");
                    contrasena = escaner.next();
                    indiceUsuario = profesores.indexOf(usuario); // Encontrar el indice en donde esta el usuario
                    if(indiceUsuario != -1 && contrasenas.get(indiceUsuario).equals(contrasena)){ // Si si existe el usuario y su contraseña coincide con la contraseña dada
                        System.out.print("\033[H\033[2J");  // Limpiar consola
                        System.out.println("Acceso permitido"); 
                        // TODO: Añadir logica del submenu del profesor
                    }else{
                        System.out.println("Usuario o contraseña no encontrados");
                    }
                    break;
                }
                case "b": {
                    System.out.print("Contrasena > ");
                    contrasena = escaner.next();
                    if(contrasena.equals(CONTRASENA_ADMINISTRADOR)){
                        System.out.print("\033[H\033[2J");  // Limpiar consola
                        System.out.println("Acceso permitido");
                        // TODO: Añadir la logica del submenu del administrador
                    }else{
                        System.out.println("Acceso denegado");
                    }
                }
                case "c": break;
                default:
                    System.out.println("Opcion desconocida");
            }
        }while(!opcionMenuInicioDeSesion.equals("c"));
    }
    
}
