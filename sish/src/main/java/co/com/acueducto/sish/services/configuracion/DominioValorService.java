package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.repositories.configuracion.DominioValorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/***
 *  Clase de definición de la logica de negocio para los valores de los dominios
 */
@Service
public class DominioValorService implements IDominioValorService{

    @Autowired
    DominioValorRepository dominioValorRepository;

    private static final Logger logger = LoggerFactory.getLogger(DominioValorService.class);

    /***
     * Obtiene los valores de un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    public List<DominioValoresModel> obtenerValoresPorIdDominio(Integer id) {
        logger.debug("En obtenerValoresPorId: " + id);
        return dominioValorRepository.obtenerValoresPorIdDominio(id);
    }

}
