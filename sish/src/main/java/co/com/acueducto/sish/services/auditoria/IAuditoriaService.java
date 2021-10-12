package co.com.acueducto.sish.services.auditoria;

import co.com.acueducto.sish.models.auditoria.AuditoriaModel;

public interface IAuditoriaService {
    /***
     * Crear un registro en la tabla
     * @return AuditoriaModel creado
     */
    AuditoriaModel crear(AuditoriaModel auditoriaModel);
}
