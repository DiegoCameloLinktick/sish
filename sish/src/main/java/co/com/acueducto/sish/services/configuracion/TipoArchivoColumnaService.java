package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.TipoArchivoColumnaModel;
import co.com.acueducto.sish.repositories.configuracion.TipoArchivoColumnaRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los tipos de archivo columna
 */
@Service
public class TipoArchivoColumnaService implements ITipoArchivoColumnaService{


    @Autowired
    TipoArchivoColumnaRepository tipoArchivoColumnaRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(TipoArchivoColumnaService.class);

    /***
     * Obtiene los valores del tipo de archivo columna
     * @param id Identificador
     * @return Lista TipoArchivoColumnaModel
     */
    public List<TipoArchivoColumnaModel> obtenerTipoArchivoColumnaById(Integer id) {
        logger.debug("En obtenerTipoArchivoCampoById: " + id);
        return tipoArchivoColumnaRepository.obtenerTipoArchivoColumnaById(id);
    }

    /***
     * Obtiene los valores del tipo de archivo columna
     * @return Lista TipoArchivoColumnaModel
     */
    public List<TipoArchivoColumnaModel> obtenerTipoArchivoColumna() {
        logger.debug("En obtenerTipoArchivoColumna");
        return tipoArchivoColumnaRepository.obtenerTipoArchivoColumna();
    }

    /***
     * Crear campo de tipo archivo
     * @param tipoArchivoColumnaModel valor a crear
     * @return tipoArchivoColumnaModel creado
     */
    public TipoArchivoColumnaModel crear(TipoArchivoColumnaModel tipoArchivoColumnaModel)  {
        logger.debug("Creando tipo de archivo columna con datos {}", tipoArchivoColumnaModel.toString());
        if (tipoArchivoColumnaRepository.tipoArchivoColumnaExistente(tipoArchivoColumnaModel.getIdTipoArchivoColumna()
                ,tipoArchivoColumnaModel.getTipoArchivosColumna() )) {
            throw new DuplicateKeyException("Ya existe tipo de archivo columna con id: " + tipoArchivoColumnaModel.getIdTipoArchivoConfigurado());
        }
        tipoArchivoColumnaModel = tipoArchivoColumnaRepository.save(tipoArchivoColumnaModel);
        auditoriaService.registrarAuditoria(tipoArchivoColumnaModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), tipoArchivoColumnaModel.getIdTipoArchivoColumna());
        return tipoArchivoColumnaModel;
    }


    /***
     * actualiza el tipo de Archivo columna
     * @param tipoArchivoColumnaModel Identificador
     */
    public TipoArchivoColumnaModel actualizar(TipoArchivoColumnaModel tipoArchivoColumnaModel){
        logger.debug("Actualizando tipoArchivoColumnaModel con datos {}", tipoArchivoColumnaModel.toString());
        tipoArchivoColumnaModel= tipoArchivoColumnaRepository.save(tipoArchivoColumnaModel);
        auditoriaService.registrarAuditoria(tipoArchivoColumnaModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), tipoArchivoColumnaModel.getIdTipoArchivoColumna());
        return tipoArchivoColumnaModel;

    }


}
