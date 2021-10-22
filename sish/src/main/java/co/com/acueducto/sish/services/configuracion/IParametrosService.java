 package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.ParametrosModel;
import java.util.List;

public interface IParametrosService {
    /***
     * Obtiene un Parametros por identificador

     * @return ParametrosModel
     */
    List<ParametrosModel> obtener();
}

