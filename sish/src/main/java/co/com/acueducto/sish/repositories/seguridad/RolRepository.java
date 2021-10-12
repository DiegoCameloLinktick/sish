package co.com.acueducto.sish.repositories.seguridad;

import co.com.acueducto.sish.models.seguridad.RolModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RolRepository implements RolRepositoryInterface{

    @PersistenceContext
    EntityManager entityManager;
    /***
     * Obtiene la lista de todos los roles
     * @return Lista de RolModel
     */
    @Override
    public List<RolModel> obtener() {
        String query = "FROM RolModel";
        return entityManager.createQuery(query).getResultList();
    }

    /***
     * Obtiene un rol por identificador
     * @param id Identificador
     * @return RolModel
     */
    @Override
    public RolModel obtenerPorId(Long id) {
        return entityManager.find(RolModel.class, id);
    }

    /***
     * Crear un rol
     * @param rol rol a crear
     * @return RolModel
     */
    @Override
    public RolModel crear(RolModel rol) {
        return entityManager.merge(rol);
    }

    /***
     * Actualizar un rol
     * @param rol a actualizar
     * @return RolModel
     */
    @Override
    public RolModel actualizar(RolModel rol) {
        return entityManager.merge(rol);
    }

    /***
     * Obtiene la lista de los roles activos
     * @return Lista de RolModel
     */
    @Override
    public List<RolModel> obtenerActivos() {
        String query = "FROM RolModel WHERE activo = :activo";
        return entityManager.createQuery(query)
                .setParameter("activo", "S")
                .getResultList();

    }

    /***
     * Obtiene una lista de roles activos basado en una lista de nombres de roles
     * @param roles lista de nombre de roles
     * @return lista de RolModel
     */
    public List<RolModel> obtenerPorListaRoles(List<String> roles) {
        String query = "FROM RolModel WHERE activo = :activo and rol in :roles";
        return entityManager.createQuery(query)
                .setParameter("activo", "S")
                .setParameter("roles", roles)
                .getResultList();

    }
}
