package co.com.acueducto.sish.services.configuracion;

import java.util.ArrayList;

import co.com.acueducto.sish.models.configuracion.DominioModel;

import co.com.acueducto.sish.repositories.configuracion.DominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 *  Clase de definición de la logica de negocio para los dominios
 */
@Service
public class DominioService implements DominioServiceInterface {
    @Autowired
    DominioRepository dominioRepository;


    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    public ArrayList<DominioModel> obtenerDominios() {
        return (ArrayList<DominioModel>) dominioRepository.obtenerDominios();
    }

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    public DominioModel obtenerPorId(Long id) {
        return dominioRepository.obtenerDominioPorId(id);
    }




}