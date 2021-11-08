package co.com.acueducto.sish.repositories.seguridad;

import co.com.acueducto.sish.models.seguridad.PermisoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisoRepository extends JpaRepository<PermisoModel, Integer> {

    /***
     * Obtiene un objeto de PermisoModel
     * @return   PermisoModel
     */
    @Query("SELECT p FROM PermisoModel p WHERE idPermiso = :idPermiso ")
    PermisoModel obtenerPorIdPermiso(@Param("idPermiso") Integer idPermiso);


    /***
     * Determina si el nombre del valordominio esta
     * @param idPermiso Identificador del dominio actual
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(p)> 0 then true else false end from PermisoModel p WHERE idPermiso != :idPermiso ")
    boolean permisoExistente(@Param("idPermiso") Integer idPermiso);

    /***
     * Lista de los permisos
     * @return Lista de PermisoModel
     */
    @Query("SELECT p FROM PermisoModel p")
    List<PermisoModel> findByOrderBypermisoAsc();
}
