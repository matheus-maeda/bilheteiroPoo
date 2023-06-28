import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewUsuarioPanel extends JFrame {
    private JPanel mainFrame;
    private JLabel labelNome;
    private JButton deslogarButton;
    private JButton historicoButton;
    private JButton catracaButton;
    private JButton carteiraButton;
    private JButton consultarHoráriosButton;
    private JFrame frame = this;

    private ControlCadastro cadastroGeral = Singleton.getControlCadastroInstance();

    viewUsuarioPanel() {
        super("Sistema Bilhetagem | Página do Usuário");

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

        deslogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                cadastroGeral.setCadastroAutenticado(null);
                viewPrincipal view = new viewPrincipal();
            }
        });

        consultarHoráriosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewHorariosPanel view = new viewHorariosPanel();
            }
        });

        carteiraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewCarteiraPanel view = new viewCarteiraPanel();
            }
        });

        catracaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewCatracaPanel view = new viewCatracaPanel();
            }
        });

        historicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewHistoricoPanel view = new viewHistoricoPanel();
            }
        });
    }
}
