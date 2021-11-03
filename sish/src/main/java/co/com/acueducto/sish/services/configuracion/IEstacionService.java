package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.EstacionModel;

import java.util.List;

public interface IEstacionService {

    /***
     * Obtiene la estacion por identificador
     * @param id Identificador de la estacion
     * @return  EstacionModel
     */
    EstacionModel obtenerPorIdEstacion(Integer id);

    /***
     * Obtiene un dominio por identificador del dominio
     * @param id Identificador del dominio
     * @return Lista DominioValoresModel
     */
    List<EstacionModel> obtener();

}
