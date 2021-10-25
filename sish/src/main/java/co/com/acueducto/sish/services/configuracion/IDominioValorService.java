package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IDominioValorService {


    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    List<DominioValoresModel> obtenerValoresPorIdDominio(Integer id);
}
