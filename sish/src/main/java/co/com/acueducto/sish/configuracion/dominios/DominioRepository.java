package co.com.acueducto.sish.configuracion.dominios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.acueducto.sish.configuracion.dominios.models.DominioModel;

@Repository
public interface DominioRepository extends CrudRepository<DominioModel, Long> {
    public abstract ArrayList<DominioModel> findByDominio(String dominio);

}