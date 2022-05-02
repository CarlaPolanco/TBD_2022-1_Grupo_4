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
import cl.tbd.backendayni.models.Habilidad;
import cl.tbd.backendayni.repositories.HabilidadRepository;


@RestController
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;

    HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    @GetMapping("/habilidad")
    public List<Habilidad> getAll() {
        return habilidadRepository.getAll();
    }

    @PostMapping("/habilidad/create")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        Habilidad newHabilidad = habilidadRepository.createHabilidad(habilidad);
        return newHabilidad;
    }

    @GetMapping("/habilidad/count")
    public String countHabilidad(){
        int total = habilidadRepository.countHabilidades();
        return String.format("Se tienen %s habilidades.", total);
    }

    @RequestMapping(value = "/habilidad/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteHabilidad(@PathVariable long id) {
        habilidadRepository.deleteHabilidadById(id);
    }

    @RequestMapping(value = "/habilidad/updateById/{id}", method = RequestMethod.PUT)
    public void updateHabilidad(@RequestBody Habilidad habilidad) {
        habilidadRepository.updateHabilidad(habilidad);
    }

    @RequestMapping(value = "/habilidad/getById/{id}", method = RequestMethod.GET)
    public List<Habilidad> getHabilidadById(@PathVariable long id) {
        return habilidadRepository.showHabilidadById(id);
    }
}
