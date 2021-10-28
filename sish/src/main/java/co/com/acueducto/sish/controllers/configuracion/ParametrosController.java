package co.com.acueducto.sish.controllers.configuracion;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
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
    public List<ParametroModel> obtener(){
        logger.debug("En obtener");
        return parametrosService.obtener();
    }

    /***
     * Obtiene un Parametros por identificador
     * @param id Identificador
     * @return ParametrosModel
     */
    @GetMapping( path = "/obtenerPorId/{id}")
    public Optional<ParametroModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.parametrosService.obtenerPorId(id);
    }

    /***
     * Actualizar un rol
     * @param parametroModel Rol a actualizar
     * @return Rol creado
     */
    @PostMapping(value = "/actualizar")
    public ParametroModel actualizar(@Valid ParametroModel parametroModel, BindingResult result) {
        logger.debug("Actualizando el Parametros con datos {}", parametroModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametrosService.actualizar(parametroModel);

    }

    /***
     * Crea un Parametros
     * @param parametroModel parametros a crear
     * @return Parametros creado
     */
    @PostMapping(value = "/crear")
    public ParametroModel crear(@Valid ParametroModel parametroModel, BindingResult result) {
        logger.debug("Creando rol con datos {}", parametroModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametrosService.crear(parametroModel);

    }

}

