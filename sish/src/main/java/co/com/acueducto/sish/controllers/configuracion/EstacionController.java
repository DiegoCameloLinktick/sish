package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.EstacionModel;
import co.com.acueducto.sish.services.configuracion.EstacionService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de las estaciones
 */
@RestController
@RequestMapping("/estacion")
public class EstacionController {

    @Autowired
    EstacionService estacionService;
    private static final Logger logger = LoggerFactory.getLogger(EstacionController.class);


    /***
     * Crea una estacion
     * @param estacionModel estacion a crear
     * @return Rol creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public EstacionModel crear(@Valid @RequestBody EstacionModel estacionModel, BindingResult result) {
        logger.debug("Creando estacion con datos {}", estacionModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.estacionService.crear(estacionModel);

    }

    /***
     * Actualizar una estacion
     * @param estacionModel valor a actualizar
     * @return estacion creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public EstacionModel actualizar(@Valid @RequestBody EstacionModel estacionModel, BindingResult result) {
        logger.debug("Actualizando el valor de dominio con datos {}", estacionModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.estacionService.actualizar(estacionModel);

    }

    /***
     * Obtiene las estaciones
     * @return Lista EstacionModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerEstaciones")
    public List<EstacionModel> obtener() {
        logger.debug("En tener estaciones: " );
        return this.estacionService.obtener();
    }


}
