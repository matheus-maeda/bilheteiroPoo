public class Horario {
  private String origem;
  private String chegada;

  public Horario(String origem, String chegada) {
    this.origem = origem;
    this.chegada = chegada;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getChegada() {
    return chegada;
  }

  public void setChegada(String chegada) {
    this.chegada = chegada;
  }
}