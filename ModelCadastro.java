
import java.util.*;


/**
 * Class ModelCadastro
 */
public class ModelCadastro {

  //
  // Fields
  //

  private ArrayList<Cadastro> cadastros;
  private Cadastro cadastroAutenticado;

  //
  // Constructors
  //
  public ModelCadastro () {
      cadastros = new ArrayList<>();
      cadastroAutenticado = null;
  };
  
  //
  // Methods
  //

  public void cadastrarCadastro(Cadastro cadastro)
  {
    cadastros.add(cadastro);
  }


  //
  // Accessor methods
  //

  public ArrayList<Cadastro> getCadastros() {
    return cadastros;
  }

  public void setCadastros(ArrayList<Cadastro> cadastros) {
    this.cadastros = cadastros;
  }

  public Cadastro getCadastroAutenticado() {
    return cadastroAutenticado;
  }

  public void setCadastroAutenticado(Cadastro cadastroAutenticado) {
    this.cadastroAutenticado = cadastroAutenticado;
  }

  //
  // Other methods
  //

  /**
   */
  public void createCadastro()
  {
  }


  /**
   */
  public void readCadastro()
  {
  }


  /**
   */
  public void updateCadastro()
  {
  }


  /**
   */
  public void deleteCadastro()
  {
  }
}
