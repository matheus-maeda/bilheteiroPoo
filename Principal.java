import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static ModelCadastro modelCadastro;
    public static ModelRotas modelRotas;

    public static ModelCatraca modelCatraca;

    Principal() {
        modelCadastro = new ModelCadastro();

        Cadastro cadastro = new Cadastro(new Usuario("Matheus Mazali Maeda", "matheus", "123"), enumTipo.ADMINISTRADOR);

        modelCadastro.cadastrarCadastro(cadastro);

        cadastro = new Cadastro(new Usuario("Mabyly Neres", "maby", "123"), enumTipo.USUARIO);
        cadastro.setDesconto(enumDesconto.ESTUDANTE);

        modelCadastro.cadastrarCadastro(cadastro);

        cadastro = new Cadastro(new Usuario("Alexandre", "ale", "123"), enumTipo.MOTORISTA);
        cadastro.setDesconto(enumDesconto.GRATUITO);

        modelCadastro.cadastrarCadastro(cadastro);

        modelRotas = new ModelRotas();

        modelRotas.addRotas(new Rotas("Terminal", "Bairro", "Rua Bauru, Rua Brasilia, Avenida São João", new MicroOnibus()));
        modelRotas.addRotas(new Rotas("Bairro", "Terminal", "Avenida São João, Rua Brasilia, Rua Bauru", new OnibusConvencional()));

        modelCatraca = new ModelCatraca();

        viewPrincipal view = new viewPrincipal();
    }

}
