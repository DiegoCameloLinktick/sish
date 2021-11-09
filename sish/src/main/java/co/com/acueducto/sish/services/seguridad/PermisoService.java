package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.EstacionModel;
import co.com.acueducto.sish.models.seguridad.PermisoModel;
import co.com.acueducto.sish.repositories.seguridad.PermisoRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.configuracion.DominioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los permisos
 */
@Service
public class PermisoService implements IPermisoService{

    @Autowired
    PermisoRepository permisoRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(IPermisoService.class);

    /***
     * Obtiene los valores de un permiso por identificador
     * @param id Identificador del permiso
     * @return  PermisoModel
     */
    public PermisoModel obtenerPorIdPermiso(Integer id) {
        logger.debug("En obtenerPorIdPermiso: " + id);
        return permisoRepository.obtenerPorIdPermiso(id);
    }

    /***
     * obtener permisos
     * @return  PermisoModel list
     */
    public List<PermisoModel> obtener(){
        logger.debug("En obtener lista de permisos ");
        return permisoRepository.findByOrderBypermisoAsc();
    }


    /***
     * actualiza el permiso
     * @param permisoModel Identificador
     */
    public PermisoModel actualizar(PermisoModel permisoModel){
        logger.debug("Actualizando permiso con datos {}", permisoModel.toString());
        permisoModel= permisoRepository.save(permisoModel);
        auditoriaService.registrarAuditoria(permisoModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), permisoModel.getIdPermiso());
        return permisoModel;

    }

    /***
     * Crear un permiso
     * @param permisoModel permiso a crear
     * @return permisoModel creado
     */
    public PermisoModel crear(PermisoModel permisoModel)  {
        logger.debug("Creando valores de dominio con datos {}", permisoModel.toString());
        if (permisoRepository.permisoExistente(permisoModel.getIdPermiso())) {
            throw new DuplicateKeyException("Ya existe permiso con nombre: " + permisoModel.getPermiso());
        }
        permisoModel = permisoRepository.save(permisoModel);
        auditoriaService.registrarAuditoria(permisoModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), permisoModel.getIdPermiso());
        return permisoModel;
    }
}
