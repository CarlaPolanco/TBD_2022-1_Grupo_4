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
import cl.tbd.backendayni.models.Institucion;
import cl.tbd.backendayni.repositories.InstitucionRepository;

@RestController
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/institucion")
    public List<Institucion> getAllInstitucions(){
        System.out.println(institucionRepository.getAll());
        return institucionRepository.getAll();
    }


    @GetMapping("/institucion/getById/{id}")
    public List<Institucion> getInstitucionById(@PathVariable long id){
        return institucionRepository.showInstitucionById(id);
    }


    @GetMapping("/institucion/count")
    public String countInstitucion(){
        int total = institucionRepository.countInstituciones();
        return String.format("Se tienen %s instituciones.", total);
    }


    @PostMapping("/institucion/create")
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        Institucion newInstitucion = institucionRepository.createInstitucion(institucion);
        return newInstitucion;
    }
    

    @RequestMapping(value = "/institucion/deleteById/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteInstitucion(@PathVariable long id){
        institucionRepository.deleteInstitucionById(id);
    }

    
    @RequestMapping(value = "/institucion/updateById/{id}", produces = "application/json", method = {RequestMethod.PUT})
    public void updateInstitucion(@RequestBody Institucion institucion){
        institucionRepository.updateInstitucion(institucion);
    }    
}
