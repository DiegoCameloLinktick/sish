package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.dtos.seguridad.PermisoXRolDTO;
import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;
import co.com.acueducto.sish.models.seguridad.PermisoXRolModel;
import co.com.acueducto.sish.repositories.seguridad.PermisoXRolRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.configuracion.DominioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los permisos x rol
 */
@Service
public class PermisoXRolService implements IPermisoXRolService{

    @Autowired
    PermisoXRolRepository permisoXRolRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(PermisoXRolService.class);

    /***
     * Obtiene los valores de los permisos por rol
     * @return Lista PermisoXRolModel
     */
    public List<PermisoXRolModel> findByOrderByPermisoRol() {
        logger.debug("En obtener lista de parametros por estacion");
        return permisoXRolRepository.findByOrderByPermisoRol();
    }

    /***
     * Obtiene la lista de los permisos x rol
     * @return lista de PermisoXRolDTO
     */
    public List<PermisoXRolDTO> obtenerListaPermmisosXRol(Integer idRol) {
        logger.debug("En obtenerListaParametros");
        return permisoXRolRepository.obtenerListaPermmisosXRol(idRol);

    }

    /***
     * actualiza el permiso por rol
     * @param permisoXRolModel Identificador
     */
    public PermisoXRolModel actualizar(PermisoXRolModel permisoXRolModel){
        logger.debug("Actualizando valor permiso por rol con datos{}", permisoXRolModel.toString());
        permisoXRolModel= permisoXRolRepository.save(permisoXRolModel);
        auditoriaService.registrarAuditoria(permisoXRolModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), permisoXRolModel.getIdPermiso());
        return permisoXRolModel;

    }

    /***
     * Crear una relacion de parametros por estacion
     * @param permisoXRolModel valor de parametro por estacion a crear
     * @return ParametroXEstacionModel creado
     */
    public PermisoXRolModel crear(PermisoXRolModel permisoXRolModel)  {
        logger.debug("Creando valores de permisos por rol {}", permisoXRolModel.toString());
        if (permisoXRolRepository.permisoXRolExistente(permisoXRolModel.getIdPermiso(),permisoXRolModel.getIdRol())) {
            throw new DuplicateKeyException("Ya existe valor del permiso por rol : " + permisoXRolModel.toString());
        }
        permisoXRolModel = permisoXRolRepository.save(permisoXRolModel);
        auditoriaService.registrarAuditoria(permisoXRolModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), permisoXRolModel.getIdPermisoXRol());
        return permisoXRolModel;
    }
}
