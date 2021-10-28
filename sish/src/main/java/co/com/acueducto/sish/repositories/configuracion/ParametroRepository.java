package co.com.acueducto.sish.repositories.configuracion;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParametroRepository extends JpaRepository<ParametroModel, Integer> {

    /***
     * Lista de los dominios del sistema ordenada ascendentemente
     * @return Lista de DominioModel
     */
    @Query("SELECT p FROM ParametroModel p")
    List<ParametroModel> findByOrderByParametrosAsc();


}

