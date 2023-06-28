import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewRotasPanel extends JFrame{
    private JButton voltarButton;
    private JTable table1;
    private JButton carregarInformaçõesSelecionadasButton;
    private JPanel mainFrame;
    private JScrollPane scrollPanel;
    private JTextField inputCaminho;
    private JTextField inputOrigem;
    private JTextField inputDestino;
    private JButton adicionarButton;
    private JButton atualizarSelecionadoButton;
    private JButton removerSelecionadoButton;
    private JRadioButton microOnibusRadioButton;
    private JRadioButton onibusConvencionalRadioButton;

    private JFrame frame = this;
    private ControlRotas controlRotas = Singleton.getControlRotas();
    private ControlCadastro cadastroGeral = Singleton.getControlCadastroInstance();
    private IOnibus onibus;

    viewRotasPanel() {
        super("Sistema Bilhetagem | Página de Rotas");

        JTable table1 = new JTable(retornarTabela());
        scrollPanel.setViewportView(table1);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 1200) / 2;
        int centerY = (int) (screenSize.getHeight() - 800) / 2;

        setLocation(centerX, centerY);

        onibus = new OnibusConvencional();
        onibusConvencionalRadioButton.setSelected(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(1200, 800);
        this.setVisible(true);

        if(cadastroGeral.getUsuarioAutenticado().getPermissao() == enumTipo.MOTORISTA) {
            adicionarButton.setVisible(false);
            removerSelecionadoButton.setVisible(false);
            atualizarSelecionadoButton.setVisible(false);
        }

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(cadastroGeral.getUsuarioAutenticado().getPermissao() == enumTipo.MOTORISTA) {
                    viewMotoristaPanel view = new viewMotoristaPanel();
                    return;
                }
                viewAdministradorPanel view = new viewAdministradorPanel();
            }
        });

        carregarInformaçõesSelecionadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() == -1) return;
                Rotas rota = controlRotas.readRotas().get(table1.getSelectedRow());
                inputOrigem.setText(rota.getOrigem());
                inputDestino.setText(rota.getDestino());
                inputCaminho.setText(rota.getPontosParadas());
                if (rota.getOnibus().getClass() == MicroOnibus.class) {
                    onibus = new MicroOnibus();
                    resetarRadios();
                    microOnibusRadioButton.setSelected(true);
                }
                else
                {
                    onibus = new OnibusConvencional();
                    resetarRadios();
                    onibusConvencionalRadioButton.setSelected(true);
                }
            }
        });

        onibusConvencionalRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onibus = new OnibusConvencional();
                resetarRadios();
                onibusConvencionalRadioButton.setSelected(true);
            }
        });

        microOnibusRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onibus = new MicroOnibus();
                resetarRadios();
                microOnibusRadioButton.setSelected(true);
            }
        });

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlRotas.createRotas(inputOrigem.getText(), inputDestino.getText(), inputCaminho.getText(), onibus);
                } catch(minhaExcecao ex) {
                    JOptionPane.showMessageDialog(mainFrame, ex.getMessage());
                }
                table1.setModel(retornarTabela());
                inputCaminho.setText("");
                inputDestino.setText("");
                inputCaminho.setText("");
                resetarRadios();
            }
        });

        atualizarSelecionadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() == -1) return;
                try {
                    controlRotas.updateRotas(table1.getSelectedRow(), inputOrigem.getText(), inputDestino.getText(), inputCaminho.getText(), onibus);
                } catch(minhaExcecao ex) {
                    JOptionPane.showMessageDialog(mainFrame, ex.getMessage());
                }
                table1.setModel(retornarTabela());
                inputCaminho.setText("");
                inputDestino.setText("");
                inputCaminho.setText("");
                resetarRadios();
            }
        });

        removerSelecionadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() == -1) return;
                controlRotas.deleteRotas(table1.getSelectedRow());
                table1.setModel(retornarTabela());
            }
        });
    }
    public void resetarRadios() {
        onibusConvencionalRadioButton.setSelected(false);
        microOnibusRadioButton.setSelected(false);
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
