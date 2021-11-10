package co.com.acueducto.sish.controllers.seguridad;

import co.com.acueducto.sish.dtos.seguridad.PermisoXRolDTO;
import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;
import co.com.acueducto.sish.models.seguridad.PermisoXRolModel;
import co.com.acueducto.sish.services.seguridad.PermisoXRolService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los permisos por rol
 */
@RestController
@RequestMapping("/permisosXRol")
public class PermisoXRolController {

    @Autowired
    PermisoXRolService permisoXRolService;
    private static final Logger logger = LoggerFactory.getLogger(PermisoXRolController.class);


    /***
     * Obtiene los permisos por rol
     * @return PermisoXRolModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtener")
    public List<PermisoXRolModel> obtener() {
        logger.debug("En obtener parametro por estacion list ");
        return this.permisoXRolService.findByOrderByPermisoRol();
    }


    /***
     * Obtiene la lista de los páramtros para la consulta
     * @return Lista de PermisoXRolDTO
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/obtenerListaPermisosXRolId/{id}")
    public List<PermisoXRolDTO> obtenerListaPermisosXRolId(@PathVariable("id") Integer id){
        logger.debug("En obtenerListaParametrosXEstacion");
        return permisoXRolService.obtenerListaPermmisosXRol(id);
    }


    /***
     * Actualizar un permiso por rol
     * @param permisoXRolModel valor a actualizar
     * @return permiso por rol creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public PermisoXRolModel actualizar(@Valid @RequestBody PermisoXRolModel permisoXRolModel, BindingResult result) {
        logger.debug("Actualizando el valor permiso por rol con datos {}", permisoXRolModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.permisoXRolService.actualizar(permisoXRolModel);

    }

    /***
     * Crea un permisoXRolModel
     * @param permisoXRolModel permiso por rol a crear
     * @return permisoXRolModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public PermisoXRolModel crear(@Valid @RequestBody PermisoXRolModel permisoXRolModel, BindingResult result) {
        logger.debug("Creando permiso por rol con datos {}", permisoXRolModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.permisoXRolService.crear(permisoXRolModel);

    }

    /***
     * Eliminar un permiso por rol
     * @return permiso por rol eliminado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/eliminar/{id}",method = RequestMethod.POST)
    public PermisoXRolModel eliminar(@PathVariable("id") Integer id) {
        logger.debug("En eliminar parametro por estacion con id: " + id);
        return this.permisoXRolService.eliminarPermmisosXRol(id);

    }


}
