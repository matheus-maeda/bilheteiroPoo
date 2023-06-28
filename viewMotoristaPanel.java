import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewMotoristaPanel extends JFrame {
    private JButton voltarButton;
    private JButton visualizarRotasButton;
    private JPanel mainFrame;
    private JLabel labelNome;
    private JButton visualizarHorariosButton;
    private ControlCadastro cadastroGeral = Singleton.getControlCadastroInstance();
    private JFrame frame = this;
    viewMotoristaPanel() {
        super("Sistema Bilhetagem | Página do Motorista");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 600) / 2;
        int centerY = (int) (screenSize.getHeight() - 400) / 2;

        setLocation(centerX, centerY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(600, 400);
        labelNome.setText("Usuário autenticado: "+ cadastroGeral.getUsuarioAutenticado().getUsuario().getNome());
        this.setVisible(true);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                cadastroGeral.setCadastroAutenticado(null);
                viewPrincipal view = new viewPrincipal();
            }
        });

        visualizarRotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewRotasPanel view = new viewRotasPanel();
            }
        });

        visualizarHorariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewHorariosPanel view = new viewHorariosPanel();
            }
        });
    }
}
