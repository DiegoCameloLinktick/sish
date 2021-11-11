package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.MunicipioModel;
import co.com.acueducto.sish.repositories.configuracion.MunicipioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los municipos
 */
@Service
public class MunicipioService implements IMunicipioService {

    @Autowired
    MunicipioRepository municipioRepository;

    private static final Logger logger = LoggerFactory.getLogger(MunicipioService.class);

    /***
     * Obtiene los valores de los municipios por identificador del departamento
     * @param id Identificador del departamento
     * @return Lista MunicipioModel
     */
    public List<MunicipioModel> obtenerMunicipiosPorIdDepartamento(Integer id) {
        logger.debug("En obtenerValoresPorId: " + id);
        return municipioRepository.obtenerMunicipiosPorIdDepartamento(id);
    }
}
