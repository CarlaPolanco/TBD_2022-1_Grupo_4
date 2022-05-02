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

import cl.tbd.backendayni.models.TareaHabilidad;
import cl.tbd.backendayni.repositories.TareaHabilidadRepository;

@RestController
public class TareaHabilidadService {
    
    private final TareaHabilidadRepository tareahabilidadRepository;

    TareaHabilidadService(TareaHabilidadRepository tareahabilidadRepository){
        this.tareahabilidadRepository = tareahabilidadRepository;
    }

    @GetMapping("/tareahabilidad")
    public List<TareaHabilidad> getAll(){
        return tareahabilidadRepository.getAll();
    }

    @PostMapping("/tareahabilidad/create")
    @ResponseBody
    public TareaHabilidad createTareaHabilidad(@RequestBody TareaHabilidad tareahabilidad){
        TareaHabilidad newTareaHabilidad = tareahabilidadRepository.createTareaHabilidad(tareahabilidad);
        return newTareaHabilidad;
    }


    @RequestMapping(value = "/tareahabilidad/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteTareaHabilidad(@PathVariable long id)
    {
        tareahabilidadRepository.deleteTareaHabilidadById(id);
    }
}
