package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.TipoArchivoCampoModel;
import co.com.acueducto.sish.models.configuracion.TipoArchivoConfiguradoModel;
import co.com.acueducto.sish.repositories.configuracion.TipoArchivoCampoRepository;
import co.com.acueducto.sish.repositories.configuracion.TipoArchivoConfiguradoRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los tipos de archivo configurado
 */
@Service
public class TipoArchivoCampoService {

    @Autowired
    TipoArchivoCampoRepository tipoArchivoCampoRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(TipoArchivoCampoService.class);

    /***
     * Obtiene los valores del tipo de archivo campo
     * @param id Identificador
     * @return Lista TipoArchivoCampoModel
     */
    public List<TipoArchivoCampoModel> obtenerTipoArchivoCampoById(Integer id) {
        logger.debug("En obtenerTipoArchivoCampoById: " + id);
        return tipoArchivoCampoRepository.obtenerTipoArchivoCampoById(id);
    }

    /***
     * Obtiene los valores del tipo de archivo campo
     * @return Lista TipoArchivoCampoModel
     */
    public List<TipoArchivoCampoModel> obtenerTipoArchivoCampo() {
        logger.debug("En obtenerTipoArchivoCampo");
        return tipoArchivoCampoRepository.obtenerTipoArchivoCampo();
    }

    /***
     * Crear campo de tipo archivo
     * @param tipoArchivoCampoModel valor a crear
     * @return TipoArchivoCampoModel creado
     */
    public TipoArchivoCampoModel crear(TipoArchivoCampoModel tipoArchivoCampoModel)  {
        logger.debug("Creando tipo de archivo configurado con datos {}", tipoArchivoCampoModel.toString());
        if (tipoArchivoCampoRepository.tipoArchivoCampoExistente(tipoArchivoCampoModel.getIdTipoArchivoConfigurado()
                ,tipoArchivoCampoModel.getIdTipoArchivoColumna() )) {
            throw new DuplicateKeyException("Ya existe tipo de archivo configurado con id: " + tipoArchivoCampoModel.getIdTipoArchivoConfigurado());
        }
        tipoArchivoCampoModel = tipoArchivoCampoRepository.save(tipoArchivoCampoModel);
        auditoriaService.registrarAuditoria(tipoArchivoCampoModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), tipoArchivoCampoModel.getIdTipoArchivoCampo());
        return tipoArchivoCampoModel;
    }


    /***
     * actualiza el tipo de Archivo campo
     * @param tipoArchivoCampoModel Identificador
     */
    public TipoArchivoCampoModel actualizar(TipoArchivoCampoModel tipoArchivoCampoModel){
        logger.debug("Actualizando tipoArchivoCampoModel con datos {}", tipoArchivoCampoModel.toString());
        tipoArchivoCampoModel= tipoArchivoCampoRepository.save(tipoArchivoCampoModel);
        auditoriaService.registrarAuditoria(tipoArchivoCampoModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), tipoArchivoCampoModel.getIdTipoArchivoCampo());
        return tipoArchivoCampoModel;

    }

}
