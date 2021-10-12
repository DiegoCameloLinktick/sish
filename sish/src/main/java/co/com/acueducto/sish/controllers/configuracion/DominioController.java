package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.models.configuracion.DominioModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/***
 * Clase de definición del servicio REST de los dominios
 */
@RestController
@RequestMapping("/dominio")
public class DominioController {
    @Autowired
    DominioService dominioService;
    private static final Logger logger = LoggerFactory.getLogger(DominioController.class);

    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    @GetMapping("/obtenerDominios")
    public List<DominioModel> obtenerDominios(@RequestHeader(value="Authorization") String token){
        logger.debug("En obtenerDominios");
        return dominioService.obtener();
    }

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    @GetMapping( path = "obtenerDominioPorId/{id}")
    public Optional<DominioModel> obtenerDominioPorId(@RequestHeader(value="Authorization") String token, @PathVariable("id") Integer id) {
        logger.debug("En obtenerDominioPorId: " +  id);
        return this.dominioService.obtenerPorId(id);
    }





}