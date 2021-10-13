package co.com.acueducto.sish.services.seguridad;


import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.repositories.seguridad.RolRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.util.excepcion.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolService implements IRolService {
    @Autowired
    RolRepository rolRepository;

    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(RolService.class);

    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    public ArrayList<RolModel> obtener() {
        logger.debug("En obtenerRoles");

        return (ArrayList<RolModel>) rolRepository.findByOrderByRolAsc();
    }

    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    public ArrayList<RolModel> obtenerActivos() {
        logger.debug("En obtenerRoles");

        return (ArrayList<RolModel>) rolRepository.obtenerActivos();
    }

    /***
     * Obtiene un rol por identificador
     * @param id Identificador
     * @return RolModel
     */
    public Optional<RolModel> obtenerPorId(Integer id) {
        logger.debug("En obtenerRolPorId: " + id);
        return rolRepository.findById(id);
    }

    /***
     * Crear un rol
     * @param rolModel rol a crear
     * @return RolModel creado
     */
    public RolModel crear(String usuario, RolModel rolModel)  {
        logger.debug("En crear ");
        rolModel = rolRepository.save(rolModel);
        auditoriaService.registrarAuditoria(rolModel,usuario, OperacionAuditoriaEnum.CREAR, RolService.class.toString(), rolModel.getIdRol());
        return rolModel;
    }

    /***
     * Actualizar un rol
     * @param rolModel rol a actualizar
     * @return RolModel actualizado
     */
    public RolModel actualizar(RolModel rolModel) {
        logger.debug("En crear ");
        return rolRepository.save(rolModel);
    }
}
