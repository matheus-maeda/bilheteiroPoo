import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewAdministradorPanel extends JFrame{
    private JPanel mainFrame;
    private JLabel labelNome;
    private JButton cadastrosButton;
    private JButton horariosButton;
    private JButton rotasButton;
    private JButton descontosButton;
    private JPanel panelButton;
    private JPanel panelLogin;
    private JButton deslogarButton;

    private JFrame frame = this;

    private ControlCadastro cadastroGeral = Singleton.getControlCadastroInstance();

    viewAdministradorPanel() {
        super("Sistema Bilhetagem | Página do Administrador");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 600) / 2;
        int centerY = (int) (screenSize.getHeight() - 400) / 2;

        setLocation(centerX, centerY);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(600, 400);
        labelNome.setText("Usuário autenticado: " + cadastroGeral.getUsuarioAutenticado().getUsuario().getNome());
        this.setVisible(true);

        cadastrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewCadastroPanel view = new viewCadastroPanel();
            }
        });

        descontosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewDescontoPanel view = new viewDescontoPanel();
            }
        });

        rotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewRotasPanel view = new viewRotasPanel();
            }
        });

        horariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewHorariosPanel view = new viewHorariosPanel();
            }
        });

        deslogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                cadastroGeral.setCadastroAutenticado(null);
                viewPrincipal view = new viewPrincipal();
            }
        });
    }
}
