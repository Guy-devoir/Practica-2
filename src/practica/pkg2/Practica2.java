package practica.pkg2;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Luciano Xiquín
 * @author Oscar Hernández
 * @author Brayan Mica
 * @author Fernando Mendoza
 */
public class Practica2 {
static Scanner sc = new Scanner(System.in);
// Constantes de color agregar al final de un System.out.println("hola" + \u001B[30m);
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
// Constante de color especial para volver a dejar todo con normalidad
    public static final String ANSI_RESET = "\u001B[0m";
    //Para usar los colores System.out.println(ANSI_RED + "Texto de color rojo" + ANSI_RESET);

//el arreglo de los usuarios
static Usuario[] users = new Usuario[5];
static Alumno[] alumni = new Alumno[100];
static Profesor[] profs = new Profesor[20];
static Curso[] cursos = new Curso[15];
/*
*Por alguna razón el scanner llega a fallar, así que recomiendo, usar scaneres locales
*de otra forma podrían encontrarse con un error
*Mejor si usan un nuevo scanner para
*/

    public static void main(String[] args) {
        Console c = System.console();
        String user;
/*Usuario aux = new Usuario();
aux.setCont("Uno");
aux.setNombre("desu");

        System.out.print(aux.getCont() + aux.getNombre());
         */
        System.out.println("Usuario:");
        user = sc.nextLine();
        String pass;
        System.out.println("Contraseña:");
        pass = "admin";
        try {
            if (user.equals("admin") && pass.equals("admin")) {
                Menu();
            }
        } catch (Exception e) {
            System.out.println("Usuario no valido");
        }
    }

