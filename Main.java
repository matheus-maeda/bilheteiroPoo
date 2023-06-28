import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main implements Integracao{
    public static void main(String[] args) {
        new Principal();
    }

    @Override
    public ArrayList<String> getNomeIntegrantes() {
        ArrayList<String> nomeIntegrantes = new ArrayList<>();
        nomeIntegrantes.add("MATHEUS MAZALI MAEDA");
        nomeIntegrantes.add("ALEXANDRE APARECIDO DA SILVA");
        nomeIntegrantes.add("MABYLLY KAUANY NERES DA SILVA");
        return null;
    }

    @Override
    public String descricaoProjeto() {
        return "Nosso projeto consiste em um Bilheteiro inteligente com diversas funções para quem usa e para quem administra os ônibus da prefeitura.";
    }

    @Override
    public String horaSistema() {
        LocalTime horaAtual = LocalTime.now();

        // Formata a hora atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = horaAtual.format(formatter);
        return horaFormatada;
    }

    @Override
    public ArrayList<String> getClasses() {
        ArrayList<String> nomesClasses = new ArrayList<>();

        nomesClasses.add("Cadastro.java");
        nomesClasses.add("Carteira.java");
        nomesClasses.add("Catraca.java");
        nomesClasses.add("ControlCadastro.java");
        nomesClasses.add("ControlCatraca.java");
        nomesClasses.add("ControlRotas.java");
        nomesClasses.add("enumDesconto.java");
        nomesClasses.add("enumTipo.java");
        nomesClasses.add("HistoricoUso.java");
        nomesClasses.add("Desconto.java");
        nomesClasses.add("Integracao.java");
        nomesClasses.add("IOnibus.java");
        nomesClasses.add("Main.java");
        nomesClasses.add("MicroOnibus.java");
        nomesClasses.add("minhaExcecao.java");
        nomesClasses.add("ModelCadastro.java");
        nomesClasses.add("ModelCatraca.java");
        nomesClasses.add("ModelRotas.java");
        nomesClasses.add("OnibusConvencional.java");
        nomesClasses.add("Principal.java");
        nomesClasses.add("Rotas.java");
        nomesClasses.add("Singleton.java");
        nomesClasses.add("Usuario.java");
        nomesClasses.add("viewAdministradorPanel.java");
        nomesClasses.add("viewCadastroPanel.java");
        nomesClasses.add("viewCarteiraPanel.java");
        nomesClasses.add("viewCatracaPanel.java");
        nomesClasses.add("viewDescontoPanel.java");
        nomesClasses.add("viewHistoricoPanel.java");
        nomesClasses.add("viewHorarioPanel.java");
        nomesClasses.add("viewMotoristaPanel.java");
        nomesClasses.add("viewPrincipalPanel.java");
        nomesClasses.add("viewRotasPanel.java");
        nomesClasses.add("viewUsuarioPanel.java");
        return nomesClasses;
    }

    @Override
    public void iniciar() {
        new Principal();
    }
}