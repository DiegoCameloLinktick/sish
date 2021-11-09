package co.com.acueducto.sish.dtos.seguridad;

public interface PermisoXRolDTO {

    /***
     * Nombre permiso
     */
    String getPermiso();
    /***
     * descripcion permiso
     */
    String getDescripcionPermiso();
    /***
     * estado permiso
     */
    String getActivoPermiso();
    /***
     * Nombre rol
     */
    String getRol();
    /***
     * descripcion rol
     */
    String getDescripcionRol();
    /***
     * estado rol
     */
    String getActivoRol();
    /***
     * Llave idPermisoXRol
     */
    Integer getIdPermisoXRol();
    /***
     * Llave idRol
     */
    Integer getIdRol();
    /***
     * Llave idPermiso
     */
    Integer getIdPermiso();
}
