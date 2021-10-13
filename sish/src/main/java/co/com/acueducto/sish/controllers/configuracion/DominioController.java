package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.models.configuracion.DominioModel;

import co.com.acueducto.sish.services.seguridad.AutenticacionService;
import co.com.acueducto.sish.util.excepcion.UnauthorizedException;
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

    @Autowired
    AutenticacionService autenticacionService;
    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    @GetMapping("/obtener")
    public List<DominioModel> obtener(@RequestHeader(value="Authorization") String token){
        logger.debug("En obtener");
        if(Boolean.FALSE.equals(autenticacionService.esTokenValido(token))) {
            throw new UnauthorizedException();
        }
        return dominioService.obtener();
    }

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    @GetMapping( path = "obtenerPorId/{id}")
    public Optional<DominioModel> obtenerPorId(@RequestHeader(value="Authorization") String token, @PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        if(Boolean.FALSE.equals(autenticacionService.esTokenValido(token))) {
            throw new UnauthorizedException();
        }
        return this.dominioService.obtenerPorId(id);
    }
}