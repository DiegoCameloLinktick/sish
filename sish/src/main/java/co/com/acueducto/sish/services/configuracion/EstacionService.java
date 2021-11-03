package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.EstacionModel;
import co.com.acueducto.sish.models.configuracion.ParametrosModel;
import co.com.acueducto.sish.repositories.configuracion.EstacionRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***
 *  Clase de definición de la logica de negocio para las estaciones
 */
@Service
public class EstacionService implements IEstacionService{

    @Autowired
    EstacionRepository estacionRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(DominioValorService.class);

    /***
     * Obtiene los valores de una estacion por identificador
     * @param id Identificador de la estacion
     * @return  EstacionModel
     */
    public EstacionModel obtenerPorIdEstacion(Integer id) {
        logger.debug("En obtenerValoresPorId: " + id);
        return estacionRepository.obtenerPorIdEstacion(id);
    }


    public List<EstacionModel> obtener(){
        logger.debug("En obtener lista de estaciones");
        return estacionRepository.findByOrderByEstacionesAsc();
    }

}
