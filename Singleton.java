public class Singleton {
    private static ControlCadastro controlCadastroInstance;
    private static ControlRotas controlRotasInstance;
    private static ControlCatraca controlCatracaInstance;

    private Singleton() {
    }

    public static ControlCadastro getControlCadastroInstance() {
        if (controlCadastroInstance == null) {
            controlCadastroInstance = new ControlCadastro();
        }
        return controlCadastroInstance;
    }
    public static ControlRotas getControlRotas() {
        if (controlRotasInstance == null) {
            controlRotasInstance = new ControlRotas();
        }
        return controlRotasInstance;
    }

    public static ControlCatraca getControlCatraca() {
        if (controlCatracaInstance == null) {
            controlCatracaInstance = new ControlCatraca();
        }
        return controlCatracaInstance;
    }
}