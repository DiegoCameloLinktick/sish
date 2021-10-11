package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.models.configuracion.DominioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Clase de definición del servicio REST de los dominios
 */
@RestController
@RequestMapping("/dominio")
public class DominioController {
    @Autowired
    DominioService dominioService;

    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    @GetMapping("/obtenerDominios")
    public List<DominioModel> obtenerDominios(){
        return dominioService.obtenerDominios();
    }

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    @GetMapping( path = "obtenerDominioPorId/{id}")
    public DominioModel obtenerDominioPorId(@PathVariable("id") Long id) {
        return this.dominioService.obtenerPorId(id);
    }





}