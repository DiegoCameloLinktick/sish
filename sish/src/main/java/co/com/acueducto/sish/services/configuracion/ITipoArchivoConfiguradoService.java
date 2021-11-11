package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoConfiguradoModel;

import java.util.List;

public interface ITipoArchivoConfiguradoService {

    /***
     * Obtiene los valores del tipo de archivo configurado
     * @param id Identificador
     * @return Lista TipoArchivoConfiguradoModel
     */
     List<TipoArchivoConfiguradoModel> obtenerTipoArchivoCampoById(Integer id);

    /***
     * Obtiene los valores del tipo de archivo configurado
     * @return Lista TipoArchivoConfiguradoModel
     */
     List<TipoArchivoConfiguradoModel> obtenerTipoArchivoCampo();

    /***
     * Crear un valor dominio
     * @param tipoArchivoConfiguradoModel valor dominio a crear
     * @return DominioValoresModel creado
     */
     TipoArchivoConfiguradoModel crear(TipoArchivoConfiguradoModel tipoArchivoConfiguradoModel);

    /***
     * actualiza el tipo de Archivo Configurado
     * @param tipoArchivoConfiguradoModel Identificador
     */
     TipoArchivoConfiguradoModel actualizar(TipoArchivoConfiguradoModel tipoArchivoConfiguradoModel);
}
