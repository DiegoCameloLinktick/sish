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
    @Query(value = "SELECT p.id_parametro as idParametro, " +
            "p.ID_VARIABLE AS idVariable," +
            "p.codigo as codigo, " +
            "p.descripcion as descripcion, " +
            "p.id_unidad_medida as idUnidadMedida, " +
            "p.id_tipo_parametro as idTipoParametro, " +
            "p.id_metodo as idMetodo, " +
            "p.ACTIVO as activo, " +
            "p.FECHA_CREACION  AS fechaCreacion, " +
            "p.FECHA_MODIFICACION  AS fechaModificacion, " +
            "p.FECHA_ESTADO AS fechaEstado, " +
            "p.USUARIO_CREACION AS usuarioCreacion, " +
            "p.USUARIO_MODIFICACION AS usuarioModificacion, " +
            "p.USUARIO_ESTADO AS usuarioEstado, " +
            "d.DOMINIO_VALOR as nombreUnidadMedida, " +
            "d2.DOMINIO_VALOR as nombreTipoParametro, " +
            "d3.DOMINIO_VALOR as nombreMetodo, " +
            "d4.DOMINIO_VALOR AS variable " +
            "FROM PARAMETROS p " +
            "INNER JOIN DOMINIOS_VALORES d " +
            "ON d.ID_DOMINIO_VALOR  = p.ID_TIPO_PARAMETRO " +
            "INNER JOIN DOMINIOS_VALORES d2 " +
            "ON d2.ID_DOMINIO_VALOR  = p.ID_UNIDAD_MEDIDA " +
            "INNER JOIN DOMINIOS_VALORES d3 " +
            "ON d3.ID_DOMINIO_VALOR  = p.ID_METODO " +
            "INNER JOIN DOMINIOS_VALORES d4 " +
            "ON d4.ID_DOMINIO_VALOR  = p.ID_VARIABLE ", nativeQuery = true)
    List<ParametroDTO> obtenerListaParametros();

}

