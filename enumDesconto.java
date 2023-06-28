public enum enumDesconto {
    ESTUDANTE(0.5f),
    NAOPOSSUI(0),
    GRATUITO(1);

    private final float desconto;

    enumDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getTipo() {
        return desconto;
    }
}
