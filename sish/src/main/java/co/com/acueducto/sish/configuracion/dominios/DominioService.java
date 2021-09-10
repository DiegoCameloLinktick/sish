package co.com.acueducto.sish.configuracion.dominios;

import java.util.ArrayList;
import java.util.Optional;

import co.com.acueducto.sish.configuracion.dominios.models.DominioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DominioService {
    @Autowired
    DominioRepository dominioRepository;
    
    public ArrayList<DominioModel> obtenerDominios(){
        return (ArrayList<DominioModel>) dominioRepository.findAll();
    }

    public DominioModel guardarDominio(DominioModel dominio){
        return dominioRepository.save(dominio);
    }

    public Optional<DominioModel> obtenerPorId(Long id){
        return dominioRepository.findById(id);
    }


    public ArrayList<DominioModel>  obtenerPorDominio(String dominio) {
        return dominioRepository.findByDominio(dominio);
    }

    public boolean eliminarDominio(Long id) {
        try{
            dominioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}