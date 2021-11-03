package co.com.acueducto.sish.dtos;


import java.util.Date;

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

    /***
     *estado parámetro
     */
    String getActivo();
    /***
     *fecha de creacion del parámetro
     */
    Date getFechaCreacion();
    /***
     *fecha modificacion del parámetro
     */
    Date getFechaModificacion();
    /***
     *nombre del mfecha de cambio de estado del parámetro
     */
    Date getFechaEstado();
    /***
     *usuario creacion del parámetro
     */
    String getUsuarioCreacion();
    /***
     *usuario modificacion del parámetro
     */
    String getUsuarioModificacion();
    /***
     *usuario que cambia el estado del parámetro
     */
    String getUsuarioEstado();

}
