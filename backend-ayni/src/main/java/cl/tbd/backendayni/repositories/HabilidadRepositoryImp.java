package cl.tbd.backendayni.repositories;


import org.springframework.stereotype.Repository;
import cl.tbd.backendayni.models.Habilidad;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class HabilidadRepositoryImp implements HabilidadRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countHabilidades(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }


    @Override
    public List<Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad ORDER BY habilidad.id ASC")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    

    @Override
    public List<Habilidad> showHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad WHERE habilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Habilidad createHabilidad(Habilidad habilidad){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO habilidad(habilidad)" + "VALUES (:habilidad2)";

        try{
            conn.createQuery(SQL_INSERT,true)
                .addParameter("habilidad2", habilidad.getHabilidad())
                .executeUpdate();
            habilidad.setId(newId());
            return habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la habilidad\n");
            return null;
        }

    }


    @Override 
    public void deleteHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM habilidad WHERE habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la habilidad\n");
        }
    }


    @Override
    public void updateHabilidad(Habilidad habilidad){

        String SQL_UPDATE = "UPDATE habilidad SET habilidad = :habilidad2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("habilidad2", habilidad.getHabilidad())
                .addParameter("id2", habilidad.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la habilidad\n");
        }
    }
}
