package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.dtos.ParametroDTO;
import co.com.acueducto.sish.dtos.configuracion.ParametroXEstacionDTO;
import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;
import co.com.acueducto.sish.services.configuracion.ParametroXEstacionService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los parametros x estacion
 */
@RestController
@RequestMapping("/parametroXEstacion")
public class ParametroXEstacionController {

    @Autowired
    ParametroXEstacionService parametroXEstacionService;
    private static final Logger logger = LoggerFactory.getLogger(DominioValorController.class);


    /***
     * Obtiene un parametro por id
     * @param id Identificador
     * @return ParametroXEstacionModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorId/{id}")
    public ParametroXEstacionModel obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtener parametro por estacion por id: " +  id);
        return this.parametroXEstacionService.obtenerParametrosXEstacionId(id);
    }

    /***
     * Obtiene un parametro por id
     * @return ParametroXEstacionModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtener")
    public List<ParametroXEstacionModel> obtener() {
        logger.debug("En obtener parametro por estacion list ");
        return this.parametroXEstacionService.obtenerParametrosXEstacion();
    }

    /***
     * Crea un parametroXEstacionModel
     * @param parametroXEstacionModel Rol a crear
     * @return Rol creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public ParametroXEstacionModel crear(@Valid @RequestBody ParametroXEstacionModel parametroXEstacionModel, BindingResult result) {
        logger.debug("Creando parametro x estacion con datos {}", parametroXEstacionModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametroXEstacionService.crear(parametroXEstacionModel);

    }

    /***
     * Actualizar un parametro x estacion
     * @param parametroXEstacionModel valor a actualizar
     * @return Rol creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public ParametroXEstacionModel actualizar(@Valid @RequestBody ParametroXEstacionModel parametroXEstacionModel, BindingResult result) {
        logger.debug("Actualizando el valor de dominio con datos {}", parametroXEstacionModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.parametroXEstacionService.actualizar(parametroXEstacionModel);

    }

    /***
     * Obtiene la lista de los páramtros para la consulta
     * @return Lista de ParametroDTO
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/obtenerListaParametrosXEstacion/{id}")
    public List<ParametroXEstacionDTO> obtenerListaParametrosXEstacion(@PathVariable("id") Integer id){
        logger.debug("En obtenerListaParametrosXEstacion");
        return parametroXEstacionService.obtenerListaParametrosXEstacion(id);
    }

}
