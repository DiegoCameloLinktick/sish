package co.com.acueducto.sish.repositories.configuracion;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.acueducto.sish.models.configuracion.DominioModel;

@Repository
public interface DominioRepository extends CrudRepository<DominioModel, Long> {
    public abstract ArrayList<DominioModel> findByDominio(String dominio);

}