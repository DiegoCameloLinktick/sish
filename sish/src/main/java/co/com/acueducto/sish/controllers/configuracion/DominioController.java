package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
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
    public List<DominioModel> obtener(){
        logger.debug("En obtener");
            return dominioService.obtener();
    }

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    @GetMapping( path = "/obtenerPorId/{id}")
    public Optional<DominioModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.dominioService.obtenerPorId(id);
    }

    /***
     * Actualizar un rol
     * @param dominioModel Rol a actualizar
     * @return Rol creado
     */
    @PostMapping(value = "/actualizar")
    public DominioModel actualizar(@Valid DominioModel dominioModel, BindingResult result) {
        logger.debug("Actualizando el dominio con datos {}", dominioModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.dominioService.actualizar(dominioModel);

    }

    /***
     * Crea un dominio
     * @param dominioModel dominio a crear
     * @return dominio creado
     */
    @PostMapping(value = "/crear")
    public DominioModel crear(@Valid DominioModel dominioModel, BindingResult result) {
        logger.debug("Creando rol con datos {}", dominioModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.dominioService.crear(dominioModel);

    }


}