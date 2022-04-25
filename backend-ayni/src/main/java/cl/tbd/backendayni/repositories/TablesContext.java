package cl.tbd.backendayni.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class TablesContext {
    private Connection con;

    public TablesContext(Connection con){
        this.con = con;
    }
    public void crearTablas(){
        try{
            con.createQuery("create table emergencia" + "(id serial primary key, nombre text, descripcion text, fecha date, longitud NUMERIC(10,8), latitud NUMERIC(10,8)) ").executeUpdate();
            con.createQuery("create table estado" + "(id serial primary key, nombre text) ").executeUpdate();
            con.createQuery("create table emergenciaHabilidad" + "(id serial primary key, idEmergencia serial, idHabilidad serial) ").executeUpdate();
            con.createQuery("create table estadotarea" + "(id serial primary key, idEstado serial, idTarea serial) ").executeUpdate();
            con.createQuery("create table habilidad" + "(id serial primary key, habilidad text) ").executeUpdate();
            con.createQuery("create table institucion" + "(id serial primary key, nombre text, correo text, numero text) ").executeUpdate();
            con.createQuery("create table ranking" + "(id serial primary key, porcentajeRanking real, idTarea serial, idVoluntario serial) ").executeUpdate();
            con.createQuery("create table tarea" + "(id serial primary key, nombre text, descripcion text, fecha date, longitud NUMERIC(10,8), latitud NUMERIC(10,8)) ").executeUpdate();
            con.createQuery("create table tareaHabilidad" + "(id serial primary key, idTarea serial, idHabilidad serial) ").executeUpdate();
            con.createQuery("create table voluntario" + "(id serial primary key, correo text, nombreUsuario text, contrasena text, atributos text) ").executeUpdate();
            con.createQuery("create table voluntarioHabilidad" + "(id serial primary key, idVoluntario serial, idHabilidad serial) ").executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
