package cl.tbd.backendayni.services;

import java.util.List;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.Voluntario;
import cl.tbd.backendayni.models.RankingVoluntario;
import cl.tbd.backendayni.repositories.RankingRepository;


@RestController
public class RankingService {
    private final RankingRepository rankingRepository;

    RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @GetMapping("/ranking")
    public List<Ranking> getAll() {
        return rankingRepository.getAll();
    }

    @PostMapping("/ranking/create")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking newRanking = rankingRepository.createRanking(ranking);
        rankingRepository.addNumberToRanking(newRanking);
        return newRanking;
    }

    @GetMapping("/ranking/count")
    public String countRanking(){
        int total = rankingRepository.countAllRanks();
        return String.format("Se tienen %s rankings.", total);
    }

    @RequestMapping(value = "/ranking/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteRanking(@PathVariable long id) {
        rankingRepository.deleteRankingById(id);
    }

    @RequestMapping(value = "/ranking/updateById/{id}", method = RequestMethod.PUT)
    public void updateRanking(@RequestBody Ranking ranking) {
        rankingRepository.updateRanking(ranking);
        rankingRepository.addNumberToRanking(ranking);
    }

    @RequestMapping(value = "/ranking/getById/{id}", method = RequestMethod.GET)
    public List<Ranking> getRankingById(@PathVariable long id) {
        return rankingRepository.showRankingById(id);
    }  

    @RequestMapping(value = "/ranking/getByIdtarea/{id}", method = RequestMethod.GET)
    public List<Ranking> getRankingByIdtarea(@PathVariable long id) {
        return rankingRepository.getAllByTarea(id);
    } 

    @RequestMapping(value = "/ranking/getVoluntarioById/{id}", method = RequestMethod.GET)
    public List<RankingVoluntario> getAllVoluntariosByRanking(@PathVariable long id){
        return rankingRepository.getAllVoluntariosByRanking(id);
    }

    @PostMapping("/ranking/create/{id1}/{id2}")
    public Ranking createPercent(@PathVariable long id1,@PathVariable long id2){
        Ranking newRanking = rankingRepository.createPercent(id1,id2);
        return newRanking;
    }



}
