package co.com.acueducto.sish.dtos.configuracion;

public interface ParametroXEstacionDTO {

    /***
     * Llave primaria
     */
    Integer getIdParametro();

    /***
     *Nombre  del parámetro
     */
    String getParametro();

    /***
     *Codigo  del parámetro
     */
    String getCodigo();

    /***
     *Descripcion del parámetro
     */
    String getDescripcion();

    String getEstacion();
    Integer getIdEstacion();
    Integer getIdParametroXEstacion();
}
