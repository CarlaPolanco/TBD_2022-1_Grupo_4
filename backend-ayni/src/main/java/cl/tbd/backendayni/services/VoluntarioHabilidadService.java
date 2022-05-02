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

import cl.tbd.backendayni.models.VoluntarioHabilidad;
import cl.tbd.backendayni.repositories.VoluntarioHabilidadRepository;

@RestController
public class VoluntarioHabilidadService {
    
    private final VoluntarioHabilidadRepository voluntarioHabilidadRepository;

    VoluntarioHabilidadService(VoluntarioHabilidadRepository voluntarioHabilidadRepository){
        this.voluntarioHabilidadRepository = voluntarioHabilidadRepository;
    }

    @GetMapping("/voluntariohabilidad")
    public List<VoluntarioHabilidad> getAll(){
        return voluntarioHabilidadRepository.getAll();
    }

    @PostMapping("/voluntariohabilidad/create")
    @ResponseBody
    public VoluntarioHabilidad createVoluntarioHabilidad(@RequestBody VoluntarioHabilidad voluntariohabilidad){
        VoluntarioHabilidad newVoluntarioHabilidad = voluntarioHabilidadRepository.createVoluntarioHabilidad(voluntariohabilidad);
        return newVoluntarioHabilidad;
    }

    @RequestMapping(value = "/voluntariohabilidad/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteVoluntarioHabilidad(@PathVariable long id){
        voluntarioHabilidadRepository.deleteVoluntarioHabilidadById(id);
    }

}
