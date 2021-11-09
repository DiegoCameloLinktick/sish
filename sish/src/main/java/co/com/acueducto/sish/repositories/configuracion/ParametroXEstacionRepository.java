package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.dtos.configuracion.ParametroXEstacionDTO;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParametroXEstacionRepository extends JpaRepository<ParametroXEstacionModel, Integer> {

    /***
     * Obtiene una lista de parametros X Estacion
     * @return lista de ParametroXEstacionModel
     */
    @Query("SELECT pxe FROM ParametroXEstacionModel pxe  ")
    List<ParametroXEstacionModel> obtenerParametrosXEstacion();

    /***
     * Obtiene una lista de parametros por id
     * @return  de ParametroXEstacionModel
     */
    @Query("SELECT pxe FROM ParametroXEstacionModel pxe WHERE idParametroXEstacion = :idParametroXEstacion")
    ParametroXEstacionModel obtenerParametrosXEstacionId(@Param("idParametroXEstacion") Integer idParametroXEstacion);


    /***
     * Determina si el nombre del valordominio esta
     * @param idParametro Identificador
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(pxe)> 0 then true else false end from ParametroXEstacionModel pxe " +
            " WHERE idParametro = :idParametro AND idEstacion = :idEstacion ")
    boolean valorParametroxEstacionExistente(@Param("idParametro") Integer idParametro,
                                             @Param("idEstacion")Integer idEstacion);


    /***
     * Determina si el nombre del valordominio esta
     * @param idEstacion Identificador
     * @return Verdadero si existe
     */
    @Query(value = "SELECT  " +
            "p.parametro as parametro, " +
            "p.codigo as codigo,  " +
            "p.descripcion as descripcion, " +
            "e.estacion AS estacion, " +
            "pxe.ID_PARAMETRO AS idParametro, " +
            "pxe.ID_ESTACION AS idEstacion, " +
            "pxe.ID_PARAMETRO_X_ESTACION AS idParametroXEstacion " +
            "FROM PARAMETROS p " +
            "INNER JOIN PARAMETROS_X_ESTACION pxe " +
            "ON pxe.ID_PARAMETRO = p.ID_PARAMETRO " +
            "INNER JOIN ESTACIONES e " +
            "ON e.ID_ESTACION = pxe.ID_ESTACION " +
            "WHERE e.ID_ESTACION = :idEstacion", nativeQuery = true)
    List<ParametroXEstacionDTO> obtenerListaParametrosXEstacion(@Param("idEstacion") Integer idEstacion);


}
