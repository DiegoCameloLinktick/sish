package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.dtos.configuracion.MetodoXTipoParametroDTO;
import co.com.acueducto.sish.dtos.configuracion.ParametroXEstacionDTO;
import co.com.acueducto.sish.models.configuracion.MetodoXTipoParametroModel;
import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;
import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.services.configuracion.MetodoXTipoParametroService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los metodos por tipo de parametro
 */
@RestController
@RequestMapping("/metodoXtipoParametro")
public class MetodoXTipoParametroController {

    @Autowired
    MetodoXTipoParametroService metodoXTipoParametroService;
    private static final Logger logger = LoggerFactory.getLogger(MetodoXTipoParametroController.class);


    /***
     * Obtiene la lista de los metodos por tipo parametro
     * @return Lista de MetodoXTipoParametroDTO
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findLinstMetodoXTipoParametro/{id}")
    public List<MetodoXTipoParametroDTO> findLinstMetodoXTipoParametro(@PathVariable("id") Integer id){
        logger.debug("En obtenerListaParametrosXEstacion");
        return metodoXTipoParametroService.findLinstMetodoXTipoParametro(id);
    }



    /***
     * Crea un metodoXTipoParametroModel
     * @param metodoXTipoParametroModel Objeto a crear
     * @return metodoXTipoParametroModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public MetodoXTipoParametroModel crear(@Valid @RequestBody MetodoXTipoParametroModel metodoXTipoParametroModel, BindingResult result) {
        logger.debug("Creando metodos por tipo parametro con datos {}", metodoXTipoParametroModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.metodoXTipoParametroService.crear(metodoXTipoParametroModel);

    }

    /***
     * Actualizar un metodos por tipo parametro
     * @param metodoXTipoParametroModel valor a actualizar
     * @return metodoXTipoParametroModel Actualizado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public MetodoXTipoParametroModel actualizar(@Valid @RequestBody MetodoXTipoParametroModel metodoXTipoParametroModel, BindingResult result) {
        logger.debug("Actualizando el valor de un metodos por tipo parametro con datos {}", metodoXTipoParametroModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.metodoXTipoParametroService.actualizar(metodoXTipoParametroModel);

    }


}
