package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.services.configuracion.DominioValorService;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los valores dominios
 */
@RestController
@RequestMapping("/dominioValor")
public class DominioValorController {

    @Autowired
    DominioValorService dominioValorService;
    private static final Logger logger = LoggerFactory.getLogger(DominioController.class);


    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorId/{id}")
    public List<DominioValoresModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.dominioValorService.obtenerValoresPorIdDominio(id);
    }

    /***
     * Crea un rol
     * @param dominioValorModel Rol a crear
     * @return Rol creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public DominioValoresModel crear(@Valid @RequestBody DominioValoresModel dominioValorModel, BindingResult result) {
        logger.debug("Creando valor dominio con datos {}", dominioValorModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.dominioValorService.crear(dominioValorModel);

    }

    /***
     * Actualizar un valor de dominio
     * @param dominioValorModel valor a actualizar
     * @return Rol creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public DominioValoresModel actualizar(@Valid @RequestBody DominioValoresModel dominioValorModel, BindingResult result) {
        logger.debug("Actualizando el valor de dominio con datos {}", dominioValorModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.dominioValorService.actualizar(dominioValorModel);

    }

    /***
     * Obtiene los valores de un dominio por identificador del dominio
     * @param id Identificador del dominio
     * @return Lista DominioValoresModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerValoresPorIdDominio/{id}")
    public List<DominioValoresModel> obtenerValoresPorIdDominio(@PathVariable("id") Integer id) {
        logger.debug("En obtenerValoresPorIdDominio: " +  id);
        return this.dominioValorService.obtenerValoresPorIdDominio(id);
    }

    /***
     * Obtiene los valores activos de un dominio por identificador del dominio
     * @param id Identificador del dominio
     * @return Lista DominioValoresModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerValoresActivosPorIdDominio/{id}")
    public List<DominioValoresModel> obtenerValoresActivosPorIdDominio(@PathVariable("id") Integer id) {
        logger.debug("En obtenerValoresActivosPorIdDominio: " +  id);
        return this.dominioValorService.obtenerValoresActivosPorIdDominio(id);
    }
}
