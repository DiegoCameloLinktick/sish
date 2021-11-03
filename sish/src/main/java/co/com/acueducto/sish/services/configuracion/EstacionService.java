package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.models.configuracion.EstacionModel;
import co.com.acueducto.sish.repositories.configuracion.EstacionRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

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

    /***
     * obtener estaciones
     * @return  EstacionModel list
     */
    public List<EstacionModel> obtener(){
        logger.debug("En obtener lista de estaciones");
        return estacionRepository.findByOrderByEstacionesAsc();
    }


    /***
     * actualiza la estacion
     * @param estacionModel Identificador
     */
    public EstacionModel actualizar(EstacionModel estacionModel){
        logger.debug("Actualizando estacion con datos {}", estacionModel.toString());
        estacionModel= estacionRepository.save(estacionModel);
        auditoriaService.registrarAuditoria(estacionModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), estacionModel.getIdEstacion());
        return estacionModel;

    }

    /***
     * Crear un valor una estacion
     * @param estacionModel estacion a crear
     * @return EstacionModel creado
     */
    public EstacionModel crear(EstacionModel estacionModel)  {
        logger.debug("Creando valores de dominio con datos {}", estacionModel.toString());
        if (estacionRepository.estacionExistente(estacionModel.getIdEstacion(),estacionModel.getEstacion())) {
            throw new DuplicateKeyException("Ya existe estacion con nombre: " + estacionModel.getEstacion());
        }
        estacionModel = estacionRepository.save(estacionModel);
        auditoriaService.registrarAuditoria(estacionModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), estacionModel.getIdEstacion());
        return estacionModel;
    }

}
