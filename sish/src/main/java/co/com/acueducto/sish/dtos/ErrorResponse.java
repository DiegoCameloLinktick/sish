package co.com.acueducto.sish.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @Getter @Setter
    private int status;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private Date timestamp;
    @Getter @Setter
    List<String> errors;

    ErrorResponse(String message) {
        this.message = message;
    }

}