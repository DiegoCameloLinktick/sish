package co.com.acueducto.sish.controllers.configuracion;
import co.com.acueducto.sish.models.configuracion.ParametrosModel;
import co.com.acueducto.sish.services.configuracion.ParametrosService;
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

@RestController
@RequestMapping("/parametros")
public class ParametrosController {
    @Autowired
    ParametrosService parametrosService;
    private static final Logger logger = LoggerFactory.getLogger(ParametrosController.class);

    @Autowired
    AutenticacionService autenticacionService;
    /***
     * Obtiene la lista de todos los Parametros
     * @return Lista de ParametrosModel
     */
    @GetMapping("/obtener")
    public List<ParametrosModel> obtener(){
        logger.debug("En obtener");
        return parametrosService.obtener();
    }

    /***
     * Obtiene un Parametros por identificador
     * @param id Identificador
     * @return ParametrosModel
     */
    @GetMapping( path = "/obtenerPorId/{id}")
    public Optional<ParametrosModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.parametrosService.obtenerPorId(id);
    }

    /***
     * Actualizar un rol
     * @param parametrosModel Rol a actualizar
     * @return Rol creado
     */
    @PostMapping(value = "/actualizar")
    public ParametrosModel actualizar(@Valid ParametrosModel parametrosModel, BindingResult result) {
        logger.debug("Actualizando el Parametros con datos {}", parametrosModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametrosService.actualizar(parametrosModel);

    }

    /***
     * Crea un Parametros
     * @param parametrosModel parametros a crear
     * @return Parametros creado
     */
    @PostMapping(value = "/crear")
    public ParametrosModel crear(@Valid ParametrosModel parametrosModel, BindingResult result) {
        logger.debug("Creando rol con datos {}", parametrosModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametrosService.crear(parametrosModel);

    }

}

