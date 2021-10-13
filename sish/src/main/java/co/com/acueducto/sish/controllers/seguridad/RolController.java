package co.com.acueducto.sish.controllers.seguridad;

import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


/***
 * Clase de definición del servicio REST de los roles
 */
@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    RolService rolService;

    @Autowired
    AutenticacionService autenticacionService;

    private static final Logger logger = LoggerFactory.getLogger(RolController.class);

    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    @GetMapping("/obtener")
    public List<RolModel> obtener(@RequestHeader(value="Authorization") String token){
        logger.debug("En obtenerRoles");
        return rolService.obtener();
    }

    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    @GetMapping("/obtenerActivos")
    public List<RolModel> obtenerActivos(@RequestHeader(value="Authorization") String token){
        logger.debug("En obtenerActivos");
        return rolService.obtenerActivos();
    }

    /***
     * Obtiene un rol por identificador
     * @param id Identificador
     * @return RolModel
     */
    @GetMapping( path = "obtenerPorId/{id}")
    public Optional<RolModel> obtenerPorId(@RequestHeader(value="Authorization") String token, @PathVariable("id") Integer id) {
        logger.debug("En obtenerRolPorId: " +  id);
        return this.rolService.obtenerPorId(id);
    }

    /***
     * Crea un rol
     * @param token Header con el token
     * @param rolModel Rol a crear
     * @return Rol creado
     */
    @PostMapping(value = "/crear")
    public RolModel crear(@RequestHeader(value="Authorization") String token, RolModel rolModel) {
        logger.debug("En crear " );
        try {
            String usuario = autenticacionService.obtenerId(token);
            rolModel = this.rolService.crear(usuario,rolModel);
        } catch (Exception e) {
            logger.warn(e.toString(), e);
            String message = "Usuario invalido, debe ser mayor de edad";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);

        }
        return rolModel;
    }

}
