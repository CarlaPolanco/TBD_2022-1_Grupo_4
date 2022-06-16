package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.Ranking_Voluntario;

/* import cl.tbd.backendayni.models.RankingVoluntario;
import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.TareaHabilidad;
import cl.tbd.backendayni.models.VoluntarioHabilidad;
import cl.tbd.backendayni.models.Voluntario;
*/
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    
    @Autowired
    private Sql2o sql2o;

    /**
     * @param ranking {@value} Ranking ranking a crear
     * @return {@value} Ranking ranking creado
     * @throws Exception si no se puede crear el ranking
     * @see cl.tbd.backendayni.repositories.RankingRepository#createRanking(cl.tbd.backendayni.models.Ranking)
     */
    @Override
    public Ranking createRanking(Ranking ranking){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO ranking(porcentaje, id_tarea, id_voluntario)" + 
        "VALUES (:porcentaje, :id_tarea2, :id_voluntario2)";

        try{
            conn.createQuery(SQL_INSERT)
                .addParameter("porcentaje", ranking.getPorcentaje())
                .addParameter("id_tarea2", ranking.getId_tarea())
                .addParameter("id_voluntario2", ranking.getId_voluntario())
                .executeUpdate();

            ranking.setId(newID());

            return ranking;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el ranking\n");
            return null;
        }
    }

    /**
     * @return {@value} int cantidad de rankings
     * @throws Exception si no se puede obtener la cantidad de rankings
     * @see cl.tbd.backendayni.repositories.RankingRepository#countRankings()
     */
    @Override
    public int countAllRanks() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM ranking";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.RankingRepository#newId()
     */
    @Override
    public int newID() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM ranking";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Ranking> todos los rankings
     * @throws Exception si no se puede obtener los rankings
     * @see cl.tbd.backendayni.repositories.RankingRepository#getAll()
     * @see cl.tbd.backendayni.models.Ranking
     */
    @Override
    public List<Ranking> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM ranking ORDER BY Ranking.id ASC")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param id {@value} long id del ranking a obtener
     * @return {@value} List<Ranking> ranking obtenido
     * @throws Exception si no se puede obtener el ranking
     * @see cl.tbd.backendayni.repositories.RankingRepository#showRankingById(long)
     */
    @Override
    public List<Ranking> showRankingById(long id) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM ranking WHERE ranking.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param ranking {@value} Ranking ranking a eliminar
     * @throws Exception si no se puede eliminar el ranking
     * @see cl.tbd.backendayni.repositories.RankingRepository#deleteRanking(cl.tbd.backendayni.models.Ranking)
     */
    @Override
    public void deleteRankingById(long id) {
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM ranking WHERE ranking.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el Ranking\n");
        }
    }

    /**
     * @param ranking {@value} Ranking ranking a actualizar
     * @return {@value} Ranking ranking actualizado
     * @throws Exception si no se puede actualizar el ranking
     * @see cl.tbd.backendayni.repositories.RankingRepository#updateRanking(cl.tbd.backendayni.models.Ranking)
     */
    @Override
    public void updateRanking(Ranking ranking) {
        String SQL_UPDATE = "UPDATE ranking SET porcentaje = :porcentaje2, id_voluntario = :id_voluntario2, id_tarea = :id_tarea2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("porcentaje2", ranking.getPorcentaje())
                .addParameter("id_voluntario2", ranking.getId_voluntario())
                .addParameter("id_tarea2", ranking.getId_tarea())
                .addParameter("id2", ranking.getId())
                .executeUpdate();
                
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el Ranking\n");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////

    //COMPLEMENTARIOS

    @Override
    public List<Ranking_Voluntario> getRankingByIdTarea(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT t1.id_voluntario, t1.porcentaje, t2.usuario FROM ranking t1, voluntario t2 WHERE t1.id_tarea = :id AND t1.id_voluntario = t2.id AND t1.porcentaje > 0 ORDER BY t1.porcentaje DESC;")
                    .addParameter("id", id)
                    .executeAndFetch(Ranking_Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /* 
    @Override
    public void createRankingByIdTarea(long id){
         
        int total = 0;
        String sql = "SELECT COUNT(*) FROM ranking";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }

        int total_habilidades_tarea = 0;
        
        String SQL_TOTAL_HT = "SELECT COUNT(*) FROM tarea_habilidad WHERE id_tarea = :id";
        SELECT COUNT(*)*1.0 FROM tarea_habilidad WHERE id_tarea = 1;
        --SELECT t1.id_tarea,t2.id_voluntario, COUNT(t2.id_voluntario) FROM tarea_habilidad t1, voluntario_habilidad t2 WHERE t1.id_tarea = 1 AND t1.id_habilidad = t2.id_habilidad
        --GROUP BY t2.id_voluntario, t1.id_tarea; 

        SELECT ROUND(COUNT(t2.id_voluntario)/(SELECT COUNT(*)*1.0 FROM tarea_habilidad WHERE id_tarea = 1)*100), t1.id_tarea,t2.id_voluntario  FROM tarea_habilidad t1, voluntario_habilidad t2 WHERE t1.id_tarea = 1 AND t1.id_habilidad = t2.id_habilidad
        GROUP BY t2.id_voluntario, t1.id_tarea; 
    }*/
}
