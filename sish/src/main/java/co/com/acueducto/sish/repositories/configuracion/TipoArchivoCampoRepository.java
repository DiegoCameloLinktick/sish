package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoCampoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/***
 *  Clase de definición de acceso a datos de los tipos de archivos campo
 */
@Repository
public interface TipoArchivoCampoRepository extends JpaRepository<TipoArchivoCampoModel, Integer> {

    /***
     * Obtiene una lista TipoArchivoCampoModel
     * @return lista de TipoArchivoCampoModel
     */
    @Query("SELECT tac FROM TipoArchivoCampoModel tac WHERE idTipoArchivoCampo = :idTipoArchivoCampo")
    List<TipoArchivoCampoModel> obtenerTipoArchivoCampoById(@Param("idTipoArchivoCampo") Integer idTipoArchivoCampo);

    /***
     * Obtiene una lista TipoArchivoCampoModel
     * @return lista de TipoArchivoCampoModel
     */
    @Query("SELECT tac FROM TipoArchivoCampoModel tac")
    List<TipoArchivoCampoModel> obtenerTipoArchivoCampo();


    /***
     * Determina si el campo de tipo de archivo
     * @param idTipoArchivoConfigurado Identificador
     * @param idTipoArchivoColumna identificador
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(tac)> 0 then true else false end from TipoArchivoCampoModel tac WHERE idTipoArchivoConfigurado = :idTipoArchivoConfigurado" +
            " and idTipoArchivoColumna= :idTipoArchivoColumna ")
    boolean tipoArchivoCampoExistente(@Param("idTipoArchivoConfigurado") Integer idTipoArchivoConfigurado,
                                      @Param("idTipoArchivoColumna") Integer idTipoArchivoColumna);

}
