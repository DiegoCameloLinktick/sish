package co.com.acueducto.sish.controllers.configuracion;

import co.com.acueducto.sish.services.configuracion.DominioValorService;
import co.com.acueducto.sish.services.configuracion.EstacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Clase de definición del servicio REST de las estaciones
 */
@RestController
@RequestMapping("/estacion")
public class EstacionController {

    @Autowired
    EstacionService estacionService;
    private static final Logger logger = LoggerFactory.getLogger(EstacionController.class);




}
