import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewDescontoPanel extends JFrame{
    private JPanel mainFrame;
    private JButton voltarButton;
    private JButton definirDescontoParaCadastroButton;
    private JRadioButton estudanteRadioButton;
    private JRadioButton naoPossuiRadioButton;
    private JRadioButton gratuitoRadioButton;
    private JScrollPane scrollPanel;
    private enumDesconto selecionado = enumDesconto.NAOPOSSUI;
    private JFrame frame = this;
    private ControlCadastro controlCadastro= Singleton.getControlCadastroInstance();

    viewDescontoPanel() {
        super("Sistema Bilhetagem | Página de Descontos");

        JTable tableUsuarios = new JTable(retornarTabela());
        scrollPanel.setViewportView(tableUsuarios);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 1200) / 2;
        int centerY = (int) (screenSize.getHeight() - 800) / 2;

        setLocation(centerX, centerY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainFrame);
        this.pack();
        this.setSize(1200, 800);
        this.setVisible(true);

        naoPossuiRadioButton.setSelected(true);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                viewAdministradorPanel view = new viewAdministradorPanel();
            }
        });

        estudanteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparRadio();
                estudanteRadioButton.setSelected(true);
                selecionado = enumDesconto.ESTUDANTE;
            }
        });

        gratuitoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparRadio();
                gratuitoRadioButton.setSelected(true);
                selecionado = enumDesconto.GRATUITO;
            }
        });

        naoPossuiRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparRadio();
                naoPossuiRadioButton.setSelected(true);
                selecionado = enumDesconto.NAOPOSSUI;
            }
        });

        definirDescontoParaCadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableUsuarios.getSelectedRow() == -1) return;
                controlCadastro.readCadastro().get(tableUsuarios.getSelectedRow()).setDesconto(selecionado);
                tableUsuarios.setModel(retornarTabela());
            }
        });

    }



    public DefaultTableModel retornarTabela() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Desconto");
        model.addColumn("Cargo");
        model.addColumn("Nome completo");
        model.addColumn("Email");
        model.addColumn("Senha");

        for(Cadastro cadastro : controlCadastro.readCadastro()) {
            String desconto = new String();

            switch(cadastro.getDesconto()) {
                case NAOPOSSUI -> desconto = "Não possui";
                case GRATUITO -> desconto = "Gratuito 100%";
                case ESTUDANTE -> desconto = "Estudante 50%";
            }
            model.addRow(new Object[]{desconto, cadastro.getPermissao().getTipo(), cadastro.getUsuario().getNome(), cadastro.getUsuario().getEmail(), cadastro.getUsuario().getSenha()});
        }

        return model;
    }

    public void limparRadio() {
        naoPossuiRadioButton.setSelected(false);
        gratuitoRadioButton.setSelected(false);
        estudanteRadioButton.setSelected(false);
    }

}


