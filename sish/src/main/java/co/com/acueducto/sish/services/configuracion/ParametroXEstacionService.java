package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;
import co.com.acueducto.sish.repositories.configuracion.ParametroXEstacionRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los parametros x estacion
 */
@Service
public class ParametroXEstacionService  implements  IParametroXEstacionService{

    @Autowired
    ParametroXEstacionRepository parametroXEstacionRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(ParametroXEstacionService.class);


    /***
     * Crear una relacion de parametros por estacion
     * @param parametroXEstacionModel valor de parametro por estacion a crear
     * @return ParametroXEstacionModel creado
     */
    public ParametroXEstacionModel crear(ParametroXEstacionModel parametroXEstacionModel)  {
        logger.debug("Creando valores de parametros por estacion {}", parametroXEstacionModel.toString());
        if (parametroXEstacionRepository.valorParametroxEstacionExistente(parametroXEstacionModel.getIdParametroXEstacion())) {
            throw new DuplicateKeyException("Ya existe valor del parametro: " + parametroXEstacionModel.getIdParametroXEstacion());
        }
        parametroXEstacionModel = parametroXEstacionRepository.save(parametroXEstacionModel);
        auditoriaService.registrarAuditoria(parametroXEstacionModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), parametroXEstacionModel.getIdParametroXEstacion());
        return parametroXEstacionModel;
    }

    /***
     * actualiza el parametro x estacion
     * @param parametroXEstacionModel Identificador,descripcion
     */
    public ParametroXEstacionModel actualizar(ParametroXEstacionModel parametroXEstacionModel){
        logger.debug("Actualizando valor docminio con datos {}", parametroXEstacionModel.toString());
        parametroXEstacionModel= parametroXEstacionRepository.save(parametroXEstacionModel);
        auditoriaService.registrarAuditoria(parametroXEstacionModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), parametroXEstacionModel.getIdParametroXEstacion());
        return parametroXEstacionModel;

    }

    /***
     * Obtiene los valores de los parametros por estacion con identificador
     * @param id Identificador
     * @return Lista ParametroXEstacionModel
     */
    public ParametroXEstacionModel obtenerParametrosXEstacionId(Integer id) {
        logger.debug("En obtenerValoresPorId: " + id);
        return parametroXEstacionRepository.obtenerParametrosXEstacionId(id);
    }
    /***
     * Obtiene los valores de los parametros por estacion con identificador
     * @return Lista ParametroXEstacionModel
     */
    public List<ParametroXEstacionModel> obtenerParametrosXEstacion() {
        logger.debug("En obtener lista de parametros por estacion");
        return parametroXEstacionRepository.obtenerParametrosXEstacion();
    }


}
