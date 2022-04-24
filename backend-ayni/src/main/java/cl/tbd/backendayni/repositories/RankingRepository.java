package cl.tbd.backendayni.repositories;

import java.util.ArrayList;
import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.Voluntario;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;

public interface RankingRepository {

    public int countAllRanks();
    public int newID();
    public ArrayList<Ranking> getAll();
    public ArrayList<Ranking> FilterByRanking(float min, float max);
    public List<Ranking> showRankingById(long id);
    public void deleteVoluntarioById(long id);
    public void updateVoluntarioById(Voluntario voluntario);
    
}
