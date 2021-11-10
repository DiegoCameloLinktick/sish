package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *  Clase de definición de acceso a datos de los departamentos
 */
@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Integer> {


    /***
     * Obtiene una lista de los departamentos
     * @return lista de DominioValoresModel
     */
    @Query("SELECT d FROM DepartamentoModel d  order by departamento desc")
    List<DepartamentoModel> obtenerDepartamentoOrderDesc();


}
