package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DepartamentoModel;
import java.util.List;

public interface IDepartamentoService {
    /***
     * Obtiene los valores del departamento
     * @return Lista DepartamentoModel
     */
     List<DepartamentoModel> obtenerDepartamentoOrderDesc();
}
