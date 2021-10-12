package co.com.acueducto.sish.repositories.seguridad;

import co.com.acueducto.sish.dtos.UsuarioDTO;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.seguridad.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<DominioModel, Integer> {


    /***
     * Obtiene una lista de roles activos basado en una lista de nombres de roles
     * @param roles lista de nombre de roles
     * @return lista de RolModel
     */
    @Query("SELECT r FROM RolModel r WHERE activo = 'S'  and rol in :roles")
    List<RolModel> obtenerPorListaRoles(@Param("roles") List<String> roles);


}
