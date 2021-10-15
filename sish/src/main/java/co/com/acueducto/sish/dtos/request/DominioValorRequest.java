package co.com.acueducto.sish.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class DominioValorRequest {

    @JsonProperty("idDominio")
    @Getter @Setter
    private Integer idDominio;

    @JsonProperty("descripcion")
    @Getter @Setter
    private String descripcion;

}
