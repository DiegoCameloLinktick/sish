package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.TipoArchivoColumnaModel;

import java.util.List;

public interface ITipoArchivoColumnaService {

    /***
     * Obtiene los valores del tipo de archivo columna
     * @param id Identificador
     * @return Lista TipoArchivoColumnaModel
     */
     List<TipoArchivoColumnaModel> obtenerTipoArchivoColumnaById(Integer id);

    /***
     * Obtiene los valores del tipo de archivo columna
     * @return Lista TipoArchivoColumnaModel
     */
    public List<TipoArchivoColumnaModel> obtenerTipoArchivoColumna();

    /***
     * Crear campo de tipo archivo
     * @param tipoArchivoColumnaModel valor a crear
     * @return tipoArchivoColumnaModel creado
     */
     TipoArchivoColumnaModel crear(TipoArchivoColumnaModel tipoArchivoColumnaModel);

    /***
     * actualiza el tipo de Archivo columna
     * @param tipoArchivoColumnaModel Identificador
     */
     TipoArchivoColumnaModel actualizar(TipoArchivoColumnaModel tipoArchivoColumnaModel);

}
