
import java.util.*;

/**
 * Class HistoricoUso
 */
public class HistoricoUso {

    //
    // Fields
    //

    private String linha;
    private String data;
    private float valor;

    //
    // Constructors
    //

    public HistoricoUso(String linha, String data, float valor) {
        this.linha = linha;
        this.data = data;
        this.valor = valor;
    }


    //
    // Methods
    //


    //
    // Accessor methods
    //

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
