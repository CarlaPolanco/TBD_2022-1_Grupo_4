package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.Estado;
import cl.tbd.backendayni.models.EstadoTarea;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
public class EstadoTareaRepositoryImp implements EstadoTareaRepository{
    @Autowired(required = false)
    private Sql2o sql2o;

    @Override
    public int countEstadosTarea(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM estadotarea";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM estadotarea";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }

    @Override
    public List<EstadoTarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estadotarea ORDER BY estadotarea.id ASC")
                    .executeAndFetch(EstadoTarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EstadoTarea> showEstadoTareaById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estadotarea WHERE estadotarea.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(EstadoTarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    
    @Override
    public EstadoTarea createEstadoTarea(EstadoTarea estadotarea){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO estadotarea(id, idestado, idtarea)" + 
                            "VALUES(:id2, :idestado2, :idtarea2)";

        try{

            conn.createQuery(SQL_INSERT)
                .addParameter("id2", estadotarea.getIdTabla())
                .addParameter("idestado2", estadotarea.getIdEstado())
                .addParameter("idtarea2", estadotarea.getIdTarea())
                .executeUpdate();

            estadotarea.setIdTabla(newId());

            return estadotarea;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear estadotarea\n");
            return null;
        }
    }


    @Override 
    public void deleteEstadoTareaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM estadotarea WHERE estadotarea.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el estadotarea\n");
        }
    }

    @Override
    public void updateEstadoTarea(EstadoTarea estadotarea){

        String SQL_UPDATE = "UPDATE estadotarea SET id = :id2, idestado = idestado2, idtarea = idtarea2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("idestado2", estadotarea.getIdEstado())
                .addParameter("idtarea2", estadotarea.getIdTarea())
                .addParameter("id2", estadotarea.getIdTabla())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el estadotarea\n");
        }
    } 
}
