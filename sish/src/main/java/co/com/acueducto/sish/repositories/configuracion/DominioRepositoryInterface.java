package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;

import java.util.List;

/***
 * Interface de la clase de los dominios del sistema
 */
public interface DominioRepositoryInterface {
    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    List<DominioModel> obtener();

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    DominioModel obtenerPorId(Long id);
}
