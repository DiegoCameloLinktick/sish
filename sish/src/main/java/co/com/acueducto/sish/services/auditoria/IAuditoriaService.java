package co.com.acueducto.sish.services.auditoria;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;

public interface IAuditoriaService {
    /***
     * Crear un registro en la tabla
     * @return AuditoriaModel creado
     */
    void registrarAuditoria(Object objeto, String usuario, OperacionAuditoriaEnum operacion, String nombreEntidad, Integer id) throws Exception;
}
