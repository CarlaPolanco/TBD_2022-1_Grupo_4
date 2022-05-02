package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.Voluntario;
import cl.tbd.backendayni.models.Habilidad;
import cl.tbd.backendayni.models.VoluntarioHabilidad;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;

@Repository
public class VoluntarioHabilidadRepositoryImp implements VoluntarioHabilidadRepository {
    
    @Autowired(required = false)
    private Sql2o sql2o;

    @Override
    public int countVoluntariosHabilidad(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM voluntariohabilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM voluntariohabilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }

    @Override
    public List<VoluntarioHabilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntariohabilidad ORDER BY voluntariohabilidad.id ASC")
                    .executeAndFetch(VoluntarioHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioHabilidad> showVoluntarioHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntariohabilidad WHERE voluntariohabilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(VoluntarioHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    
    @Override
    public VoluntarioHabilidad createVoluntarioHabilidad(VoluntarioHabilidad voluntariohabilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO voluntariohabiliad(id, idvoluntario, idhabilidad)" + 
                            "VALUES(:id2, :idvoluntario2, :idhabilidad2)";

        try{

            conn.createQuery(SQL_INSERT)
                .addParameter("id2", voluntariohabilidad.getId_voluntario_habilidad())
                .addParameter("idvoluntario2", voluntariohabilidad.getId_voluntario())
                .addParameter("idhabilidad2", voluntariohabilidad.getId_habilidad())
                .executeUpdate();

            voluntariohabilidad.setId_voluntario_habilidad(newId());

            return voluntariohabilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear voluntariohabilidad\n");
            return null;
        }
    }


    @Override 
    public void deleteVoluntarioHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM voluntariohabilidad WHERE voluntariohabilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el voluntariohabilidad\n");
        }
    }

    @Override
    public void updateVoluntarioHabilidad(VoluntarioHabilidad voluntariohabilidad){

        String SQL_UPDATE = "UPDATE voluntariohabilidad SET id = :id2, idvoluntario = idvoluntario2, idhabilidad = idhabiliadad2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("idvoluntario2", voluntariohabilidad.getId_voluntario())
                .addParameter("idhabilidad2", voluntariohabilidad.getId_habilidad())
                .addParameter("id2", voluntariohabilidad.getId_voluntario_habilidad())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el voluntariohabilidad\n");
        }
    }
    
}
