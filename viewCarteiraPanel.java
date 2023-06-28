import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewCarteiraPanel extends JFrame{
    private JButton voltarButton;
    private JButton adicionarSaldoButton;
    private JLabel saldo;
    private JPanel mainFrame;
    private ControlCadastro cadastroGeral = Singleton.getControlCadastroInstance();
    private JFrame frame = this;
    viewCarteiraPanel() {
        super("Sistema Bilhetagem | Página da Carteira");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 600) / 2;
        int centerY = (int) (screenSize.getHeight() - 400) / 2;

        setLocation(centerX, centerY);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(600, 400);
        saldo.setText("Seu saldo atual: " + cadastroGeral.getUsuarioAutenticado().getSaldo());
        this.setVisible(true);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewUsuarioPanel view = new viewUsuarioPanel();
            }
        });

        adicionarSaldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float valor = Float.parseFloat(JOptionPane.showInputDialog("Digite o saldo que será adicionado: "));
                cadastroGeral.readCadastro().get(cadastroGeral.readCadastro().indexOf(cadastroGeral.getUsuarioAutenticado())).setSaldo(cadastroGeral.getUsuarioAutenticado().getSaldo() + valor);
                saldo.setText("Seu saldo atual: " + cadastroGeral.getUsuarioAutenticado().getSaldo());
            }
        });
    }
}
