package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.models.configuracion.TipoArchivoConfiguradoModel;
import co.com.acueducto.sish.services.configuracion.DominioValorService;
import co.com.acueducto.sish.services.configuracion.TipoArchivoConfiguradoService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * Clase de definición del servicio REST de los tipos de archivos configurado
 */
@RestController
@RequestMapping("/tipoArchivoConfigurado")
public class TipoArchivoConfiguradoController {


    @Autowired
    TipoArchivoConfiguradoService tipoArchivoConfiguradoService;
    private static final Logger logger = LoggerFactory.getLogger(TipoArchivoConfiguradoController.class);


    /***
     * Obtiene un valor de tipo Archivo configurado por identificador
     * @param id Identificador
     * @return TipoArchivoConfiguradoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorId/{id}")
    public List<TipoArchivoConfiguradoModel> obtenerPorId(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.tipoArchivoConfiguradoService.obtenerTipoArchivoCampoById(id);
    }

    /***
     * Obtiene un valor de tipo Archivo configurado por identificador
     * @return TipoArchivoConfiguradoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtener")
    public List<TipoArchivoConfiguradoModel> obtener() {
        logger.debug("En obtener");
        return this.tipoArchivoConfiguradoService.obtenerTipoArchivoCampo();
    }

    /***
     * Crea un tipoArchivoConfiguradoModel
     * @param tipoArchivoConfiguradoModel tipo de archivo configurado a crear
     * @return tipoArchivoConfiguradoModel creado
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/crear",method = RequestMethod.POST)
    public TipoArchivoConfiguradoModel crear(@Valid @RequestBody TipoArchivoConfiguradoModel tipoArchivoConfiguradoModel, BindingResult result) {
        logger.debug("Creando tipoArchivoConfiguradoModel con datos {}", tipoArchivoConfiguradoModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.tipoArchivoConfiguradoService.crear(tipoArchivoConfiguradoModel);

    }

    /***
     * Actualizar un tipo de archivo configurado
     * @param tipoArchivoConfiguradoModel tipo de archivo configurado a actualizar
     * @return Rol tipoArchivoConfiguradoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/actualizar",method = RequestMethod.POST)
    public TipoArchivoConfiguradoModel actualizar(@Valid @RequestBody TipoArchivoConfiguradoModel tipoArchivoConfiguradoModel, BindingResult result) {
        logger.debug("Actualizando el valor de dominio con datos {}", tipoArchivoConfiguradoModel.toString());
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return this.tipoArchivoConfiguradoService.actualizar(tipoArchivoConfiguradoModel);

    }

}
