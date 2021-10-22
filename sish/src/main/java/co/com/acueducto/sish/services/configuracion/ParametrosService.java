package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.ParametrosModel;
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
    public ArrayList<ParametrosModel> obtener() {
        logger.debug("En obtenerParametros");
        return (ArrayList<ParametrosModel>) parametrosRepository.findByOrderByParametrosAsc();
      // return  null;
    }
    /***
     * Obtiene un Parametros por identificador
     * @param id Identificador
     * @return ParametrosModel
     */
    public Optional<ParametrosModel> obtenerPorId(Integer id) {
        logger.debug("En obtenerParametrosPorId: " + id);
        return parametrosRepository.findById(id);
    }


    /***
     * actualiza la descripcion del parametro
     * @param parametrosModel Identificador,descripcion descripcion
     */
    public ParametrosModel actualizar(ParametrosModel parametrosModel){

        logger.debug("Actualizando rol con datos {}", parametrosModel.toString());

        parametrosModel= parametrosRepository.save(parametrosModel);
        auditoriaService.registrarAuditoria(parametrosModel, OperacionAuditoriaEnum.ACTUALIZAR,
                ParametrosService.class.toString(), parametrosModel.getIdParametro());
        return parametrosModel;

    }

    /***
     * Crear un valor Parametros
     * @param parametrosModel valor Parametros a crear
     * @return RolModel creado
     */
    public ParametrosModel crear(ParametrosModel parametrosModel   )  {
        logger.debug("Creando valores de Parametros con datos {}", parametrosModel.toString());
        parametrosModel = parametrosRepository.save(parametrosModel);
        auditoriaService.registrarAuditoria(parametrosModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), parametrosModel.getIdParametro());
        return parametrosModel;
    }


}

