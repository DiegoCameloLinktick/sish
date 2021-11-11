package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.MunicipioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *  Clase de definición de acceso a datos de los municipios
 */
@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioModel, Integer> {


    /***
     * Obtiene una lista de los municipios relacionados al departamento
     * @return lista de MunicipioModel
     */
    @Query("SELECT d FROM MunicipioModel d WHERE idDepartamento = :idDepartamento  order by municipio desc")
    List<MunicipioModel> obtenerMunicipiosPorIdDepartamento(@Param("idDepartamento") Integer idDepartamento);


}
