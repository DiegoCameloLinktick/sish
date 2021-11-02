package co.com.acueducto.sish.controllers.configuracion;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import co.com.acueducto.sish.services.configuracion.ParametroService;
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
 * Clase de definición del servicio REST de los parametros
 */
@RestController
@RequestMapping("/parametros")
public class ParametroController {
    @Autowired
    ParametroService parametroService;

    private static final Logger logger = LoggerFactory.getLogger(ParametroController.class);

    /***
     * Obtiene la lista de todos los Parametros
     * @return Lista de ParametrosModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/obtener")
    public List<ParametroModel> obtener(){
        logger.debug("En obtener");
        return parametroService.obtener();
    }

    /***
     * Obtiene un Parametros por identificador
     * @param id Identificador
     * @return ParametrosModel
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorId/{id}")
    public Optional<ParametroModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.parametroService.obtenerPorId(id);
    }

    /***
     * Actualizar un rol
     * @param parametroModel Rol a actualizar
     * @return Rol creado
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    public ParametroModel actualizar(@Valid @RequestBody ParametroModel parametroModel, BindingResult result) {
        logger.debug("Actualizando el Parametros con datos {}", parametroModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametroService.actualizar(parametroModel);

    }

    /***
     * Crea un Parametros
     * @param parametroModel parametros a crear
     * @return Parametros creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ParametroModel crear(@Valid @RequestBody ParametroModel parametroModel, BindingResult result) {
        logger.debug("Creando rol con datos {}", parametroModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametroService.crear(parametroModel);

    }

}

