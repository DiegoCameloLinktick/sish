package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoColumnaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *  Clase de definición de acceso a datos de los tipos de archivos columna
 */
@Repository
public interface TipoArchivoColumnaRepository extends JpaRepository<TipoArchivoColumnaModel, Integer> {


    /***
     * Obtiene una lista TipoArchivoColumnaModel
     * @return lista de TipoArchivoColumnaModel
     */
    @Query("SELECT tac FROM TipoArchivoColumnaModel tac WHERE idTipoArchivoColumna = :idTipoArchivoColumna")
    List<TipoArchivoColumnaModel> obtenerTipoArchivoColumnaById(@Param("idTipoArchivoColumna") Integer idTipoArchivoColumna);

    /***
     * Obtiene una lista TipoArchivoColumnaModel
     * @return lista de TipoArchivoColumnaModel
     */
    @Query("SELECT tac FROM TipoArchivoColumnaModel tac")
    List<TipoArchivoColumnaModel> obtenerTipoArchivoColumna();


    /***
     * Determina si el campo de tipo de archivo
     * @param idTipoArchivoConfigurado Identificador
     * @param tipoArchivosColumna tipo de archivo columna
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(tac)> 0 then true else false end from TipoArchivoColumnaModel tac WHERE idTipoArchivoConfigurado = :idTipoArchivoConfigurado" +
            " and tipoArchivosColumna= :tipoArchivosColumna ")
    boolean tipoArchivoColumnaExistente(@Param("idTipoArchivoConfigurado") Integer idTipoArchivoConfigurado,
                                      @Param("tipoArchivosColumna") String tipoArchivosColumna);
}
