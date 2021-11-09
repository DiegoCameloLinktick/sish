package co.com.acueducto.sish.controllers.seguridad;

import co.com.acueducto.sish.models.seguridad.PermisoModel;
import co.com.acueducto.sish.services.seguridad.PermisoService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los permisos
 */
@RestController
@RequestMapping("/permiso")
public class PermisoController {

    @Autowired
    PermisoService permisoService;
    private static final Logger logger = LoggerFactory.getLogger(PermisoController.class);


    /***
     * Obtiene un permiso por id
     * @param id Identificador
     * @return PermisoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorId/{id}")
    public PermisoModel obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtener permiso por id: " +  id);
        return this.permisoService.obtenerPorIdPermiso(id);
    }

    /***
     * Obtiene una lista de los permisos
     * @return PermisoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtener")
    public List<PermisoModel> obtener() {
        logger.debug("En obtener parametro por estacion list ");
        return this.permisoService.obtener();
    }

    /***
     * Crea un permisoModel
     * @param permisoModel permisoModel a crear
     * @return permisoModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public PermisoModel crear(@Valid @RequestBody PermisoModel permisoModel, BindingResult result) {
        logger.debug("Creando permiso con datos {}", permisoModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.permisoService.crear(permisoModel);

    }

    /***
     * Actualizar un permiso
     * @param permisoModel valor a actualizar
     * @return permiso Actualizado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public PermisoModel actualizar(@Valid @RequestBody PermisoModel permisoModel, BindingResult result) {
        logger.debug("Actualizando el permiso con datos {}", permisoModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.permisoService.actualizar(permisoModel);

    }
}
