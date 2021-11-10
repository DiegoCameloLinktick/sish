package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.TipoArchivoConfiguradoModel;
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
public class TipoArchivoConfiguradoService {

    @Autowired
    TipoArchivoConfiguradoRepository tipoArchivoConfiguradoRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(TipoArchivoConfiguradoService.class);


    /***
     * Obtiene los valores del tipo de archivo configurado
     * @param id Identificador
     * @return Lista TipoArchivoConfiguradoModel
     */
    public List<TipoArchivoConfiguradoModel> obtenerTipoArchivoCampoById(Integer id) {
        logger.debug("En obtenerTipoArchivoCampoById: " + id);
        return tipoArchivoConfiguradoRepository.obtenerTipoArchivoConfiguradoById(id);
    }

    /***
     * Obtiene los valores del tipo de archivo configurado
     * @return Lista TipoArchivoConfiguradoModel
     */
    public List<TipoArchivoConfiguradoModel> obtenerTipoArchivoCampo() {
        logger.debug("En obtenerTipoArchivoCampoById ");
        return tipoArchivoConfiguradoRepository.obtenerTipoArchivoConfigurado();
    }



    /***
     * Crear un valor dominio
     * @param tipoArchivoConfiguradoModel valor dominio a crear
     * @return DominioValoresModel creado
     */
    public TipoArchivoConfiguradoModel crear(TipoArchivoConfiguradoModel tipoArchivoConfiguradoModel)  {
        logger.debug("Creando tipo de archivo configurado con datos {}", tipoArchivoConfiguradoModel.toString());
        if (tipoArchivoConfiguradoRepository.tipoArchivoConfiguradoExistente(tipoArchivoConfiguradoModel.getIdTipoArchivoConfigurado()
                ,tipoArchivoConfiguradoModel.getTipoArchivoConfigurado() )) {
            throw new DuplicateKeyException("Ya existe tipo de archivo configurado con id: " + tipoArchivoConfiguradoModel.getIdTipoArchivoConfigurado());
        }
        tipoArchivoConfiguradoModel = tipoArchivoConfiguradoRepository.save(tipoArchivoConfiguradoModel);
        auditoriaService.registrarAuditoria(tipoArchivoConfiguradoModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), tipoArchivoConfiguradoModel.getIdTipoArchivoConfigurado());
        return tipoArchivoConfiguradoModel;
    }


    /***
     * actualiza el tipo de Archivo Configurado
     * @param tipoArchivoConfiguradoModel Identificador
     */
    public TipoArchivoConfiguradoModel actualizar(TipoArchivoConfiguradoModel tipoArchivoConfiguradoModel){
        logger.debug("Actualizando tipoArchivoConfiguradoModel con datos {}", tipoArchivoConfiguradoModel.toString());
        tipoArchivoConfiguradoModel= tipoArchivoConfiguradoRepository.save(tipoArchivoConfiguradoModel);
        auditoriaService.registrarAuditoria(tipoArchivoConfiguradoModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), tipoArchivoConfiguradoModel.getIdTipoArchivoConfigurado());
        return tipoArchivoConfiguradoModel;

    }

}
