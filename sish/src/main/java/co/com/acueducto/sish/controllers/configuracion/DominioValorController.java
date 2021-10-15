package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.services.configuracion.DominioValorService;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/***
 * Clase de definición del servicio REST de los dominios
 */
@RestController
@RequestMapping("/dominioValor")
public class DominioValorController {

    @Autowired
    DominioValorService DominioValorService;
    private static final Logger logger = LoggerFactory.getLogger(DominioController.class);

    @Autowired
    AutenticacionService autenticacionService;

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    @GetMapping( path = "/obtenerValoresDominio/{id}")
    public List<DominioValoresModel> obtenerPorIdDominio(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.DominioValorService.obtenerValoresPorIdDominio(id);
    }


    /***
     * Actualizar un rol
     * @param dominioValorModel Rol a actualizar
     * @return Rol creado
     */
    @PostMapping(value = "/actualizarValoresDominio")
    public DominioValoresModel actualizaraValoresDominio(@Valid DominioValoresModel dominioValorModel, BindingResult result) {
        logger.debug("Actualizando el dominio con datos {}", dominioValorModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.DominioValorService.updateValorDominio(dominioValorModel);

    }

}
