import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class viewCatracaPanel extends JFrame {
    private JButton voltarButton;
    private JButton pagarPassagemButton;
    private JButton passarPelaCatracaButton;
    private JScrollPane scrollPanel;
    private JPanel mainFrame;
    private JLabel labelEstado;
    private ControlRotas controlRotas = Singleton.getControlRotas();
    private ControlCatraca controlCatraca = Singleton.getControlCatraca();
    private ControlCadastro cadastrolGeral = Singleton.getControlCadastroInstance();
    private JFrame frame = this;
    viewCatracaPanel() {
        super("Sistema Bilhetagem | Página da Catraca");

        JTable table1 = new JTable(retornarTabela());
        scrollPanel.setViewportView(table1);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 800) / 2;
        int centerY = (int) (screenSize.getHeight() - 600) / 2;

        labelEstado.setText("CATRACA FECHADA");

        setLocation(centerX, centerY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(800, 600);
        this.setVisible(true);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewUsuarioPanel view = new viewUsuarioPanel();
            }
        });

        pagarPassagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() == -1) return;
                if(labelEstado.getText() == "CATRACA LIBERADA") return;
                try {
                    controlCatraca.validarPassagem(controlRotas.readRotas().get(table1.getSelectedRow()));
                }
                catch(minhaExcecao ex) {
                        JOptionPane.showMessageDialog(mainFrame, ex.getMessage());
                        return;
                }

                labelEstado.setText("CATRACA LIBERADA");
            }
        });

        passarPelaCatracaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(labelEstado.getText() != "CATRACA LIBERADA") return;
                labelEstado.setText("CATRACA FECHADA");
            }
        });
    }

    public DefaultTableModel retornarTabela() {
        DefaultTableModel model = new DefaultTableModel();
        String destino = new String(" ");
        model.addColumn("Origem");
        model.addColumn("Destino");
        model.addColumn("Caminho");
        model.addColumn("Onibus");

        // Adiciona linhas ao modelo de tabela
        for(Rotas rota : controlRotas.readRotas()) {
            model.addRow(new Object[]{rota.getOrigem(), rota.getDestino(), rota.getPontosParadas(), rota.getOnibus().getClass().getName()});
        }

        return model;
    }
}
