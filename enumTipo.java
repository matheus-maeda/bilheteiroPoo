public enum enumTipo {
    MOTORISTA("Motorista"),
    ADMINISTRADOR("Administrador"),
    USUARIO("Usuario");

    private final String tipo;

    enumTipo(String descricao) {
        this.tipo = descricao;
    }

    public String getTipo() {
        return tipo;
    }
}