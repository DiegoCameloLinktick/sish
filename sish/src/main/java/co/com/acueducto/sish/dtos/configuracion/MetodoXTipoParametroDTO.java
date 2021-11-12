package co.com.acueducto.sish.dtos.configuracion;

public interface MetodoXTipoParametroDTO {

    /***
     * Llave primaria
     */
    Integer getIdMetodoXTipoParametro();
    /***
     * id tipo paramtero
     */
    Integer getIdTipoParametro();
    /***
     * id metodo
     */
    Integer getIdMetodo();
    /***
     * tipo parametro
     */
    String getTipoParametro();
    /***
     * metodo
     */
    String getMetodo();
}
