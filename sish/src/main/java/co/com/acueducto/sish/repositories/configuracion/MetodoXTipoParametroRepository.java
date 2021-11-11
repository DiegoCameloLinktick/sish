package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.MetodoXTipoParametroModel;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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





}
