package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import co.com.acueducto.sish.repositories.configuracion.ParametrosRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ParametrosService  implements IParametrosService     {

    @Autowired
    ParametrosRepository parametrosRepository;
    @Autowired
    AuditoriaService auditoriaService; 
    
    private static final Logger logger = LoggerFactory.getLogger(ParametrosService.class);

    /***
     * Obtiene la lista de todos los Parametross
     * @return
     */
    public ArrayList<ParametroModel> obtener() {
        logger.debug("En obtenerParametros");
        return (ArrayList<ParametroModel>) parametrosRepository.findByOrderByParametrosAsc();

    }
    /***
     * Obtiene un Parametros por identificador
     * @param id Identificador
     * @return ParametrosModel
     */
    public Optional<ParametroModel> obtenerPorId(Integer id) {
        logger.debug("En obtenerParametrosPorId: " + id);
        return parametrosRepository.findById(id);
    }


    /***
     * actualiza la descripcion del parametro
     * @param parametroModel Identificador,descripcion descripcion
     */
    public ParametroModel actualizar(ParametroModel parametroModel){

        logger.debug("Actualizando rol con datos {}", parametroModel.toString());

        parametroModel = parametrosRepository.save(parametroModel);
        auditoriaService.registrarAuditoria(parametroModel, OperacionAuditoriaEnum.ACTUALIZAR,
                ParametrosService.class.toString(), parametroModel.getIdParametro());
        return parametroModel;

    }

    /***
     * Crear un valor Parametros
     * @param parametroModel valor Parametros a crear
     * @return RolModel creado
     */
    public ParametroModel crear(ParametroModel parametroModel)  {
        logger.debug("Creando valores de Parametros con datos {}", parametroModel.toString());
        parametroModel = parametrosRepository.save(parametroModel);
        auditoriaService.registrarAuditoria(parametroModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), parametroModel.getIdParametro());
        return parametroModel;
    }


}

