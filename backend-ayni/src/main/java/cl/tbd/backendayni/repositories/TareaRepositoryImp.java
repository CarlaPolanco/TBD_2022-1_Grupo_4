package cl.tbd.backendayni.repositories;

import org.springframework.stereotype.Repository;
import cl.tbd.backendayni.models.Tarea;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;


@Repository
public class TareaRepositoryImp implements TareaRepository {

    @Autowired(required = false)
    private Sql2o sql2o;

    @Override
    public int countTareas(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }
    

    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tarea";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }


    @Override
    public List<Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea ORDER BY tarea.id ASC")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> getAllTareasEmergency(long id)
    {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT DISTINCT tFinal.id, tFinal.nombre,tFinal.descripcion,tFinal.fecha,tFinal.requerimientos FROM (SELECT tHT.id_tarea as id, tHT.nombre, tHT.descripcion, tHT.fecha, tHT.requerimientos FROM (SELECT t1.id as id_tarea, t1.nombre, t1.descripcion, t1.fecha, t1.requerimientos, t3.id FROM tarea t1, tareahabilidad t2, habilidad t3 WHERE t1.id = t2.idtarea AND t3.id = t2.idhabilidad) tHT INNER JOIN(SELECT t6.id as id_habilidad, t4.id as id_emergencia FROM emergencia t4, emergenciahabilidad t5, habilidad t6 WHERE t4.id = t5.idemergencia AND t6.id = t5.idhabilidad) tHE ON  tHT.id_tarea =tHE.id_habilidad AND tHE.id_emergencia = :id) tFinal; ")
                .addParameter("id", id)
                .executeAndFetch(Tarea.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> showTareaById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea WHERE tarea.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Tarea createTarea(Tarea tarea){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO tarea(nombre, descripcion, fecha, requerimientos)" + 
        "VALUES (:nombre2, :descripcion2, :fecha2, :requerimientos2)";

        try{
            conn.createQuery(SQL_INSERT)
                .addParameter("nombre2", tarea.getNombre())
                .addParameter("descripcion2", tarea.getDescripcion())
                .addParameter("fecha2", tarea.getFecha())
                .addParameter("requerimientos2", tarea.getRequerimientos())
                .executeUpdate();

            tarea.setId(newId());

            return tarea;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }


    @Override 
    public void deleteTareaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM tarea WHERE tarea.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la tarea\n");
        }
    }


    @Override
    public void updateTarea(Tarea tarea){

        String SQL_UPDATE = "UPDATE tarea SET nombre = :nombre2, descripcion = :descripcion2, fecha = :fecha2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("nombre2", tarea.getNombre())
                .addParameter("descripcion2", tarea.getDescripcion())
                .addParameter("fecha2", tarea.getFecha())
                .addParameter("id2", tarea.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la tarea\n");
        }
    }
}
