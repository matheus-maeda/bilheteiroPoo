import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewPrincipal extends JFrame {
    private JPanel mainFrame;
    private JTextField inputUser;
    private JPasswordField inputPassword;
    private JLabel labelUser;
    private JLabel labelPassword;
    private JButton logarButton;
    private JPanel labelPane;
    private JPanel inputsFrame;
    private JButton Cadastar;
    JFrame frame = this;

    public viewPrincipal(){
        super("Sistema Bilhetagem | Página de Login");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 600) / 2;
        int centerY = (int) (screenSize.getHeight() - 200) / 2;

        setLocation(centerX, centerY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(600, 200);
        this.setVisible(true);
        ControlCadastro cadastroGeral = new ControlCadastro();


        logarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cadastroGeral.autenticarUsuario(inputUser.getText(), new String(inputPassword.getPassword()))) {
                    frame.dispose();
                    switch(cadastroGeral.getUsuarioAutenticado().getPermissao()) {
                        case ADMINISTRADOR:
                            viewAdministradorPanel viewAdmin = new viewAdministradorPanel();
                            break;
                        case USUARIO:
                            viewUsuarioPanel viewUser = new viewUsuarioPanel();
                            break;
                        case MOTORISTA:
                            viewMotoristaPanel viewMotorista = new viewMotoristaPanel();
                            break;
                    }
                }
            }
        });

        Cadastar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = JOptionPane.showInputDialog("Digite o email:");
                String senha = JOptionPane.showInputDialog("Digite a senha:");
                String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo:");

                Cadastro novo = (new Cadastro(new Usuario(nomeCompleto, email, senha), enumTipo.USUARIO));
                novo.setDesconto(enumDesconto.NAOPOSSUI);

                try {
                    cadastroGeral.createCadastro(novo);
                }
                catch(minhaExcecao ex) {
                        JOptionPane.showMessageDialog(mainFrame, ex.getMessage());
                }
            }
        });
    }
}
