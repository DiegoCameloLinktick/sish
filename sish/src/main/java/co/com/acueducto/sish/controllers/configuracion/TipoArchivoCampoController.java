package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoCampoModel;
import co.com.acueducto.sish.services.configuracion.TipoArchivoCampoService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los tipos de archivos campo
 */
@RestController
@RequestMapping("/tipoArchivoCampo")
public class TipoArchivoCampoController {

    @Autowired
    TipoArchivoCampoService tipoArchivoCampoService;
    private static final Logger logger = LoggerFactory.getLogger(TipoArchivoCampoController.class);


    /***
     * Obtiene un valor de tipo Archivo campo por identificador
     * @param id Identificador
     * @return TipoArchivoCampoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorId/{id}")
    public List<TipoArchivoCampoModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.tipoArchivoCampoService.obtenerTipoArchivoCampoById(id);
    }

    /***
     * Obtiene un valor de tipo Archivo campo por identificador
     * @return TipoArchivoCampoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtener")
    public List<TipoArchivoCampoModel> obtener() {
        logger.debug("En obtener");
        return this.tipoArchivoCampoService.obtenerTipoArchivoCampo();
    }

    /***
     * Crea un tipoArchivoCampoModel
     * @param tipoArchivoCampoModel tipo de archivo campo a crear
     * @return tipoArchivoCampoModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public TipoArchivoCampoModel crear(@Valid @RequestBody TipoArchivoCampoModel tipoArchivoCampoModel, BindingResult result) {
        logger.debug("Creando tipoArchivoCampoModel con datos {}", tipoArchivoCampoModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.tipoArchivoCampoService.crear(tipoArchivoCampoModel);

    }

    /***
     * Actualizar un tipo de archivo campo
     * @param tipoArchivoCampoModel tipo de archivo campo a actualizar
     * @return tipoArchivoCampoModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public TipoArchivoCampoModel actualizar(@Valid @RequestBody TipoArchivoCampoModel tipoArchivoCampoModel, BindingResult result) {
        logger.debug("Actualizando el tipo archivo campo con datos {}", tipoArchivoCampoModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.tipoArchivoCampoService.actualizar(tipoArchivoCampoModel);

    }


}
