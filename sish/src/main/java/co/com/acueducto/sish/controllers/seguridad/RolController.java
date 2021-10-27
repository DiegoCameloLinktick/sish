package co.com.acueducto.sish.controllers.seguridad;

import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
import co.com.acueducto.sish.services.seguridad.RolService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/obtener")
    public List<RolModel> obtener(){
        logger.debug("En obtenerRoles");
        return rolService.obtener();
    }

    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    @GetMapping("/obtenerActivos")
    public List<RolModel> obtenerActivos(){
        logger.debug("En obtenerActivos");
        return rolService.obtenerActivos();
    }

    /***
     * Obtiene un rol por identificador
     * @param id Identificador
     * @return RolModel
     */
    @GetMapping( path = "obtenerPorId/{id}")
    public Optional<RolModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerRolPorId: " +  id);
        return this.rolService.obtenerPorId(id);
    }

    /***
     * Crea un rol
     * @param rolModel Rol a crear
     * @return Rol creado
     */
    @PostMapping(value = "/crear")
    public RolModel crear(@Valid RolModel rolModel, BindingResult result) {
        logger.debug("Creando rol con datos {}", rolModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.rolService.crear(rolModel);

    }
    /***
     * Actualizar un rol
     * @param rolModel Rol a actualizar
     * @return Rol creado
     */
    @PostMapping(value = "/actualizar")
    public RolModel actualizar(@Valid RolModel rolModel, BindingResult result) {
        logger.debug("Actualizando el rol con datos {}", rolModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.rolService.actualizar(rolModel);

    }
}
