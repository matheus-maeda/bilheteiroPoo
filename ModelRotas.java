
import java.util.*;

/**
 * Class ModelRotas
 */
public class ModelRotas {

    //
    // Fields
    //

    private ArrayList<Rotas> rotas;

    //
    // Constructors
    //
    public ModelRotas () {
        rotas = new ArrayList<Rotas>();
    };

    //
    // Methods
    //

    public void addRotas(Rotas rotas) {
        this.rotas.add(rotas);
    }

    public ArrayList<Rotas> getRotas() {
        return this.rotas;
    }

    //
    // Accessor methods
    //

    //
    // Other methods
    //
}
