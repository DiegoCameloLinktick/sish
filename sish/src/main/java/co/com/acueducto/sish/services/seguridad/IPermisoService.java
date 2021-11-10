package co.com.acueducto.sish.services.seguridad;


import co.com.acueducto.sish.models.seguridad.PermisoModel;

import java.util.List;

public interface IPermisoService{


    /***
     * Obtiene los valores de un permiso por identificador
     * @param id Identificador del permiso
     * @return  PermisoModel
     */
     PermisoModel obtenerPorIdPermiso(Integer id);


    /***
     * obtener permisos
     * @return  PermisoModel list
     */
     List<PermisoModel> obtener();

    /***
     * actualiza el permiso
     * @param permisoModel Identificador
     */
     PermisoModel actualizar(PermisoModel permisoModel);

    /***
     * Crear un permiso
     * @param permisoModel permiso a crear
     * @return permisoModel creado
     */
     PermisoModel crear(PermisoModel permisoModel);


}
