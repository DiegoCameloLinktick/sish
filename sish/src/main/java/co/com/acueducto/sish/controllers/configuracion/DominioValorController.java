package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.services.configuracion.DominioValorService;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
