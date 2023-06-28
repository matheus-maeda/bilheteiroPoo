import java.util.ArrayList;

public interface Integracao {
    public abstract ArrayList<String> getNomeIntegrantes();
    public abstract String descricaoProjeto();
    public abstract String horaSistema();
    public abstract ArrayList<String> getClasses();
    public abstract void iniciar();
}
