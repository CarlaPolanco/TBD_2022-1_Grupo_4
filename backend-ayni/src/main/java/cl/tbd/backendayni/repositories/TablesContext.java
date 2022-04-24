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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
