
import java.lang.reflect.Array;
import java.util.*;


/**
 * Class ControlCadastro
 */
public class ControlCadastro {
  //
  // Fields
  //

  private ModelCadastro modelCadastro;
  //
  // Constructors
  //
  public ControlCadastro () {
    this.modelCadastro = Principal.modelCadastro;
  };

  //
  // Methods
  //

  public void createCadastro(Cadastro novoCadastro) throws minhaExcecao
  {
    for (Cadastro cadastro : this.readCadastro()) {
      if(cadastro.getUsuario().getEmail().equals(novoCadastro.getUsuario().getEmail())) {
        throw new minhaExcecao("Este E-Mail já está sendo utilizado!");
      }
    }
    this.modelCadastro.cadastrarCadastro(novoCadastro);
  }

  public ArrayList<Cadastro> readCadastro() {
    return this.modelCadastro.getCadastros();
  }

  public void atualizarUsuarios(int selectedRow, String nome, String email, String senha, enumTipo selecionado)  throws minhaExcecao
  {
    int index = 0;
    for (Cadastro cadastro : this.readCadastro()) {
      if(cadastro.getUsuario().getEmail().equals(email)) {
        if(index != selectedRow) throw new minhaExcecao("Este E-Mail já está sendo utilizado!");
      }
      index = index + 1;
    }

    this.readCadastro().get(selectedRow).setUsuario(new Usuario(nome, email, senha));
    this.readCadastro().get(selectedRow).setPermissao(selecionado);
  }

  public void removerUsuarios(int selectedRow)
  {
    this.readCadastro().remove(this.readCadastro().get(selectedRow));
  }

  public boolean autenticarUsuario(String user, String password) {
    for(Cadastro cadastro : modelCadastro.getCadastros()) {
      if(cadastro.getUsuario().getEmail().equals(user) && cadastro.getUsuario().getSenha().equals(password)) {
        this.setCadastroAutenticado(cadastro);
        return true;
      }
    }
    return false;
  }

  //
  // Accessor methods
  //

  public Cadastro getUsuarioAutenticado() {
    return this.modelCadastro.getCadastroAutenticado();
  }

  public void setCadastroAutenticado(Cadastro cadastroAutenticado) {
    this.modelCadastro.setCadastroAutenticado(cadastroAutenticado);
  }
}
