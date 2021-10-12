package co.com.acueducto.sish.services.auditoria;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.util.utilidades.UtilidadesJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;


public class AuditoriaService implements IAuditoriaService{
    @Autowired
    AuditoriaRepository auditoriaRepository;
    @Autowired
    UtilidadesJSON utilidadesJSON;

    private static final Logger logger = LoggerFactory.getLogger(AuditoriaService.class);

    /***
     * Crear un registro en la tabla
     * @return AuditoriaModel creado
     */
    public AuditoriaModel crear(AuditoriaModel auditoriaModel) {
        logger.debug("En crear");
        return auditoriaRepository.save(auditoriaModel);
    }
    /***
     * Genera el objeto de auditoria y crea el registro
     * @return AuditoriaModel creado
     */
    public AuditoriaModel registrarAuditoria(Object objeto, String usuario, OperacionAuditoriaEnum operacion,String nombreEntidad,Integer id) throws JsonProcessingException {
        logger.debug("En registrarAuditoria");
        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setId(id);
        auditoriaModel.setFecha(new Timestamp(System.currentTimeMillis()));
        //auditoriaModel.setObjeto(utilidadesJSON.convertirObjetoJson(objeto));
        auditoriaModel.setObjeto("");
        auditoriaModel.setOperacion(operacion.id());
        auditoriaModel.setUsuario(usuario);
        auditoriaModel.setNombreEntidad(nombreEntidad);
        return crear(auditoriaModel);
    }
}
