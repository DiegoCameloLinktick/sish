package co.com.acueducto.sish.services.auditoria;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;

public interface IAuditoriaService {
    /***
     * Crear un registro en la tabla
     * @return AuditoriaModel creado
     */
    void registrarAuditoria(Object objeto, OperacionAuditoriaEnum operacion, String nombreEntidad, Integer id);
}
