package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.configuracion.MetodoXTipoParametroDTO;
import co.com.acueducto.sish.models.configuracion.MetodoXTipoParametroModel;

import java.util.List;

public interface IMetodoXTipoParametroService {


    /***
     * Obtiene la lista de los metodos por tipo parametro para la consulta
     * @return lista de MetodoXTipoParametroDTO
     */
     List<MetodoXTipoParametroDTO> findLinstMetodoXTipoParametro(Integer id);

    /***
     * actualiza el metodos por tipo parametro
     * @param metodoXTipoParametroModel Identificador,descripcion
     */
     MetodoXTipoParametroModel actualizar(MetodoXTipoParametroModel metodoXTipoParametroModel);

    /***
     * Crear una relacion de parametros por estacion
     * @param metodoXTipoParametroModel valor de metodo por tipo parametro
     * @return metodoXTipoParametroModel creado
     */
     MetodoXTipoParametroModel crear(MetodoXTipoParametroModel metodoXTipoParametroModel);

}
