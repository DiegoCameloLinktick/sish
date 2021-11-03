package co.com.acueducto.sish.dtos;


public interface ParametroDTO {
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

    /***
     *Identificador de la unidad De medidad del parámetro
     */
    Integer getIdUnidadMedida();

    /***
     *Identificador del tipo de parámetro
     */
    Integer getIdTipoParametro();

    /***
     *Identificador del método del parámetro
     */
    Integer getIdMetodo();


    /***
     *Nombre de la unidad de medidad del parámetro
     */
    String getNombreUnidadMedida();

    /***
     *Nombre del tipo de parámetro
     */
    String getNombreTipoParametro();

    /***
     *nombre del método del parámetro
     */
    String getNombreMetodo();


}
