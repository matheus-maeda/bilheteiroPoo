
import java.util.*;
/**
 * Class Catraca
 */
public class Catraca {

  //
  // Fields
  //

  private boolean liberado;

  private String estado;
  
  //
  // Constructors
  //
  public Catraca () { };
  
  //
  // Methods
  //


  public boolean isLiberado() {
    return liberado;
  }

  public void setLiberado(boolean liberado) {
    this.liberado = liberado;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public void autorizarAcesso()
  {
    this.liberado = true;
  }

  public void passou() {
    this.liberado = false;
  }

}
