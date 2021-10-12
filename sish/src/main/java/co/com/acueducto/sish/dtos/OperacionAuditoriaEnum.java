package co.com.acueducto.sish.dtos;

public enum OperacionAuditoriaEnum {
    CREAR(1),
    ACTUALIZAR(2),
    ELIMINAR(3),
    CONSULTAR(4),
    LLAMADO_SERVICIO(5);

    private final int id;

    OperacionAuditoriaEnum(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
