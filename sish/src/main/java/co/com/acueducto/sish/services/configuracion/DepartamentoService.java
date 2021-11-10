package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DepartamentoModel;
import co.com.acueducto.sish.repositories.configuracion.DepartamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los departamentos
 */
@Service
public class DepartamentoService implements IDepartamentoService{


    @Autowired
    DepartamentoRepository departamentoRepository;

    private static final Logger logger = LoggerFactory.getLogger(DepartamentoService.class);

    /***
     * Obtiene los valores del departamento
     * @return Lista DepartamentoModel
     */
    public List<DepartamentoModel> obtenerDepartamentoOrderDesc() {
        logger.debug("En obtenerDepartamentoOrderDesc");
        return departamentoRepository.obtenerDepartamentoOrderDesc();
    }
}
