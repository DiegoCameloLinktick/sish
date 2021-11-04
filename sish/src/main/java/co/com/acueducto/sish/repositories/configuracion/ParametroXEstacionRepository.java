package co.com.acueducto.sish.repositories.configuracion;

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
     * @param idParametroXEstacion Identificador
     * @return Verdadero si existe
     */
    @Query("SELECT case when count(pxe)> 0 then true else false end from ParametroXEstacionModel pxe WHERE idParametroXEstacion = :idParametroXEstacion ")
    boolean valorParametroxEstacionExistente(@Param("idParametroXEstacion") Integer idParametroXEstacion);



}
