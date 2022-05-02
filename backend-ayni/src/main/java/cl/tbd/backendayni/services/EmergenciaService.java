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
import cl.tbd.backendayni.models.Emergencia;
import cl.tbd.backendayni.repositories.EmergenciaRepository;


@RestController
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencia")
    public List<Emergencia> getAll() {
        return emergenciaRepository.getAll();
    }

    @PostMapping("/emergencia/create")
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        Emergencia newEmergencia = emergenciaRepository.createEmergencia(emergencia);
        return newEmergencia;
    }

    @GetMapping("/emergencia/count")
    public String countEmergencia(){
        int total = emergenciaRepository.countEmergencias();
        return String.format("Se tienen %s emergencias.", total);
    }

    @RequestMapping(value = "/emergencia/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteEmergencia(@PathVariable long id) {
        emergenciaRepository.deleteEmergenciaById(id);
    }

    @RequestMapping(value = "/emergencia/updateById/{id}", method = RequestMethod.PUT)
    public void updateEmergencia(@RequestBody Emergencia emergencia) {
        emergenciaRepository.updateEmergencia(emergencia);
    }

    @RequestMapping(value = "/emergencia/getById/{id}", method = RequestMethod.GET)
    public List<Emergencia> getEmergenciaById(@PathVariable long id) {
        return emergenciaRepository.showEmergenciaById(id);
    }    
}
