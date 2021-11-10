package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.MunicipioModel;
import co.com.acueducto.sish.services.configuracion.MunicipioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Clase de definición del servicio REST de los municipios
 */
@RestController
@RequestMapping("/municipio")
public class MunicipioController {


    @Autowired
    MunicipioService municipioService;
    private static final Logger logger = LoggerFactory.getLogger(MunicipioController.class);


    /***
     * Obtiene lista de municipios relacionados al departamento por identificador
     * @param id Identificador
     * @return List MunicipioModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerPorIdDepartamento/{id}")
    public List<MunicipioModel> obtenerMunicipiosPorIdDepartamento(@PathVariable("id") Integer id) {
        logger.debug("En obtenerPorId: " +  id);
        return this.municipioService.obtenerMunicipiosPorIdDepartamento(id);
    }
}
