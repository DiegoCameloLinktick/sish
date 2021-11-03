package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.EstacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *  Clase de definición de acceso a datos de las estaciones
 */
@Repository
public interface EstacionRepository extends JpaRepository<EstacionModel, Integer> {


    /***
     * Obtiene una lista de estaciones
     * @return lista de EstacionModel
     */
    @Query("SELECT e FROM EstacionModel e WHERE idEstacion = :idEstacion ")
    EstacionModel obtenerPorIdEstacion(@Param("idEstacion") Integer idEstacion);


    /***
     * Determina si el nombre del valordominio esta
     * @param idEstacion Identificador del dominio actual
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(e)> 0 then true else false end from EstacionModel e WHERE idEstacion != :idEstacion ")
    boolean estacionExistente(@Param("idEstacion") Integer idEstacion,
                              @Param("estacion")String estacion);

    /***
     * Lista de los dominios del sistema ordenada ascendentemente
     * @return Lista de DominioModel
     */
    @Query("SELECT e FROM EstacionModel e")
    List<EstacionModel> findByOrderByEstacionesAsc();

}
