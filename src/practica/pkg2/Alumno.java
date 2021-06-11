package practica.pkg2;

import java.util.Date;

public class Alumno {

    int id_est;
    int carnet;
    String nombre;
    String cumple;    
    String genero;

    public Alumno(int id_est, int carnet, String nombre, String fecha, String genero) {
        this.id_est = id_est;
        this.carnet = carnet;
        this.nombre = nombre;
        this.cumple = fecha;
        this.genero = genero;
    }

    public Alumno() {
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public int getId_est() {
        return id_est;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCumple() {
        return cumple;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int[] cumpleSlice() {
        int[] return_array;
        return_array = new int[3];
        String[] aux = cumple.split("/", 3);
        return_array[0] = Integer.valueOf(aux[0]);
        return_array[1] = Integer.valueOf(aux[1]);
        return_array[2] = Integer.valueOf(aux[2]);
        return return_array;
    }
}
