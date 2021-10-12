package co.com.acueducto.sish.repositories.auditoria;

import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 *  Clase de definición de acceso a datos de la auditoría
 */
@Repository
public interface AuditoriaRepository extends JpaRepository<AuditoriaModel, Integer> {
}
