package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.dtos.configuracion.MetodoXTipoParametroDTO;
import co.com.acueducto.sish.models.configuracion.MetodoXTipoParametroModel;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetodoXTipoParametroRepository extends JpaRepository<MetodoXTipoParametroModel, Integer> {

    /***
     * Lista de los metodos por tipo páramtros del sistema
     * @return Lista de MetodoXTipoParametroModel
     */
    @Query("SELECT mxtp FROM MetodoXTipoParametroModel mxtp")
    List<MetodoXTipoParametroModel> findMetodoXTipoParametro();


    /***
     * Lista de los metodos por tipo páramtros del sistema
     * @return Lista de MetodoXTipoParametroModel
     */
    @Query(value="SELECT " +
            "mxtp.ID_METODO_X_TIPO_PARAMETRO AS idMetodoXTipoParametro ," +
            "mxtp.ID_TIPO_PARAMETRO AS idTipoParametro ," +
            "mxtp.ID_METODO AS idMetodo ," +
            "d.DOMINIO_VALOR AS tipoParametro ," +
            "d2.DOMINIO_VALOR AS metodo "+
            "FROM METODOS_X_TIPO_PARAMETRO mxtp " +
            "INNER JOIN DOMINIOS_VALORES d " +
            "ON d.ID_DOMINIO_VALOR = mxtp.ID_TIPO_PARAMETRO " +
            "INNER JOIN DOMINIOS_VALORES d2 " +
            "ON d2.ID_DOMINIO_VALOR  = mxtp.ID_METODO " +
            "WHERE mxtp.ID_TIPO_PARAMETRO =:idTipoParametro ", nativeQuery = true)
    List<MetodoXTipoParametroDTO> findLinstMetodoXTipoParametro(@Param("idTipoParametro") Integer idTipoParametro);


    /***
     * Determina si el nombre del valordominio esta
     * @param idTipoParametro Identificador
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(mxtp)> 0 then true else false end from MetodoXTipoParametroModel mxtp " +
            " WHERE idTipoParametro = :idTipoParametro AND idMetodo = :idMetodo ")
    boolean valorMetodoXTipoParametro(@Param("idTipoParametro") Integer idTipoParametro,
                                             @Param("idMetodo")Integer idMetodo);

}
