package co.com.acueducto.sish.repositories.seguridad;

import co.com.acueducto.sish.dtos.seguridad.PermisoXRolDTO;
import co.com.acueducto.sish.models.seguridad.PermisoXRolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisoXRolRepository extends JpaRepository<PermisoXRolModel, Integer> {

    /***
     * Lista de los permisos por rol
     * @return Lista de PermisoXRolModel
     */
    @Query("SELECT pxr FROM PermisoXRolModel pxr")
    List<PermisoXRolModel> findByOrderByPermisoRol();

    /***
     * Determina si el permiso del rol esta
     * @param idPermiso Identificador
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(pxr)> 0 then true else false end from PermisoXRolModel pxr " +
            "WHERE idPermiso != :idPermiso AND idRol = :idRol")
    boolean permisoXRolExistente(@Param("idPermiso") Integer idPermiso,
                                 @Param("idRol")Integer idRol);


    @Query(value = "SELECT " +
            "p.PERMISO AS permiso, " +
            "p.DESCRIPCION AS descripcionPermiso, " +
            "p.ACTIVO AS activoPermiso, " +
            "r.ROL AS rol, " +
            "r.DESCRIPCION AS descripcionRol, " +
            "r.ACTIVO AS activoRol, " +
            "pxr.ID_PERMISO_X_ROL  AS idPermisoXRol, " +
            "pxr.ID_ROL AS idRol, " +
            "pxr.ID_PERMISO AS idPermiso " +
            "FROM PERMISOS p  " +
            "INNER JOIN PERMISOS_X_ROL pxr  " +
            "ON p.ID_PERMISO = pxr.ID_PERMISO  " +
            "INNER JOIN ROLES r " +
            "ON r.ID_ROL =pxr.ID_ROL " +
            "WHERE r.ID_ROL = :idRol", nativeQuery = true)
    List<PermisoXRolDTO> obtenerListaPermmisosXRol(@Param("idRol") Integer idRol);
}
