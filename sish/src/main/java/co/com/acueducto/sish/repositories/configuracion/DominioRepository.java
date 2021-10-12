package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/***
 *  Clase de definición de acceso a datos de los dominios
 */
@Repository
public class DominioRepository implements  DominioRepositoryInterface   {


    @PersistenceContext
    EntityManager entityManager;

    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    @Override
    @Transactional
    public List<DominioModel>  obtener() {
        String query = "FROM DominioModel";
        return entityManager.createQuery(query).getResultList();

    }

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    @Transactional
    public DominioModel obtenerPorId(Long id) {
        return entityManager.find(DominioModel.class, id);

    }

}