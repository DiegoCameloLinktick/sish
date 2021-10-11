package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import java.util.List;

public interface DominioRepositoryInterface {
    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    List<DominioModel> obtenerDominios();
    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    DominioModel obtenerDominioPorId(Long id);
}
