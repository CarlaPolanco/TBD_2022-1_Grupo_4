package cl.tbd.backendayni.repositories;

import java.util.ArrayList;
import java.util.List;
import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.RankingVoluntario;
import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.TareaHabilidad;
import cl.tbd.backendayni.models.VoluntarioHabilidad;
import cl.tbd.backendayni.models.Voluntario;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public Ranking createRanking(Ranking ranking){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO ranking(idTarea, idVoluntario)" + 
        "VALUES (:idTarea2, :idVoluntario2)";

        try{
            conn.createQuery(SQL_INSERT)
                .addParameter("idTarea2", ranking.getIdTarea())
                .addParameter("idVoluntario2", ranking.getIdVoluntario())
                .executeUpdate();

            ranking.setId(newID());

            return ranking;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el ranking\n");
            return null;
        }
    }
    @Override
    public int countAllRanks() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM ranking";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    @Override
    public int newID() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM ranking";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }

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

    @Override
    public void updateRanking(Ranking ranking) {
        String SQL_UPDATE = "UPDATE ranking SET idVoluntario = :idVoluntario2, idTarea = :idTarea2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("idTarea2", ranking.getIdTarea())
                .addParameter("idVoluntario2", ranking.getIdVoluntario())
                .addParameter("id2", ranking.getId())
                .executeUpdate();
                
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el Ranking\n");
        }
    }
    @Override
    public void addNumberToRanking(Ranking ranking){
        List<TareaHabilidad> listaTH = new ArrayList<TareaHabilidad>();
        List<VoluntarioHabilidad> listaVH = new ArrayList<VoluntarioHabilidad>();
        try(Connection conn = sql2o.open()){
            listaTH = conn.createQuery("SELECT * FROM tareahabilidad WHERE tareahabilidad.idtarea = :id")
                    .addParameter("id", ranking.getId())
                    .executeAndFetch(TareaHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try(Connection conn = sql2o.open()){
            listaVH = conn.createQuery("SELECT * FROM voluntariohabilidad WHERE voluntariohabilidad.idvoluntario = :id")
                    .addParameter("id", ranking.getId())
                    .executeAndFetch(VoluntarioHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ranking.generateRankingPercent(listaTH, listaVH);

    }
    
    @Override
    public Ranking createPercent(long id1, long id2)
    {
        int total_HT = 0;
        int total_HV = 0;
        int idmaxRanking = 0;
        float porcentaje = (float)0.0;
        String SQL_COUNT1 = "SELECT COUNT(*) FROM tarea t1, tareahabilidad t2, habilidad t3 WHERE t1.id = t2.idtarea AND t3.id = t2.idhabilidad AND t1.id = :id0;";
        String SQL_COUNT2 = "SELECT COUNT(*) FROM (SELECT t3.habilidad, t1.id FROM tarea t1, tareahabilidad t2, habilidad t3 WHERE t1.id = t2.idtarea AND t3.id = t2.idhabilidad) tHT INNER JOIN (SELECT t6.habilidad, t4.id FROM voluntario t4, voluntariohabilidad t5, habilidad t6 WHERE t4.id = t5.idvoluntario AND t6.id = t5.idhabilidad) tHV ON tHT.habilidad = tHV.habilidad AND tHT.id = :id1 AND tHV.id = :id2;";
        try(Connection conn = sql2o.open()){
            total_HT = conn.createQuery(SQL_COUNT1)
                .addParameter("id0",id1)
                .executeScalar(Integer.class);
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el Ranking\n");
        }

        try(Connection conn = sql2o.open()){
            total_HV = conn.createQuery(SQL_COUNT2)
                .addParameter("id1",id1)
                .addParameter("id2",id2)
                .executeScalar(Integer.class);
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el Ranking\n");
        }

        if(total_HT>0)
        {
            porcentaje = ((float)total_HV/(float)total_HT)*100;
        }

        String SQL_IDMAX = "SELECT MAX(id) FROM ranking";
        try (Connection conn = sql2o.open()) {
            idmaxRanking  = conn.createQuery(SQL_IDMAX).executeScalar(Integer.class);
        }

        String SQL_INSERT = "INSERT INTO ranking(porcentajeranking, idTarea, idVoluntario)" + 
        "VALUES (:porcentajeranking2, :idTarea2, :idVoluntario2)";

        Ranking newranking = new Ranking(idmaxRanking,porcentaje,id2,id1);

        try(Connection conn = sql2o.open()){
            conn.createQuery(SQL_INSERT)
                .addParameter("porcentajeranking2", newranking.getRanking())
                .addParameter("idTarea2", newranking.getIdTarea())
                .addParameter("idVoluntario2", newranking.getIdVoluntario())
                .executeUpdate();

            newranking.setId(newID());

            return newranking;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el ranking\n");
            return null;
        }

    }

    @Override
    public List<Ranking> getAllByTarea(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM ranking WHERE ranking.idTarea = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingVoluntario> getAllVoluntariosByRanking(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT voluntario.id, voluntario.nombreusuario, ranking.porcentajeranking FROM voluntario, ranking WHERE ranking.idTarea = :id AND ranking.idVoluntario = voluntario.id")
                    .addParameter("id", id)
                    .executeAndFetch(RankingVoluntario.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
