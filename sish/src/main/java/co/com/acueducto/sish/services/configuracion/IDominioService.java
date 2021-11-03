package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import java.util.List;
import java.util.Optional;


public interface IDominioService {

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
    Optional<DominioModel> obtenerPorId(Integer id);

    /***
     * actualiza la descripcion del dominio
     * @param dominioModel Identificador,descripcion descripcion
     */
    DominioModel actualizar(DominioModel dominioModel);

        
}
