package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;

import java.util.ArrayList;


public interface DominioServiceInterface {

    ArrayList<DominioModel> obtenerDominios();

    DominioModel obtenerPorId(Long id);


}
