import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControlCatraca {

    private ModelCatraca modelCatrada;

    private ControlCadastro cadastroGeral = Singleton.getControlCadastroInstance();
    public ControlCatraca() {
        modelCatrada = Principal.modelCatraca;
    }

    public void validarPassagem(Rotas rota) throws minhaExcecao {
        float valorPassagem = 4 * (1 - cadastroGeral.getUsuarioAutenticado().getDesconto().getTipo());
        if(cadastroGeral.getUsuarioAutenticado().getSaldo() - valorPassagem < 0) {
            throw new minhaExcecao("Seu saldo é insuficiente! Saldo: " + cadastroGeral.getUsuarioAutenticado().getSaldo() + " | Valor da passagem: " + valorPassagem);
        }
        cadastroGeral.readCadastro().get(cadastroGeral.readCadastro().indexOf(cadastroGeral.getUsuarioAutenticado())).setSaldo(cadastroGeral.getUsuarioAutenticado().getSaldo() - valorPassagem);
        modelCatrada.getCatraca().autorizarAcesso();

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formatter);

        cadastroGeral.readCadastro().get(cadastroGeral.readCadastro().indexOf(cadastroGeral.getUsuarioAutenticado())).adicionarHistorico(new HistoricoUso(rota.getOrigem() + " -> " + rota.getDestino(), dataFormatada, valorPassagem));
    }
 }
