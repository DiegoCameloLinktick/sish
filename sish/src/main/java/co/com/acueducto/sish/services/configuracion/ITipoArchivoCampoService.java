package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoCampoModel;

import java.util.List;

public interface ITipoArchivoCampoService {

    /***
     * Obtiene los valores del tipo de archivo campo
     * @param id Identificador
     * @return Lista TipoArchivoCampoModel
     */
     List<TipoArchivoCampoModel> obtenerTipoArchivoCampoById(Integer id);

    /***
     * Obtiene los valores del tipo de archivo campo
     * @return Lista TipoArchivoCampoModel
     */
     List<TipoArchivoCampoModel> obtenerTipoArchivoCampo();

    /***
     * Crear campo de tipo archivo
     * @param tipoArchivoCampoModel valor a crear
     * @return TipoArchivoCampoModel creado
     */
     TipoArchivoCampoModel crear(TipoArchivoCampoModel tipoArchivoCampoModel);

    /***
     * actualiza el tipo de Archivo campo
     * @param tipoArchivoCampoModel Identificador
     */
     TipoArchivoCampoModel actualizar(TipoArchivoCampoModel tipoArchivoCampoModel);
}
