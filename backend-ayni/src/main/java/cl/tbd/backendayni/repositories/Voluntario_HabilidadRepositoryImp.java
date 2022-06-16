package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Voluntario_Habilidad;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;

@Repository
public class Voluntario_HabilidadRepositoryImp implements Voluntario_HabilidadRepository {
    
    @Autowired(required = false)
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de voluntarios
     * @throws Exception si no se puede obtener la cantidad de voluntarios
     * @see cl.tbd.backendayni.repositories.Voluntario_HabilidadRepository#countVoluntarios()
     */
    @Override
    public int countVoluntariosHabilidad(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM voluntario_habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.Voluntario_HabilidadRepository#newId()
     */
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM voluntario_habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<VoluntarioHabilidad> lista de voluntarios
     * @throws Exception si no se puede obtener la lista de voluntarios
     * @see cl.tbd.backendayni.repositories.Voluntario_HabilidadRepository#getAll()
     */
    @Override
    public List<Voluntario_Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario_habilidad ORDER BY voluntario_habilidad.id ASC")
                    .executeAndFetch(Voluntario_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param {@value} int id
     * @return {@value} VoluntarioHabilidad voluntario
     * @throws Exception si no se puede obtener el voluntario
     * @see cl.tbd.backendayni.repositories.Voluntario_HabilidadRepository#getById(int)
     */
    @Override
    public List<Voluntario_Habilidad> showVoluntarioHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario_habilidad WHERE voluntario_habilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Voluntario_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    /**
     * @param {@value} VoluntarioHabilidad voluntario
     * @throws Exception si no se puede guardar el voluntario
     * @see cl.tbd.backendayni.repositories.Voluntario_HabilidadRepository#save(cl.tbd.backendayni.models.Voluntario_Habilidad)
     */
    @Override
    public Voluntario_Habilidad createVoluntarioHabilidad(Voluntario_Habilidad voluntario_habilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO voluntario_habiliad(id, id_voluntario, id_habilidad)" + 
                            "VALUES(:id2, :idvoluntario2, :idhabilidad2)";

        try{

            conn.createQuery(SQL_INSERT)
                .addParameter("id2", voluntario_habilidad.getId())
                .addParameter("id_voluntario2", voluntario_habilidad.getId_voluntario())
                .addParameter("id_habilidad2", voluntario_habilidad.getId_habilidad())
                .executeUpdate();

            voluntario_habilidad.setId(newId());

            return voluntario_habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear voluntariohabilidad\n");
            return null;
        }
    }

    /**
     * @param id {@value} int id del voluntario_habilidad
     * @throws Exception si no se puede eliminar el voluntario_habilidad
     * @see cl.tbd.backendayni.repositories.Voluntario_HabilidadRepository#delete(int) 
     */
    @Override 
    public void deleteVoluntarioHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM voluntario_habilidad WHERE voluntario_habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el voluntariohabilidad\n");
        }
    }

    /**
     * @param {@value} VoluntarioHabilidad voluntario
     * @throws Exception si no se puede actualizar el voluntario
     * @see cl.tbd.backendayni.repositories.Voluntario_HabilidadRepository#update(cl.tbd.backendayni.models.Voluntario_Habilidad)
     */
    @Override
    public void updateVoluntarioHabilidad(Voluntario_Habilidad voluntario_habilidad){

        String SQL_UPDATE = "UPDATE voluntario_habilidad SET id = :id2, id_voluntario = id_voluntario2, id_habilidad = id_habiliadad2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("id_voluntario2", voluntario_habilidad.getId_voluntario())
                .addParameter("id_habilidad2", voluntario_habilidad.getId_habilidad())
                .addParameter("id2", voluntario_habilidad.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el voluntariohabilidad\n");
        }
    }
    
}
