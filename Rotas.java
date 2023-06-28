
import java.util.*;

/**
 * Class Rotas
 */
public class Rotas {
  //
  // Fields
  //

  private String origem;
  private String destino;
  private String pontosParadas;
  private ArrayList<Horario> horarios;
  private IOnibus onibus;
  
  //
  // Constructors
  //

  public Rotas(String origem, String destino, String pontosParadas, IOnibus onibus) {
    this.origem = origem;
    this.destino = destino;
    this.pontosParadas = pontosParadas;
    horarios = new ArrayList<Horario>();
    for (int i = 0; i < 6; i++) {
      horarios.add(new Horario("00:00", "00:00"));
    }
    this.onibus = onibus;
  }


  //
  // Methods
  //


  //
  // Accessor methods
  //


  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public String getPontosParadas() {
    return pontosParadas;
  }

  public void setPontosParadas(String pontosParadas) {
    this.pontosParadas = pontosParadas;
  }

  public ArrayList<Horario> getHorarios() {
    return horarios;
  }

  public void setHorarios(ArrayList<Horario> horarios) {
    this.horarios = horarios;
  }

  public IOnibus getOnibus() {
    return onibus;
  }

  public void setOnibus(IOnibus onibus) {
    this.onibus = onibus;
  }
}
