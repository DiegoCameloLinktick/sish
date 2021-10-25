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
 * Clase de definición del servicio REST de los dominios
 */
@RestController
@RequestMapping("/dominioValor")
public class DominioValorController {

    @Autowired
    DominioValorService dominioValorService;
    private static final Logger logger = LoggerFactory.getLogger(DominioController.class);

    @Autowired
    AutenticacionService autenticacionService;

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
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
    @PostMapping(value = "/crear")
    public DominioValoresModel crear(@Valid DominioValoresModel dominioValorModel, BindingResult result) {
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
    @PostMapping(value = "/actualizar")
    public DominioValoresModel actualizar(@Valid DominioValoresModel dominioValorModel, BindingResult result) {
        logger.debug("Actualizando el dominio con datos {}", dominioValorModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.dominioValorService.actualizar(dominioValorModel);

    }

}