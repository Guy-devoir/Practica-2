package practica.pkg2;

import java.util.Date;

/**
 * @author Dell
 */
public class Profesor {
    int id_est;
    int carnet;
    String nombre;
    Date cumple;
    Date contraro;
    boolean genero;

    public Profesor(int id_est, int carnet, String nombre, Date cumple, Date contraro, boolean genero) {
        this.id_est = id_est;
        this.carnet = carnet;
        this.nombre = nombre;
        this.cumple = cumple;
        this.contraro = contraro;
        this.genero = genero;
    }
    
    
}
