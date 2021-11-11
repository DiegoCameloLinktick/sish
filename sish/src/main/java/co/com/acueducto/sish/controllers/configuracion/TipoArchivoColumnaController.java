package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoColumnaModel;
import co.com.acueducto.sish.services.configuracion.TipoArchivoColumnaService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los tipos de archivos columna
 */
@RestController
@RequestMapping("/tipoArchivoColumna")
public class TipoArchivoColumnaController {

    @Autowired
    TipoArchivoColumnaService tipoArchivoColumnaService;
    private static final Logger logger = LoggerFactory.getLogger(TipoArchivoColumnaController.class);


    /***
     * Obtiene un valor de tipo Archivo columna por identificador
     * @param id Identificador
     * @return TipoArchivoColumnaModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorId/{id}")
    public List<TipoArchivoColumnaModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.tipoArchivoColumnaService.obtenerTipoArchivoColumnaById(id);
    }

    /***
     * Obtiene un valor de tipo Archivo columna por identificador
     * @return TipoArchivoColumnaModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtener")
    public List<TipoArchivoColumnaModel> obtener() {
        logger.debug("En obtener");
        return this.tipoArchivoColumnaService.obtenerTipoArchivoColumna();
    }

    /***
     * Crea un tipoArchivoCampoModel
     * @param tipoArchivoColumnaModel tipo de archivo campo a crear
     * @return tipoArchivoColumnaModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public TipoArchivoColumnaModel crear(@Valid @RequestBody TipoArchivoColumnaModel tipoArchivoColumnaModel, BindingResult result) {
        logger.debug("Creando tipoArchivoColumnaModel con datos {}", tipoArchivoColumnaModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.tipoArchivoColumnaService.crear(tipoArchivoColumnaModel);

    }

    /***
     * Actualizar un tipo de archivo columna
     * @param tipoArchivoColumnaModel tipo de archivo columna a actualizar
     * @return tipoArchivoColumnaModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public TipoArchivoColumnaModel actualizar(@Valid @RequestBody TipoArchivoColumnaModel tipoArchivoColumnaModel, BindingResult result) {
        logger.debug("Actualizando el tipo archivo columna con datos {}", tipoArchivoColumnaModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.tipoArchivoColumnaService.actualizar(tipoArchivoColumnaModel);

    }

}
