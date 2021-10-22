package co.com.acueducto.sish.repositories.configuracion;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.configuracion.ParametrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParametrosRepository  extends JpaRepository<ParametrosModel, Integer> {

    /***
     * Lista de los dominios del sistema ordenada ascendentemente
     * @return Lista de DominioModel
     */
    @Query("SELECT p FROM ParametrosModel p")
    List<ParametrosModel> findByOrderByParametrosAsc();


}

