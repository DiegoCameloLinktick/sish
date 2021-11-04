package co.com.acueducto.sish.services.configuracion;


import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;

import java.util.List;

public interface IParametroXEstacionService {

    /***
     * Crear una relacion de parametros por estacion
     * @param parametroXEstacionModel valor de parametro por estacion a crear
     * @return ParametroXEstacionModel creado
     */
     ParametroXEstacionModel crear(ParametroXEstacionModel parametroXEstacionModel);

    /***
     * actualiza el parametro x estacion
     * @param parametroXEstacionModel Identificador,descripcion
     */
     ParametroXEstacionModel actualizar(ParametroXEstacionModel parametroXEstacionModel);

    /***
     * Obtiene los valores de los parametros por estacion con identificador
     * @param id Identificador
     * @return  ParametroXEstacionModel
     */
     ParametroXEstacionModel obtenerParametrosXEstacionId(Integer id);

    /***
     * Obtiene los valores de los parametros por estacion con identificador
     * @return  ParametroXEstacionModel
     */
    List<ParametroXEstacionModel> obtenerParametrosXEstacion();
}
