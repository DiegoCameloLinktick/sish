package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.dtos.seguridad.PermisoXRolDTO;
import co.com.acueducto.sish.models.seguridad.PermisoXRolModel;

import java.util.List;

public interface IPermisoXRolService {

    /***
     * Obtiene los valores de los permisos por rol
     * @return Lista PermisoXRolModel
     */
     List<PermisoXRolModel> findByOrderByPermisoRol();

    /***
     * Obtiene la lista de los permisos x rol
     * @return lista de PermisoXRolDTO
     */
     List<PermisoXRolDTO> obtenerListaPermmisosXRol(Integer idRol);

    /***
     * actualiza el permiso por rol
     * @param permisoXRolModel Identificador
     */
     PermisoXRolModel actualizar(PermisoXRolModel permisoXRolModel);
}
