package co.com.acueducto.sish.repositories.seguridad;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.seguridad.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/***
 *  Clase de definición de acceso a datos de los roles
 */
@Repository
public interface RolRepository extends JpaRepository<RolModel, Integer> {

    /***
     * Lista de los roles del sistema ordenada ascendentemente
     * @return Lista de RolModel
     */
    List<RolModel> findByOrderByRolAsc();

    /***
     * Obtiene una lista de roles activos basado en una lista de nombres de roles
     * @param roles lista de nombre de roles
     * @return lista de RolModel
     */
    @Query("SELECT r FROM RolModel r WHERE activo = 'S'  ORDER BY rol ")
    List<RolModel> obtenerActivos();

    /***
     * Obtiene una lista de roles activos basado en una lista de nombres de roles
     * @param roles lista de nombre de roles
     * @return lista de RolModel
     */
    @Query("SELECT r FROM RolModel r WHERE activo = 'S'  and rol in :roles")
    List<RolModel> obtenerPorListaRoles(@Param("roles") List<String> roles);

    /***
     * Determina si existe un rol con el mismo nombre
     * @return Verdadero si existe
     */
    boolean existsRolModelByRol(String rol);

    /***
     * Determina si el nombre del rol esta asociado a otro rol
     * @param id Identificador del rol actual
     * @param rol nombre del rol a buscar
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(r)> 0 then true else false end from RolModel r WHERE id != :id  and rol = :rol")
    boolean rolExistente(@Param("id") Integer id, @Param("rol") String rol);



}
