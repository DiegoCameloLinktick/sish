package co.com.acueducto.sish.repositories;

import java.util.ArrayList;

import co.com.acueducto.sish.models.DominioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DominioRepository extends CrudRepository<DominioModel, Long> {
    public abstract ArrayList<DominioModel> findByDominio(String dominio);

}