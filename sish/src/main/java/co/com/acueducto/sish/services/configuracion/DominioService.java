package co.com.acueducto.sish.services.configuracion;

import java.util.ArrayList;
import java.util.Optional;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.repositories.configuracion.DominioRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/***
 *  Clase de definición de la logica de negocio para los dominios
 */
@Service
public class DominioService implements IDominioService {
    @Autowired
    DominioRepository dominioRepository;

    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(DominioService.class);

    /***
     * Obtiene la lista de todos los dominios
     * @return Lista de DominioModel
     */
    public ArrayList<DominioModel> obtener() {
        logger.debug("En obtenerDominios");

        return (ArrayList<DominioModel>) dominioRepository.findByOrderByDominioAsc();
    }

    /***
     * Obtiene un dominio por identificador
     * @param id Identificador
     * @return DominioModel
     */
    public Optional<DominioModel> obtenerPorId(Integer id) {
        logger.debug("En obtenerDominioPorId: " + id);
        return dominioRepository.findById(id);
    }


    /***
     * actualiza la descripcion del dominio
     * @param dominioModel Identificador,descripcion descripcion
     */
    public DominioModel actualizar(DominioModel dominioModel){
        logger.debug("Actualizando dominio con datos {}", dominioModel.toString());
        dominioModel= dominioRepository.save(dominioModel);
        auditoriaService.registrarAuditoria(dominioModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), dominioModel.getIdDominio());
        return dominioModel;

    }




}