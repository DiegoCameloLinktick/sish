package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.dtos.configuracion.MetodoXTipoParametroDTO;
import co.com.acueducto.sish.models.configuracion.MetodoXTipoParametroModel;
import co.com.acueducto.sish.models.configuracion.ParametroXEstacionModel;
import co.com.acueducto.sish.repositories.configuracion.MetodoXTipoParametroRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.seguridad.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoXTipoParametroService implements IMetodoXTipoParametroService{

    @Autowired
    MetodoXTipoParametroRepository metodoXTipoParametroRepository;
    @Autowired
    AuditoriaService auditoriaService;

    private static final Logger logger = LoggerFactory.getLogger(MetodoXTipoParametroService.class);


    /***
     * Obtiene la lista de los metodos por tipo parametro para la consulta
     * @return lista de MetodoXTipoParametroDTO
     */
    public List<MetodoXTipoParametroDTO> findLinstMetodoXTipoParametro(Integer id) {
        logger.debug("En obtenerListaParametros");
        return metodoXTipoParametroRepository.findLinstMetodoXTipoParametro(id);

    }

    /***
     * Crear una relacion de parametros por estacion
     * @param metodoXTipoParametroModel valor de metodo por tipo parametro
     * @return metodoXTipoParametroModel creado
     */
    public MetodoXTipoParametroModel crear(MetodoXTipoParametroModel metodoXTipoParametroModel)  {
        logger.debug("Creando valores de los metodos por tipo parametro {}", metodoXTipoParametroModel.toString());
        if (metodoXTipoParametroRepository.valorMetodoXTipoParametro(metodoXTipoParametroModel.getIdTipoParametro(),metodoXTipoParametroModel.getIdMetodo())) {
            throw new DuplicateKeyException("Ya existe el metodos por tipo parametro: " + metodoXTipoParametroModel.toString());
        }
        metodoXTipoParametroModel = metodoXTipoParametroRepository.save(metodoXTipoParametroModel);
        auditoriaService.registrarAuditoria(metodoXTipoParametroModel, OperacionAuditoriaEnum.CREAR,
                RolService.class.toString(), metodoXTipoParametroModel.getIdMetodoXTipoParametro());
        return metodoXTipoParametroModel;
    }

    /***
     * actualiza el metodos por tipo parametro
     * @param metodoXTipoParametroModel Identificador,descripcion
     */
    public MetodoXTipoParametroModel actualizar(MetodoXTipoParametroModel metodoXTipoParametroModel){
        logger.debug("Actualizando metodos por tipo parametro {}", metodoXTipoParametroModel.toString());
        metodoXTipoParametroModel= metodoXTipoParametroRepository.save(metodoXTipoParametroModel);
        auditoriaService.registrarAuditoria(metodoXTipoParametroModel, OperacionAuditoriaEnum.ACTUALIZAR,
                DominioService.class.toString(), metodoXTipoParametroModel.getIdMetodoXTipoParametro());
        return metodoXTipoParametroModel;

    }



}
