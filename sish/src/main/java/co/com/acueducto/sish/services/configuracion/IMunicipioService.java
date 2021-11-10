package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.MunicipioModel;

import java.util.List;

public interface IMunicipioService {


    /***
     * Obtiene los valores de los municipios por identificador del departamento
     * @param id Identificador del departamento
     * @return Lista MunicipioModel
     */
     List<MunicipioModel> obtenerMunicipiosPorIdDepartamento(Integer id);
}
