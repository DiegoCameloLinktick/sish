package co.com.acueducto.sish.controllers;

import java.util.ArrayList;
import java.util.Optional;

import co.com.acueducto.sish.models.DominioModel;
import co.com.acueducto.sish.services.DominioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dominio")
public class DominioController {
    @Autowired
    DominioService dominioService;

    @GetMapping()
    public ArrayList<DominioModel> obtenerDominios(){
        return dominioService.obtenerDominios();
    }

    @PostMapping()
    public DominioModel guardarDominio(@RequestBody DominioModel dominio){
        return this.dominioService.guardarDominio(dominio);
    }

    @GetMapping( path = "/{id}")
    public Optional<DominioModel> obtenerDominioPorId(@PathVariable("id") Long id) {
        return this.dominioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<DominioModel> obtenerDominioPorDominio(@RequestParam("dominio") String dominio){
        return this.dominioService.obtenerPorDominio(dominio);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.dominioService.eliminarDominio(id);
        if (ok){
            return "Se eliminó el dominio con id " + id;
        }else{
            return "No pudo eliminar el dominio con id" + id;
        }
    }

}