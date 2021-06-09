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
                System.err.println("Menu principal"
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
                        try{
                        reader_alumni();
                        }catch(IOException e){
                            System.out.println("Proceso de carga de alumnas fallida");
                        }
                        break;

                    case 2:
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
                Menu();
            }
            if (user.equals(users[1].getNombre()) && pass.equals(users[1].getCont())) {
                Menu();
            }
            if (user.equals(users[2].getNombre()) && pass.equals(users[2].getCont())) {
                Menu();
            }
            if (user.equals(users[3].getNombre()) && pass.equals(users[3].getCont())) {
                Menu();
            }
            if (user.equals(users[4].getNombre()) && pass.equals(users[4].getCont())) {
                Menu();
            }
        } catch (Exception e) {
            System.out.println("Usuario no valido");
            System.exit(0);
        }}
 
    //Todabía es muy primitivo... cargar alumnos
    private static void reader_alumni() throws IOException {
        try{
            String linea = "";
        BufferedReader br = new BufferedReader(new FileReader("a.csv"));
        String headerLine = "";
        headerLine = br.readLine();
        while((linea = br.readLine()) != null){
        String[] data = linea.split(",");
        //5 valores
        }
        }catch(FileNotFoundException e){
            System.out.println("Error: Carga del archivo fallida");
        }
    }
}
