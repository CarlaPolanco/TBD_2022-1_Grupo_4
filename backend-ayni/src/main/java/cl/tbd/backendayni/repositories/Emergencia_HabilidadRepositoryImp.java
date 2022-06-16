package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.Emergencia_Habilidad;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;


@Repository
public class Emergencia_HabilidadRepositoryImp implements Emergencia_HabilidadRepository {
    
    @Autowired
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de emergencias_habilidades
     * @throws Exception si no se puede obtener la cantidad de emergencias_habilidades
     * @see cl.tbd.backendayni.repositories.Emergencia_HabilidadRepository#countEmergenciaHabilidades()
     */ 
    @Override
    public int countEmergenciaHabilidades(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM emergencia_habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.Emergencia_HabilidadRepository#newId()
     */
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM emergencia_habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Emergencia_Habilidad> lista de emergencias_habilidades
     * @throws Exception si no se puede obtener la lista de emergencias_habilidades
     * @see cl.tbd.backendayni.repositories.Emergencia_HabilidadRepository#getAll()
     */
    @Override
    public List<Emergencia_Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia_habilidad ORDER BY emergencia_habilidad.id ASC")
                    .executeAndFetch(Emergencia_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param {@value} int id
     * @return {@value} Emergencia_Habilidad emergencia_habilidad
     * @throws Exception si no se puede obtener la emergencia_habilidad
     * @see cl.tbd.backendayni.repositories.Emergencia_HabilidadRepository#showEmergenciaHabilidadById(long id)
     */
    @Override
    public List<Emergencia_Habilidad> showEmergenciaHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia_habilidad WHERE emergencia_habilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Emergencia_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 

    /**
     * @param {@value} Emergencia_Habilidad emergencia_habilidad
     * @return {@value} Emergencia_Habilidad emergencia_habilidad
     * @throws Exception si no se puede crear la emergencia_habilidad
     * @see cl.tbd.backendayni.repositories.Emergencia_HabilidadRepository#createEmergenciaHabilidad(Emergencia_Habilidad emergenciaHabilidad)
     */
    @Override
    public Emergencia_Habilidad createEmergenciaHabilidad(Emergencia_Habilidad emergencia_habilidad) {
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO emergencia_habilidad(id, id_emergencia, id_habilidad)" + 
        "VALUES (:id2, :id_emergencia2, :id_habilidad2)";

        try{
            conn.createQuery(SQL_INSERT)
                .addParameter("id2", emergencia_habilidad.getId())
                .addParameter("id_emergencia2", emergencia_habilidad.getId_emergencia())
                .addParameter("id_habilidad2", emergencia_habilidad.getId_habilidad())
                .executeUpdate();

            emergencia_habilidad.setId(newId());

            return emergencia_habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergenciaHabilidad\n");
            return null;
        }
    }

    /**
     * @param {@value} Emergencia_Habilidad emergencia_habilidad
     * @return {@value} Emergencia_Habilidad emergencia_habilidad
     * @throws Exception si no se puede actualizar la emergencia_habilidad
     * @see cl.tbd.backendayni.repositories.Emergencia_HabilidadRepository#updateEmergenciaHabilidad(Emergencia_Habilidad emergenciaHabilidad)
     */
    @Override 
    public void deleteEmergenciaHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM emergencia_habilidad WHERE emergencia_habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la emergenciaHabilidad\n");
        }
    }


    @Override
    public void updateEmergenciaHabilidad(Emergencia_Habilidad emergencia_habilidad){
        String SQL_UPDATE = "UPDATE emergencia_habilidad SET id = :id2, id_emergencia = :id_emergencia2, id_habilidad = :id_habilidad2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                .addParameter("id2", emergencia_habilidad.getId())
                .addParameter("id_emergencia2", emergencia_habilidad.getId_emergencia())
                .addParameter("id_habilidad2", emergencia_habilidad.getId_habilidad())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la emergenciaHabilidad\n");
        }
    }
}
