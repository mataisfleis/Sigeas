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
        
        // NOTE: Este usuario es de testeo, una vez implementada la logica de creacion de profesores hay que quitarlo
        crearProfesor("pablo", "tacos_de_carnitas");
        
        // INICIO DE SESION
        do{
            
            System.out.println("INICIO DE SESION");
            System.out.println("a) Iniciar sesion como profesor");
            System.out.println("b) Iniciar sesion como administrador");
            System.out.println("c) Salir");
            System.out.print("Elige una opcion > ");
            opcionMenuInicioDeSesion = escaner.nextLine().toLowerCase();
            
            switch(opcionMenuInicioDeSesion){
                case "a": {
                    boolean esFormatoUsuarioValido;
                    
                    System.out.print("Usuario > ");
                    usuario = escaner.nextLine();
                    System.out.print("Contraseña > ");
                    contrasena = escaner.nextLine();
                    
                    esFormatoUsuarioValido = esUsuarioValido(usuario, contrasena);
                    
                    if(esFormatoUsuarioValido){ // Si si existe el usuario y su contraseña coincide con la contraseña dada
                        System.out.print("\033[H\033[2J");  // Limpiar consola
                        System.out.println("Acceso permitido"); 
                        menuProfesores(escaner); // Menu profesores
                    }else{
                        System.out.println("Usuario y/o contraseña incorrectos");
                    }
                    break;
                }
                
                case "b": {
                    System.out.print("Contraseña > ");
                    contrasena = escaner.nextLine();
                    if(contrasena.equals(CONTRASENA_ADMINISTRADOR)){
                        System.out.print("\033[H\033[2J");  // Limpiar consola
                        System.out.println("Acceso permitido");
                        menuAdministrador(escaner); // Menu administrador
                    }else{
                        System.out.println("Acceso denegado");
                    }
                    break;
                }
                
                case "c": {
                    escaner.close();
                    break;
                }
                default:
                    System.out.println("Opcion desconocida");
            }
        }while(!opcionMenuInicioDeSesion.equals("c"));
    }
    
    static void menuAdministrador(Scanner escaner){
        String opcionMenuAdministrador;
        do{
            System.out.println("MENU ADMINISTRADOR");
            System.out.println("a) Consultar lista de profesores");
            System.out.println("b) Agregar profesores");
            System.out.println("c) Modificar datos de un profesor");
            System.out.println("d) Eliminar un profesor");
            System.out.println("e) Salir al menu de inicio de sesion");
            System.out.print("Elige una opcion > ");
            
            opcionMenuAdministrador = escaner.nextLine().toLowerCase();
            
            switch(opcionMenuAdministrador){
                case "a":{
                    // TODO: Consultar lista de profesores
                    break;
                }
                case "b":{
                    menuCrearProfesor(escaner);
                    break;
                }
                case "c":{
                    // TODO: Modificar profesor
                    break;
                }
                case "d": {
                    // TODO: Eliminar profesor
                    break;
                }
                case "e": break; // Salir
                default: {
                    System.out.println("Opcion desconocida");
                }
            }
        }while(!opcionMenuAdministrador.equals("e"));
        
    }
    static void menuProfesores(Scanner escaner){
        String opcionMenuProfesores;
        do {
            System.out.println("MENU PROFESORES");
            System.out.println("a) Consultar lista de alumnos");
            System.out.println("b) Añadir alumno");
            System.out.println("c) Modificar datos de un alumno");
            System.out.println("d) Eliminar alumno");
            System.out.println("e) Iniciar pase de asistencia");
            System.out.println("f) Volver al menu de inicio de sesion");
            System.out.print("Elige una opcion > ");
            opcionMenuProfesores = escaner.nextLine().toLowerCase();
            
            switch(opcionMenuProfesores){
                case "a": {
                    // TODO: Consultar lista de alumnos
                    //Temporal: 
                        System.out.println("ALUMNOS");
                        for(int i = 0; i < boletas.size(); i++){
                            System.out.println("Boleta: " + boletas.get(i) + "; Nombre: " + nombres.get(i) + " " + apellidosPaterno.get(i) + " " + apellidosMaterno.get(i) + "; Grupo: " + grupos.get(i));
                        }
                    break;
                }
                case "b": {
                    menuCrearAlumno(escaner);
                    break;
                }
                case "c": {
                    // TODO: Modificar datos de un alumno
                    break;
                }
                case "d": {
                    //TODO: Eliminar alumno
                    break;
                }
                case "e": {
                    //TODO: Pase de asistencia
                    break;
                }
                case "f": break; // Salida
                default: {
                    System.out.println("Opcion desconocida");
                }
            }
        }while(!opcionMenuProfesores.equals("f"));
    }
    
    // MENU CREAR ALUMNOS
    static void menuCrearAlumno(Scanner escaner){
        int boletaAlumno;
        String nombreAlumno, apellidoPaternoAlumno, apellidoMaternoAlumno, grupoAlumno, opcionCrearAlumno;
        do{
            boolean esBoletaValida;
            do { // Validamos que la boleta recibida sea un entero mayor a cero
                esBoletaValida = true;
                System.out.println("¿Cual es la boleta del alumno?");
                boletaAlumno = validarBoleta(escaner.nextLine()); // Llamamos a la funcion para validar boleta
                if(boletaAlumno < 1){ // Si la boleta es invalida, lo notificamos
                    System.out.println("ERROR: Boleta invalida");
                    esBoletaValida = false;
                }
                if(boletas.contains(boletaAlumno)){
                    System.out.println("ERROR: Esa boleta ya esta registrada");
                    esBoletaValida = false;
                }
            }while(!esBoletaValida);
            
            do{
                System.out.println("¿Cual es el nombre del alumno? (Solo nombres)");
                nombreAlumno = escaner.nextLine().trim();
                if(!esNombreValido(nombreAlumno)){
                    System.out.println("ERROR: Nombre invalido");
                }
            }while(!esNombreValido(nombreAlumno));
            
            do{
                System.out.println("¿Cual es el apellido paterno del alumno?");
                apellidoPaternoAlumno = escaner.nextLine().trim();
                if(!esApellidoValido(apellidoPaternoAlumno)){
                    System.out.println("ERROR: Apellido paterno invalido");
                }
            }while(!esApellidoValido(apellidoPaternoAlumno));
            
            
            do{
                System.out.println("¿Cual es el apellido materno del alumno?");
                apellidoMaternoAlumno = escaner.nextLine().trim();
                if(!esApellidoValido(apellidoMaternoAlumno)){
                    System.out.println("ERROR: Apellido materno invalido");
                }
            }while(!esApellidoValido(apellidoMaternoAlumno));
            do{
                System.out.println("¿Cual es el grupo del alumno?");
                grupoAlumno = escaner.nextLine();
                if(!esGrupoValido(grupoAlumno)){
                    System.out.println("ERROR: Grupo invalido");
                }
            }while(!esGrupoValido(grupoAlumno));
            
            System.out.println("Datos capturados, elija una accion: ");
            System.out.println("a) Guardar datos y salir");
            System.out.println("b) Guardar datos y agregar un nuevo alumno");
            System.out.println("c) Salir sin guardar datos");
            System.out.println("d) Reingresar datos del alumno");
            
            do{
                System.out.print("Elija una accion: ");
                opcionCrearAlumno = escaner.nextLine().toLowerCase();
                if (!("a".equals(opcionCrearAlumno) || "b".equals(opcionCrearAlumno) || "c".equals(opcionCrearAlumno) || "d".equals(opcionCrearAlumno))) {
                    System.out.println("Opcion invalida. Elige a, b, c o d.");
                }
            }while(!("a".equals(opcionCrearAlumno) || "b".equals(opcionCrearAlumno) || "c".equals(opcionCrearAlumno) || "d".equals(opcionCrearAlumno)));
            if(opcionCrearAlumno.equals("a") || opcionCrearAlumno.equals("b")){ // Si se desea guardar los datos
                crearAlumno(boletaAlumno, nombreAlumno, apellidoPaternoAlumno, apellidoMaternoAlumno, grupoAlumno); 
            }
        
        }while(!(opcionCrearAlumno.equals("a") || opcionCrearAlumno.equals("c"))); // Si se desea salir
    }
    
    // MENU CREAR PROFESORES
    static void menuCrearProfesor(Scanner escaner){
        String profesor, contrasena, opcionCrearProfesor;
        
        System.out.println("CREAR PROFESORES");
        do{
            do{
                System.out.println("¿Cual es el usuario del profesor? (Minimo 5 caracteres)");
                profesor = escaner.nextLine();
                if(!esUsuarioValido(profesor)){
                    System.out.println("ERROR: Usuario invalido");
                }else if(profesores.contains(profesor)){
                    System.out.println("ERROR: Ese usuario ya existe");
                }
            }while(!esUsuarioValido(profesor) || profesores.contains(profesor));
            do{
                System.out.println("¿Cual es la contraseña del profesor? (Minimo 5 caracteres)");
                contrasena = escaner.nextLine();
                if(!esContrasenaValida(contrasena)){
                    System.out.println("ERROR: Contraseña invalida");
                }
            }while(!esContrasenaValida(contrasena));

            System.out.println("Datos capturados, elija una accion: ");
            System.out.println("a) Guardar datos y salir");
            System.out.println("b) Guardar datos y agregar un nuevo profesor");
            System.out.println("c) Salir sin guardar datos");
            System.out.println("d) Reingresar datos del profesor");

            do{
                System.out.print("Elija una accion: ");
                opcionCrearProfesor = escaner.nextLine().toLowerCase();
                if (!("a".equals(opcionCrearProfesor) || "b".equals(opcionCrearProfesor) || "c".equals(opcionCrearProfesor) || "d".equals(opcionCrearProfesor))) {
                    System.out.println("Opcion invalida. Elige a, b, c o d.");
                }
            }while(!("a".equals(opcionCrearProfesor) || "b".equals(opcionCrearProfesor) || "c".equals(opcionCrearProfesor) || "d".equals(opcionCrearProfesor)));
            if(opcionCrearProfesor.equals("a") || opcionCrearProfesor.equals("b")){ // Si se desea guardar los datos
                crearProfesor(profesor, contrasena);
            }
        }while(!(opcionCrearProfesor.equals("a") || opcionCrearProfesor.equals("c")));
    }
    
    // Valida si la boleta es valida, retorna un int de la boleta si es valida, y -1 si es invalida
    static int validarBoleta(String boleta){
        String regexBoleta = "[0-9]{10}";
        int boletaAlumno;
        if(!boleta.matches(regexBoleta)) return -1;
        try {
           boletaAlumno = Integer.parseInt(boleta);
        }catch(NumberFormatException e){
            return -1;
        }
        
        return boletaAlumno;
    }
    
    // Valida el inicio de sesion de un profesor
    static boolean esUsuarioValido(String usuario, String contrasena){
        int indiceUsuario = profesores.indexOf(usuario); // Encontrar el indice en donde esta el usuario
        return (indiceUsuario != -1 && contrasenas.get(indiceUsuario).equals(contrasena)); // Si si existe el usuario y su contraseña coincide con la contraseña dada
    }
    
    static boolean esNombreValido(String nombre){
        String regexNombre = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+){0,2}$";
        
        return nombre.matches(regexNombre);
    }
    
    static boolean esApellidoValido(String apellido){
        String regexApellido = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+){0,2}$";
        
        return apellido.matches(regexApellido);
    }
    
    static boolean esGrupoValido(String grupo){
        String regexGrupo = "^[1-6]I[MV](?:[1-9]|1[0-9]|20)$";
        return grupo.matches(regexGrupo);
    }
    
    static boolean esUsuarioValido(String usuario){
        String regexUsuario= "^\\S{5,}$";
        return usuario.matches(regexUsuario);
    }
    
    static boolean esContrasenaValida(String contrasena){
        String regexContrasena = "^\\S{5,}$";
        return contrasena.matches(regexContrasena);
    }
}
