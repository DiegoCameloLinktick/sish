package co.com.acueducto.sish.repositories.configuracion;
import co.com.acueducto.sish.dtos.ParametroDTO;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParametroRepository extends JpaRepository<ParametroModel, Integer> {

    /***
     * Lista de los páramtros del sistema ordenada ascendentemente
     * @return Lista de DominioModel
     */
    @Query("SELECT p FROM ParametroModel p")
    List<ParametroModel> findByOrderByParametrosAsc();

    /**
     * Obtiene la lista de los páramtros para la consulta
     * @return lista de ParametroDTO
     */
    @Query(value = "SELECT p.id_parametro as idParametro," +
            "p.parametro as parametro, " +
            "p.codigo as codigo, " +
            "p.descripcion as descripcion, " +
            "p.id_unidad_medida as idUnidadMedida, " +
            "p.id_tipo_parametro as idTipoParametro, " +
            "p.id_metodo as idMetodo, " +
            "'dd' as nombreUnidadMedida, " +
            "'xx' as nombreTipoParametro, " +
            "'yy' as nombreMetodo " +
            "FROM PARAMETROS p ", nativeQuery = true)
    List<ParametroDTO> obtenerListaParametros();

}

