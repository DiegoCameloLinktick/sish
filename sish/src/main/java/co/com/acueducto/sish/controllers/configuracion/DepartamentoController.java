package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.DepartamentoModel;
import co.com.acueducto.sish.services.configuracion.DepartamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Clase de definición del servicio REST de los departamentos
 */
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;
    private static final Logger logger = LoggerFactory.getLogger(DepartamentoController.class);

    /***
     * Obtiene lista de departamentos
     * @return DepartamentoModel
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/obtenerDepartamento")
    public List<DepartamentoModel> obtenerDepartamentoOrderDesc() {
        logger.debug("En obtenerDepartamentoOrderDesc ");
        return this.departamentoService.obtenerDepartamentoOrderDesc();
    }
}
