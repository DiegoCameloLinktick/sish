package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/***
 *  Clase de definición de acceso a datos de los dominios
 */
@Repository
public interface DominioRepository  extends JpaRepository<DominioModel, Integer> {
    List<DominioModel> findByOrderByDominioAsc();


}