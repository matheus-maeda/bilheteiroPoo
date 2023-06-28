
import java.util.*;



/**
 * Class Usuario
 */
public class Usuario {

  //
  // Fields
  //

  private String nome;
  private String email;
  private String senha;

  //
  // Constructors
  //

  public Usuario(String nome, String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }


  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of nome
   * @param newVar the new value of nome
   */
  public void setNome (String newVar) {
    nome = newVar;
  }

  /**
   * Get the value of nome
   * @return the value of nome
   */
  public String getNome () {
    return nome;
  }

  /**
   * Set the value of email
   * @param newVar the new value of email
   */
  public void setEmail (String newVar) {
    email = newVar;
  }

  /**
   * Get the value of email
   * @return the value of email
   */
  public String getEmail () {
    return email;
  }

  /**
   * Set the value of senha
   * @param newVar the new value of senha
   */
  public void setSenha (String newVar) {
    senha = newVar;
  }

  /**
   * Get the value of senha
   * @return the value of senha
   */
  public String getSenha () {
    return senha;
  }


}
