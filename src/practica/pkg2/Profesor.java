package practica.pkg2;

import java.util.Date;

/**
 * @author Dell
 */
public class Profesor {
    int id_est;
    int carnet;
    String nombre;
    String cumple;
    String contrato;
    String genero;

    public Profesor(int id_est, int carnet, String nombre, String cumple, String contrato, String genero) {
        this.id_est = id_est;
        this.carnet = carnet;
        this.nombre = nombre;
        this.cumple = cumple;
        this.contrato = contrato;
        this.genero = genero;
    }

    public Profesor() {

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

    public void setContrato(String contraro) {
        this.contrato = contrato;
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

    public int[] contratoSlice() {
        int[] return_array;
        return_array = new int[3];
        String[] aux = contrato.split("/", 3);
        return_array[0] = Integer.valueOf(aux[0]);
        return_array[1] = Integer.valueOf(aux[1]);
        return_array[2] = Integer.valueOf(aux[2]);
        return return_array;
    }
}
