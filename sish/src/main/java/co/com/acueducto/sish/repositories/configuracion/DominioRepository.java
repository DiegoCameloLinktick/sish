package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/***
 *  Clase de definición de acceso a datos de los dominios
 */
@Repository
public interface DominioRepository  extends JpaRepository<DominioModel, Integer> {
    /***
     * Lista de los dominios del sistema ordenada ascendentemente
     * @return Lista de DominioModel
     */
    @Query("SELECT d FROM DominioModel d")
    List<DominioModel> findByOrderByDominioAsc();

    /***
     * Determina si el nombre del dominio esta
     * @param idDominio Identificador del dominio actual
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(d)> 0 then true else false end from DominioModel d WHERE idDominio != :idDominio ")
    boolean dominioExistente(@Param("idDominio") Integer idDominio);
}