package practica.pkg2;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class Alumno {

    int id_est;
    int carnet;
    String nombre;
    Date cumple;    
    boolean genero;

    public Alumno(int id_est, int carnet, String nombre, Date fecha, boolean genero) {
        this.id_est = id_est;
        this.carnet = carnet;
        this.nombre = nombre;
        this.cumple = fecha;
        this.genero = genero;
    }

}
