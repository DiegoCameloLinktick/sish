package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.models.seguridad.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/***
 *  Clase de definición de acceso a datos de los valores que tiene los dominios
 */
@Repository
public interface DominioValorRepository extends JpaRepository<DominioValoresModel, Integer> {


    /***
     * Obtiene una lista de valores realacionados con el dominio
     * @return lista de DominioValoresModel
     */
    @Query("SELECT d FROM DominioValoresModel d WHERE idDominio = :idDominio  order by dominioValor desc")
    List<DominioValoresModel> obtenerValoresPorIdDominio(@Param("idDominio") Integer idDominio);

    /***
     * Obtiene una lista de valores activos realacionados con el dominio
     * @return lista de DominioValoresModel
     */
    @Query("SELECT d FROM DominioValoresModel d WHERE idDominio = :idDominio and activo = 'S' ")
    List<DominioValoresModel> obtenerValoresActivosPorIdDominio(@Param("idDominio") Integer idDominio);


    /***
     * Obtiene una lista de valores realacionados con el dominio
     * @return lista de DominioValoresModel
     */
    @Query("SELECT d FROM DominioValoresModel d WHERE idDominio = :idDominio  order by orden desc")
    List<DominioValoresModel> obtenerValoresPorIdDominioOrden(@Param("idDominio") Integer idDominio);

    /***
     * Obtiene una lista de valores activos realacionados con el dominio
     * @return lista de DominioValoresModel
     */
    @Query("SELECT d FROM DominioValoresModel d WHERE idDominio = :idDominio and activo = 'S' order by orden desc")
    List<DominioValoresModel> obtenerValoresActivosPorIdDominioOrden(@Param("idDominio") Integer idDominio);


    /***
     * Determina si el nombre del valordominio esta
     * @param idDominio Identificador del dominio actual
     * @param dominioValor valor del dominio a validar
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(d)> 0 then true else false end from DominioValoresModel d WHERE idDominio = :idDominio and " +
            " dominioValor= :dominioValor ")
    boolean valorDominioExistente(@Param("idDominio") Integer idDominio,
                                  @Param("dominioValor") String dominioValor);


}
