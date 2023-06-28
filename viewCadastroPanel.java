import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewCadastroPanel extends JFrame {
    private ControlCadastro controlCadastro = Singleton.getControlCadastroInstance();
    private JButton voltarButton;
    private JPanel mainFrame;
    private JTable table1;
    private JButton buttonAdicionar;
    private JTextField inputSenha;
    private JTextField inputNome;
    private JTextField inputEmail;
    private JButton buttonAtualizar;
    private JButton buttonRemover;
    private JButton buttonCarregar;
    private JRadioButton opUsuario;
    private JRadioButton opMotorista;
    private JRadioButton opAdm;
    private JScrollPane scrollPanel;
    private JPanel painelScroll;

    private enumTipo selecionado;
    viewCadastroPanel() {
        super("Sistema Bilhetagem | Página de Cadastros");

        JTable table1 = new JTable(retornarTabela());
        scrollPanel.setViewportView(table1);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 1200) / 2;
        int centerY = (int) (screenSize.getHeight() - 800) / 2;

        setLocation(centerX, centerY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(1200, 800);
        this.setVisible(true);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewAdministradorPanel view = new viewAdministradorPanel();
            }
        });

        buttonAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cadastro novo = new Cadastro(new Usuario(inputNome.getText(), inputEmail.getText(), inputSenha.getText()), enumTipo.USUARIO);
                    controlCadastro.createCadastro(novo);
                }
                catch(minhaExcecao ex) {
                    JOptionPane.showMessageDialog(mainFrame, ex.getMessage());
                    return;
                }
                table1.setModel(retornarTabela());
                resetarText();
                resetarRadios();
            }
        });

        opUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetarRadios();
                opUsuario.setSelected(true);
                selecionado = enumTipo.USUARIO;
            }
        });

        opAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetarRadios();
                opAdm.setSelected(true);
                selecionado = enumTipo.ADMINISTRADOR;
            }
        });

        opMotorista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetarRadios();
                opMotorista.setSelected(true);
                selecionado = enumTipo.MOTORISTA;
            }
        });

        buttonCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() == -1) return;
                resetarText();
                resetarRadios();
                if (table1.getSelectedRow() != -1) {
                    Cadastro cadastro = controlCadastro.readCadastro().get(table1.getSelectedRow());
                    Usuario user = cadastro.getUsuario();
                    inputNome.setText(user.getNome());
                    inputEmail.setText(user.getEmail());
                    inputSenha.setText(user.getSenha());
                    resetarRadios();
                    switch(cadastro.getPermissao()) {
                        case ADMINISTRADOR -> { opAdm.setSelected(true); selecionado = enumTipo.ADMINISTRADOR; }
                        case MOTORISTA -> { opMotorista.setSelected(true); selecionado = enumTipo.MOTORISTA; }
                        case USUARIO -> { opUsuario.setSelected(true); selecionado = enumTipo.USUARIO; }
                    }
                 }
            }
        });

        buttonAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() == -1) return;
                try {
                    controlCadastro.atualizarUsuarios(table1.getSelectedRow(), inputNome.getText(), inputEmail.getText(), inputSenha.getText(), selecionado);
                }
                catch(minhaExcecao ex) {
                    JOptionPane.showMessageDialog(mainFrame, ex.getMessage());
                    return;
                }

                table1.setModel(retornarTabela());
                resetarText();
                resetarRadios();
            }
        });

        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() == -1) return;
                controlCadastro.removerUsuarios(table1.getSelectedRow());
                table1.setModel(retornarTabela());
                resetarText();
                resetarRadios();
            }
        });
    }

    public void resetarRadios() {
        opAdm.setSelected(false);
        opMotorista.setSelected(false);
        opUsuario.setSelected(false);
    }

    public void resetarText() {
        inputEmail.setText("");
        inputNome.setText("");
        inputSenha.setText("");
    }

    public DefaultTableModel retornarTabela() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cargo");
        model.addColumn("Nome completo");
        model.addColumn("Email");
        model.addColumn("Senha");

        for(Cadastro cadastro : controlCadastro.readCadastro()) {
            model.addRow(new Object[]{cadastro.getPermissao().getTipo(), cadastro.getUsuario().getNome(), cadastro.getUsuario().getEmail(), cadastro.getUsuario().getSenha()});
        }

        return model;
    }
}
