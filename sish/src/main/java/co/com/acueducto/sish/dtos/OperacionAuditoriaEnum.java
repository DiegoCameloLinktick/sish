package co.com.acueducto.sish.dtos;

public enum OperacionAuditoriaEnum {
    CREAR(1),
    ACTUALIZAR(2),
    ELIMINAR(3);

    private final int id;

    /***
     * Constuctor del OperacionAuditoriaEnum
     * @param id Identificador
     */
    OperacionAuditoriaEnum(int id) {
        this.id = id;
    }
    public int id() {
        return id;
    }
}