    private static void Menu() {
        boolean menu = true;
        do {
            try {
                int opc;
                System.out.println(ANSI_YELLOW +"Menu principal"
                        + "\n1)Cargar Alumnos"
                        + "\n2)Cargar Profesores"
                        + "\n3)Cargar Cursos"
                        + "\n4)Asignar alumnos"
                        + "\n5)Asignar profesores"
                        + "\n6)Cargar Notas"
                        + "\n7)Crear usuario"
                        + "\n8)Cerrar Sesión"+ANSI_RESET);
                switch (opc = sc.nextInt()) {
                    case 1:
                        try {
                        alumni = reader_alumni();
                    } catch (IOException e) {
                        System.out.println("Proceso de carga de alumnos fallida");
                    }
                    break;
                    case 2:
                        try {
                        profs = reader_profs();
                    } catch (IOException e) {
                        System.out.println("Proceso de carga de profesores fallida");
                    }
                    break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        int pos;
                        System.out.println("Seleccione el espacio de memoria donde el usuario será creado"
                                + "\nSolo existen 5 espacios para usuarios (Exceptuando el admin)");
                        pos = sc.nextInt();
                        users[pos] = crear_usuario();
                        System.out.println("Usuario: " + users[pos].getNombre() + "/" + users[pos].getCont());
                        break;
                    case 8:
                        Nueva_sesion();
                        break;
                    default:
                        System.out.println("Seleccione una de las opciones");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida");
            }
        } while (menu == true);
    }

    private static Usuario crear_usuario() {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Usuario aux = new Usuario();
        String nombre;
        System.out.print("Ingresé el nombre: ");
        nombre = sc1.nextLine();
        String contrase;
        System.out.print("Ingresé la contraseña: ");
        contrase = sc2.nextLine();

        aux.setNombre(nombre);
        aux.setCont(contrase);

        //System.out.println(aux.getNombre()+aux.getCont());
        return aux;
    }

    private static void Nueva_sesion() {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Console c = System.console();
        String user;
        System.out.println("Usuario:");
        user = sc1.nextLine();
        String pass;
        System.out.println("Contraseña:");
        pass = sc2.nextLine();
        try {
            if (user.equals("admin") && pass.equals("admin")) {
                Menu();
            }
            if (user.equals(users[0].getNombre()) && pass.equals(users[0].getCont())) {
                menu_reporte();
            }
            if (user.equals(users[1].getNombre()) && pass.equals(users[1].getCont())) {
                menu_reporte();
            }
            if (user.equals(users[2].getNombre()) && pass.equals(users[2].getCont())) {
                menu_reporte();
            }
            if (user.equals(users[3].getNombre()) && pass.equals(users[3].getCont())) {
                menu_reporte();
            }
            if (user.equals(users[4].getNombre()) && pass.equals(users[4].getCont())) {
                menu_reporte();
            }
        } catch (Exception e) {
            System.out.println("Usuario no valido");
            System.exit(0);
        }
    }

    //Todabía es muy primitivo... cargar alumnos
    private static Alumno[] reader_alumni() throws IOException {
        System.out.println("Introduzca la ruta del archivo");
        Alumno[] aux = null;
        String linea = "";
        //la dirección del archivo
        //https://www.youtube.com/watch?v=zKDmzKaAQro
        File nuevo = new File(sc.nextLine());
        try {
            FileReader archivo = new FileReader(nuevo);
            BufferedReader buffer = new BufferedReader(archivo);
            String temporal = "";
            while (linea != null) {
                linea = buffer.readLine();
                if (linea != null) {
                    //se almacena todo en un String que contendra los datos crudos
                    temporal += linea;
                }
                //se almacena ahora todo eso un vector String que tendra cada fila separada
                String[] filas = temporal.split("\n");
                //el aux tendra tantos objetos como elementos del arreglo de filas
                aux = new Alumno[filas.length];

                for (int i = 0; i < filas.length; i++) {
                    /*
                    La posición "i" del arreglo se llenará con su respectivos
                    valores[], valores en posición "i"
                    */
                    String[] valores = filas[i].split(",");
                    aux[i].setId_est(Integer.valueOf(valores[0]));
                    aux[i].setCarnet(Integer.valueOf(valores[1]));
                    aux[i].setNombre(valores[2]);
                    aux[i].setCumple(valores[3]);
                    aux[i].setGenero(valores[4]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            System.out.println(e.getMessage());
        }
        return aux;
    }
    
    //menu de reportes
    private static void menu_reporte(){
    boolean menu = true;

    Scanner sc1 = new Scanner(System.in);
    int opc;
    while(menu = true){
        System.out.println(ANSI_RED+"Menu de reportes"
                + "\n1)Generar Reportes"
                + "\n2)Cerrar Sesión" +ANSI_RESET);
        
        try{
        switch(opc = sc1.nextInt()){
            case 1:
                sub_menureporte();
                break;
            case 2:
                Nueva_sesion();
                break;
            default:
                System.out.println("Seleccione una opción");
                break;
        }
        }catch(Exception e){
            System.out.println("Entrada no valida");
        }
        
    }
    }


    private static void sub_menureporte(){
        Scanner sc1 = new Scanner(System.in);
        int opc=0;
        System.out.println(ANSI_BLUE+"Menu de reportes"
                + "\n1) Reporte de alumnos"
                + "\n2) Reporte de asignacion de alumnos"
                + "\n3) Reporte de asignacion de profesores"
                + "\n4) Reporte general de cursos"
                + "\n5) Reporte de un curso en especifico"
                + "\n6) Reporte de Top de 5 mejores alumnos de un curso \n");
        System.out.println("Ingresar un numero de la lista para seleccionar una opcion" +ANSI_RESET);

        opc = sc1.nextInt();
        try {
            switch (opc){
                case 1:
//                    Reporte_de_alumnos();
                    System.out.println(ANSI_YELLOW + "Se ha realizado el reporte de los alumnos por favor revisa \n"+ANSI_RESET);
                break;
                case 2:
//                    Reporte_de_asignacion_de_alumnos();
                    System.out.println(ANSI_YELLOW + "Se ha realizado el reporte de la Asignacionde los alumnos por favor revisa \n"+ANSI_RESET);
                    break;
                case 3:
//                    Reporte_de_asignacion_de_profesores();
                    System.out.println(ANSI_YELLOW + "Se ha realizado el reporte de la Asignacion de los profesores por favor revisa \n"+ANSI_RESET);
                    break;
                case 4:
//                    Reporte_general_de_cursos();
                    System.out.println(ANSI_YELLOW + "Se ha realizado el reporte General de los cursos por favor revisa \n"+ANSI_RESET);
                    break;
                case 5:
//                    Reporte_de_un_curso_en_especifico();
                    // Aqui se debera de realizar un reporte especial con seleccion del curso
                    break;
                case 6:
//                    Reporte_de_Top_de_5_mejores_alumnos_de_un_curso();
                    // Aqui se debera de realizar un reporte especial con seleccion del curso para despuess seleccionar el top de 5 mas
                    break;
                default:
                    menu_reporte();
            }
        }catch (Exception e){
            System.out.println("Entrada no valida debes de ingresar un entero");
        }

    }

    private static Profesor[] reader_profs() throws IOException {
        System.out.println("Introduzca la ruta del archivo");
        Profesor[] aux = null;
        String linea = "";
        //la dirección del archivo
        //https://www.youtube.com/watch?v=zKDmzKaAQro
        File nuevo = new File(sc.nextLine());
        try {
            FileReader archivo = new FileReader(nuevo);
            BufferedReader buffer = new BufferedReader(archivo);
            String temporal = "";
            while (linea != null) {
                linea = buffer.readLine();
                if (linea != null) {
                    //se almacena todo en un String que contendra los datos crudos
                    temporal += linea;
                }
                //se almacena ahora todo eso un vector String que tendra cada fila separada
                String[] filas = temporal.split("\n");
                //el aux tendra tantos objetos como elementos del arreglo de filas
                aux = new Profesor[filas.length];

                for (int i = 0; i < filas.length; i++) {
                    /*
                    La posición "i" del arreglo se llenará con su respectivos
                    valores[], valores en posición "i"
                    */
                    String[] valores = filas[i].split(",");
                    aux[i].setId_est(Integer.valueOf(valores[0]));
                    aux[i].setCarnet(Integer.valueOf(valores[1]));
                    aux[i].setNombre(valores[2]);
                    aux[i].setCumple(valores[3]);
                    aux[i].setContrato(valores[4]);
                    aux[i].setGenero(valores[5]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            System.out.println(e.getMessage());
        }
        return aux;
    }
}
