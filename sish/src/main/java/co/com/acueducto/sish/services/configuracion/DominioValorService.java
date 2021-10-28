package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.repositories.configuracion.DominioValorRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/***
 *  Clase de definición de la logica de negocio para los valores de los dominios
 */
@Service
public class DominioValorService implements IDominioValorService{

    @Autowired
    DominioValorRepository dominioValorRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(DominioValorService.class);




    /***
     * Crear un valor dominio
     * @param dominioValorModel valor dominio a crear
     * @return RolModel creado
     */
    public DominioValoresModel crear(DominioValoresModel dominioValorModel)  {
        logger.debug("Creando valores de dominio con datos {}", dominioValorModel.toString());
        dominioValorModel = dominioValorRepository.save(dominioValorModel);
        auditoriaService.registrarAuditoria(dominioValorModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), dominioValorModel.getIdDominioValor());
        return dominioValorModel;
    }

    /***
     * actualiza la descripcion del dominio
     * @param dominioValorModel Identificador,descripcion descripcion
     */
    public DominioValoresModel actualizar(DominioValoresModel dominioValorModel){
        logger.debug("Actualizando rol con datos {}", dominioValorModel.toString());
        dominioValorModel= dominioValorRepository.save(dominioValorModel);
        auditoriaService.registrarAuditoria(dominioValorModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), dominioValorModel.getIdDominioValor());
        return dominioValorModel;

    }

    /***
     * Obtiene los valores de un dominio por identificador del dominio
     * @param id Identificador del dominio
     * @return Lista DominioValoresModel
     */
    public List<DominioValoresModel> obtenerValoresPorIdDominio(Integer id) {
        logger.debug("En obtenerValoresPorId: " + id);
        return dominioValorRepository.obtenerValoresPorIdDominio(id);
    }

    /***
     * Obtiene los valores activos de un dominio por identificador del dominio
     * @param id Identificador del dominio
     * @return Lista DominioValoresModel
     */
    public List<DominioValoresModel> obtenerValoresActivosPorIdDominio(Integer id) {
        logger.debug("En obtenerValoresActivosPorIdDominio: " + id);
        return dominioValorRepository.obtenerValoresActivosPorIdDominio(id);
    }

}
