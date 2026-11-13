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

        
        
    }
    
}
