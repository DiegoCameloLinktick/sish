 package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.ParametroModel;
import java.util.List;
import java.util.Optional;

 public interface IParametrosService {
    /***
     * Obtiene un Parametros por identificador
     * @return ParametrosModel
     */
    List<ParametroModel> obtener();

     /***
      * Obtiene un Parametros por identificador
      * @param id Identificador
      * @return ParametrosModel
      */
     Optional<ParametroModel> obtenerPorId(Integer id);

     /***
      * actualiza la descripcion del parametro
      * @param parametroModel Identificador,descripcion descripcion
      */
     ParametroModel actualizar(ParametroModel parametroModel);

     /***
      * Crear un valor Parametros
      * @param parametroModel valor Parametros a crear
      * @return RolModel creado
      */
     ParametroModel crear(ParametroModel parametroModel);
}

