
import java.util.*;


import java.util.*;


/**
 * Class Desconto
 */
public class Desconto {

  //
  // Fields
  //

  private String tipoDesconto;
  private Date dataInicio;
  private Date dataFim;

  private int porcentagemDesconto;
  
  //
  // Constructors
  //
  public Desconto () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of tipoDesconto
   * @param newVar the new value of tipoDesconto
   */
  private void setTipoDesconto (String newVar) {
    tipoDesconto = newVar;
  }

  /**
   * Get the value of tipoDesconto
   * @return the value of tipoDesconto
   */
  private String getTipoDesconto () {
    return tipoDesconto;
  }

  /**
   * Set the value of dataInicio
   * @param newVar the new value of dataInicio
   */
  private void setDataInicio (Date newVar) {
    dataInicio = newVar;
  }

  /**
   * Get the value of dataInicio
   * @return the value of dataInicio
   */
  private Date getDataInicio () {
    return dataInicio;
  }

  /**
   * Set the value of dataFim
   * @param newVar the new value of dataFim
   */
  private void setDataFim (Date newVar) {
    dataFim = newVar;
  }

  /**
   * Get the value of dataFim
   * @return the value of dataFim
   */
  private Date getDataFim () {
    return dataFim;
  }

  public int getPorcentagemDesconto() {
    return porcentagemDesconto;
  }

  public void setPorcentagemDesconto(int porcentagemDesconto) {
    this.porcentagemDesconto = porcentagemDesconto;
  }

  //
  // Other methods
  //


  /**
   */
  public void verificarValidade()
  {
  }


  /**
   */
  public void aplicarDesconto()
  {
  }


}
