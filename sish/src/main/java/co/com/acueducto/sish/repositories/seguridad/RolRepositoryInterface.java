package co.com.acueducto.sish.repositories.seguridad;


import co.com.acueducto.sish.models.seguridad.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * Interface de la clase de los roles del sistema
 */
public interface RolRepositoryInterface {
    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    List<RolModel> obtener();

    /***
     * Obtiene un rol por identificador
     * @param id Identificador
     * @return RolModel
     */
    RolModel obtenerPorId(Long id);

    /***
     * Crear un rol
     * @param rol rol a crear
     * @return RolModel
     */
    RolModel crear(RolModel rol);

    /***
     * Actualizar un rol
     * @param rol a actualizar
     * @return RolModel
     */
    RolModel actualizar(RolModel rol);

    /***
     * Obtiene la lista de los roles activos
     * @return Lista de RolModel
     */
    List<RolModel> obtenerActivos();

    /***
     * Obtiene una lista de roles activos basado en una lista de nombres de roles
     * @param roles lista de nombre de roles
     * @return lista de RolModel
     */
    List<RolModel> obtenerPorListaRoles(List<String> roles);

}