package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;

import java.util.ArrayList;


public interface DominioServiceInterface {

    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    ArrayList<DominioModel> obtener();
    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    DominioModel obtenerPorId(Long id);


}
