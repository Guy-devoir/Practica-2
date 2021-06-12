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
                System.out.println("Menu principal"
                        + "\n1)Cargar Alumnos"
                        + "\n2)Cargar Profesores"
                        + "\n3)Cargar Cursos"
                        + "\n4)Asignar alumnos"
                        + "\n5)Asignar profesores"
                        + "\n6)Cargar Notas"
                        + "\n7)Crear usuario"
                        + "\n8)Cerrar Sesión");
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

        //variables auxiliares
        int id, carnet;
        String nombre, cumple, genero;
        //la dirección del archivo
        //https://www.youtube.com/watch?v=zKDmzKaAQro
        Alumno[] aux = null;

        try {
            System.out.println("Introduzca la ruta del archivo: ");
            File csv = new File(sc.nextLine());
            Scanner reader = new Scanner(System.in); //lector para mi archivo
            String linea = "";
            reader.nextLine();//ignorar la primera linea del csv

            while (reader.hasNextLine()) {
                linea += reader.nextLine() + "\n";
            }

            String filas[] = linea.split("\n"); //metemos las lineas de los archivos en un array
            int filasAlumno = filas.length; //Aquí para verificar cuantos pokemons estamos ingresando
            String columnas[] = linea.split(","); //metemos todos los campos de las lineas en un array
            int columnasAlumno = columnas.length; //Verificamos cuantas columnas tiene el archivo

            for (int i = 0; i < filasAlumno; i++) { //con este for pasamos los parámetros a al constructor de la clase Alumno
                columnas = filas[i].split(",");

                /*Aqui casteamos todos los valores strings a sus respectivos valores para poder realizar
                las respectivas operaciones*/
                id = Integer.parseInt(columnas[0]);
                carnet = Integer.parseInt(columnas[1]);
                nombre = columnas[2];
                cumple = columnas[3];
                genero = columnas[4];

                //Aquí ya instanciamos todos objetos de mi clase Alumno
                aux[i] = new Alumno(id, carnet, nombre, cumple, genero);

            }

        } catch (Exception e) {
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
        System.out.println("Menu de reportes"
                + "\n1)Generar Reportes"
                + "\n2)Cerrar Sesión");
        
        try{
        switch(opc = sc1.nextInt()){
            case 1:
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

    private static Profesor[] reader_profs() throws IOException {
        System.out.println("Introduzca la ruta del archivo");
        Profesor[] aux = null;
        String linea = "";
        //la dirección del archivo
        File nuevo = new File(sc.nextLine());
        try {
            FileReader archivo = new FileReader(nuevo);
            BufferedReader buffer = new BufferedReader(archivo);
            String temporal = "";
            while (linea != null) {
                linea = buffer.readLine();
                    //se almacena todo en un String que contendra los datos crudos
                    temporal += linea;
                
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
    
    private static Curso[] reador_curso() throws IOException{
    System.out.println("Introduzca la ruta del archivo");
        Curso[] aux = null;
        String linea = "";
        //la dirección del archivo
        File nuevo = new File(sc.nextLine());
        try {
            FileReader archivo = new FileReader(nuevo);
            BufferedReader buffer = new BufferedReader(archivo);
            String temporal = "";
            while (linea != null) {
                linea = buffer.readLine();
                    //se almacena todo en un String que contendra los datos crudos
                    temporal += linea;
                
                //se almacena ahora todo eso un vector String que tendra cada fila separada
                String[] filas = temporal.split("\n");
                //el aux tendra tantos objetos como elementos del arreglo de filas
                aux = new Curso[filas.length];

                for (int i = 0; i < filas.length; i++) {
                    /*
                    La posición "i" del arreglo se llenará con su respectivos
                    valores[], valores en posición "i"
                    */
                    String[] valores = filas[i].split(",");
                    aux[i].setId_clase(Integer.valueOf(valores[0]));
                    aux[i].setCodigo(Integer.valueOf(valores[1]));
                    aux[i].setNombre(valores[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            System.out.println(e.getMessage());
        }
        return aux;
    }
}
