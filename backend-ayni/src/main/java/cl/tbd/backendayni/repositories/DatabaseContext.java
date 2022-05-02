package cl.tbd.backendayni.repositories;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

@Configuration
public class DatabaseContext {
    static Sql2o base;
    @Bean
    public static Sql2o sql2o(){
        //Carlos,Bastian,Felipe,Carla,Estefania,Sora
        String[] usuarios = new String[] {"postgres", "postgres", "postgres","postgres","postgres","postgres","postgres"};
        String[] contraseñas = new String[] {"default", "2701", "Fcii5944","Julian233","3144","contra6","abcdef1234"};
        int i;

        //Esto se debe cambiar acorde a la base de datos y las credenciales
        for(i=0;i<7;i++){
            //Sql2o base = new Sql2o("jdbc:postgresql://localhost:5432/aynidatabase",usuarios[i],contraseñas[i]);
            try{
                Sql2o base = new Sql2o("jdbc:postgresql://localhost:5432/aynidatabase",usuarios[i],contraseñas[i]);
                Connection con = base.open();
                return base;

            }
            catch(Sql2oException e){
                if(i>=7){
                    System.out.println("Por favor enciende la base de datos o valida tus credenciales");
                  }
            }
        }
        for(i=0;i<7;i++){
            try{
                Sql2o base = new Sql2o("jdbc:postgresql://localhost:5432/",usuarios[i],contraseñas[i]);
                String sql = "CREATE DATABASE AYNIDATABASE";
                Connection con = base.open();
                con.createQuery(sql).executeUpdate();
                System.out.println("Se esta creando la base de datos");
                base = new Sql2o("jdbc:postgresql://localhost:5432/aynidatabase",usuarios[i],contraseñas[i]);
                con = base.open();
                TablesContext tablas = new TablesContext(con);
                tablas.crearTablas();
            }catch(Sql2oException e){
                System.out.println("Se esta creando la base de datos");
            }
        }
        return base;
    }
}
