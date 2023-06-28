
import java.lang.reflect.Array;
import java.util.*;

/**
 * Class Cadastro
 */
public class Cadastro {

  //
  // Fields
  //

  private Usuario usuario;
  private enumTipo permissao;
  private enumDesconto desconto;
  private float saldo;
  private ArrayList<HistoricoUso> historicoUso;

  //
  // Constructors
  //

  public Cadastro(Usuario usuario, enumTipo permissao) {
    this.usuario = usuario;
    this.permissao = permissao;
    this.desconto = enumDesconto.NAOPOSSUI;
    this.saldo = 0;
    this.historicoUso = new ArrayList<HistoricoUso>();
  }


  //
  // Accessor methods
  //


  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public enumTipo getPermissao() {
    return permissao;
  }

  public void setPermissao(enumTipo permissao) {
    this.permissao = permissao;
  }

  public enumDesconto getDesconto() {
    return desconto;
  }

  public void setDesconto(enumDesconto desconto) {
    this.desconto = desconto;
  }

  public float getSaldo() {
    return saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public ArrayList<HistoricoUso> getHistoricoUso() {
    return historicoUso;
  }

  public void setHistoricoUso(ArrayList<HistoricoUso> historicoUso) {
    this.historicoUso = historicoUso;
  }
  public void adicionarHistorico(HistoricoUso historico) {
    this.historicoUso.add(historico);
  }
}


