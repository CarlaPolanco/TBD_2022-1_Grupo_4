package cl.tbd.backendayni.repositories;

import java.util.ArrayList;
import cl.tbd.backendayni.models.Ranking;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

public interface RankingRepository {

    public Ranking createRanking(Ranking ranking);
    public int countAllRanks();
    public int newID();
    public List<Ranking> getAll();
    public List<Ranking> showRankingById(long id);
    public void deleteRankingById(long id);
    public void updateRankingById(Ranking ranking);
    
}
