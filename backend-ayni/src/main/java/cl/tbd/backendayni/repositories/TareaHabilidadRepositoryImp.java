package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.TareaHabilidad;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;

@Repository
public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository{
    
    @Autowired(required = false)
    private Sql2o sql2o;

    @Override
    public int countTareasHabilidad(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tareahabilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tareahabilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }

    @Override
    public List<TareaHabilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tareahabilidad ORDER BY tareahabilidad.id ASC")
                    .executeAndFetch(TareaHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaHabilidad> showTareaHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tareahabilidad WHERE tareahabilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(TareaHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    
    @Override
    public TareaHabilidad createTareaHabilidad(TareaHabilidad tareahabilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO tareahabilidad(idtarea, idhabilidad)" + 
                            "VALUES(:idtarea2, :idhabilidad2)";

        try{

            conn.createQuery(SQL_INSERT,true)
                .addParameter("idtarea2", tareahabilidad.getIdTarea())
                .addParameter("idhabilidad2", tareahabilidad.getIdHabilidad())
                .executeUpdate();


            tareahabilidad.setIdTabla(newId());

            return tareahabilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear tareahabilidad\n");
            return null;
        }
    }


    @Override 
    public void deleteTareaHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM tareahabilidad WHERE tareahabilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el tareahabilidad\n");
        }
    }

    @Override
    public void updateTareaHabilidad(TareaHabilidad tareahabilidad){

        String SQL_UPDATE = "UPDATE tareahabilidad SET id = :id2, idtarea = idtarea2, idhabilidad = idhabiliadad2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("idtarea2", tareahabilidad.getIdTarea())
                .addParameter("idhabilidad2", tareahabilidad.getIdHabilidad())
                .addParameter("id2", tareahabilidad.getIdTabla())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el tareahabilidad\n");
        }
    }

}
