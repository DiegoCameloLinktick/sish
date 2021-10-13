package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.models.seguridad.RolModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IRolService {

    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    ArrayList<RolModel> obtener();

    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    ArrayList<RolModel> obtenerActivos();

    /***
     * Obtiene un rol por identificador
     * @param id Identificador
     * @return RolModel
     */
    Optional<RolModel> obtenerPorId(Integer id);

    /***
     * Crear un rol
     * @param rolModel rol a crear
     * @return RolModel creado
     */
    RolModel crear(RolModel rolModel);

    /***
     * Actualizar un rol
     * @param rolModel rol a actualizar
     * @return RolModel actualizado
     */
    RolModel actualizar(RolModel rolModel);
}
