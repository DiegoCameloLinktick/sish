package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoConfiguradoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/***
 *  Clase de definición de acceso a datos de los tipo de archivo configurado
 */
@Repository
public interface TipoArchivoConfiguradoRepository extends JpaRepository<TipoArchivoConfiguradoModel, Integer> {


    /***
     * Obtiene una lista TipoArchivoConfiguradoModel
     * @return lista de TipoArchivoConfiguradoModel
     */
    @Query("SELECT tac FROM TipoArchivoConfiguradoModel tac order by tipoArchivoConfigurado desc")
    List<TipoArchivoConfiguradoModel> obtenerTipoArchivoConfigurado();


    /***
     * Obtiene una lista TipoArchivoConfiguradoModel
     * @return lista de TipoArchivoConfiguradoModel
     */
    @Query("SELECT tac FROM TipoArchivoConfiguradoModel tac WHERE idTipoArchivoConfigurado = :idTipoArchivoConfigurado  order by tipoArchivoConfigurado desc")
    List<TipoArchivoConfiguradoModel> obtenerTipoArchivoConfiguradoById(@Param("idTipoArchivoConfigurado") Integer idTipoArchivoConfigurado);


    /***
     * Determina si el el tipo de archivo
     * @param idTipoArchivoConfigurado Identificador
     * @param tipoArchivoConfigurado tipo del archivo configurado
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(tac)> 0 then true else false end from TipoArchivoConfiguradoModel tac WHERE idTipoArchivoConfigurado = :idTipoArchivoConfigurado" +
            " and tipoArchivoConfigurado= :tipoArchivoConfigurado ")
    boolean tipoArchivoConfiguradoExistente(@Param("idTipoArchivoConfigurado") Integer idTipoArchivoConfigurado,
                                  @Param("tipoArchivoConfigurado") String tipoArchivoConfigurado);

}
