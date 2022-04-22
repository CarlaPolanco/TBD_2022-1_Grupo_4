package cl.tbd.backendayni.models;

import java.util.*;

public class Emergencia {
    private String nombre;
    private String descripcion;
    private Date fecha;
    private long longitud;
    private long latitud;

    private ArrayList<String> requisitosGrupales;
    private ArrayList<String> requisitosIndividuales;


    public Emergencia(){
    }

    public Emergencia(String nombre, String descripcion, Date fecha, long longitud, long latitud, ArrayList<String> requisitosGrupales, ArrayList<String> requisitosIndividuales) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
        this.requisitosGrupales = requisitosGrupales;
        this.requisitosIndividuales = requisitosIndividuales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    public long getLatitud() {
        return latitud;
    }

    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    public ArrayList<String> getRequisitosGrupales() {
        return requisitosGrupales;
    }

    public void setRequisitosGrupales(ArrayList<String> requisitosGrupales) {
        this.requisitosGrupales = requisitosGrupales;
    }

    public ArrayList<String> getRequisitosIndividuales() {
        return requisitosIndividuales;
    }

    public void setRequisitosIndividuales(ArrayList<String> requisitosIndividuales) {
        this.requisitosIndividuales = requisitosIndividuales;
    }
}
