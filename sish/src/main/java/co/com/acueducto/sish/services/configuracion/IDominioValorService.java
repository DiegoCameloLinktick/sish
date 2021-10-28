package co.com.acueducto.sish.services.configuracion;


import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import java.util.List;


public interface IDominioValorService {


    /***
     * Obtiene un dominio por identificador del dominio
     * @param id Identificador del dominio
     * @return Lista DominioValoresModel
     */
    List<DominioValoresModel> obtenerValoresPorIdDominio(Integer id);

    /***
     * Obtiene los valores activos de un dominio por identificador del dominio
     * @param id Identificador del dominio
     * @return Lista DominioValoresModel
     */
    List<DominioValoresModel> obtenerValoresActivosPorIdDominio(Integer id);
}
