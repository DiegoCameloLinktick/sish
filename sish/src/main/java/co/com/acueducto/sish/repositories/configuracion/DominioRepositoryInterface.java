package co.com.acueducto.sish.repositories.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import java.util.List;

public interface DominioRepositoryInterface {
    List<DominioModel> obtenerDominios();
    DominioModel obtenerDominioPorId(Long id);
}
