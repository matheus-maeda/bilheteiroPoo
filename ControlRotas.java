
import java.util.*;

/**
 * Class ControlRotas
 */
public class ControlRotas {

    //
    // Fields
    //

    private ModelRotas modelRotas;

    //
    // Constructors
    //
    public ControlRotas () {
        this.modelRotas = Principal.modelRotas;
    };

    //
    // Methods
    //



    //
    // Accessor methods
    //

    //
    // Other methods
    //

    /**
     */
    public void createRotas(String origem, String destino, String caminho, IOnibus onibus) throws minhaExcecao
    {
        for (Rotas rota : modelRotas.getRotas()) {
            if (rota.getOrigem().equals(origem) && rota.getDestino().equals(destino) && rota.getPontosParadas().equals(caminho)) {
                throw new minhaExcecao("Essa rota já está cadastrada!");
            }
        }
        modelRotas.addRotas(new Rotas(origem, destino, caminho, onibus));
    }



    /**
     */
    public ArrayList<Rotas> readRotas()
    {
        return modelRotas.getRotas();
    }


    /**
     */
    public void updateRotas(int indice, String origem, String destino, String caminho, IOnibus onibus) throws minhaExcecao
    {
        for (Rotas rota : readRotas()) {
            if(rota.getOrigem().equals(rota) && rota.getDestino().equals(destino) && rota.getPontosParadas().equals(caminho)) {
                throw new minhaExcecao("Essa rota já está cadastrada!");
            }
            modelRotas.getRotas().get(indice).setDestino(destino);
            modelRotas.getRotas().get(indice).setPontosParadas(caminho);
            modelRotas.getRotas().get(indice).setOrigem(origem);
            modelRotas.getRotas().get(indice).setOnibus(onibus);
        }
    }


    /**
     */
    public void deleteRotas(int indice)
    {
        modelRotas.getRotas().remove(indice);
    }


}
