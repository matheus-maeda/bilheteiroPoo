import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewHistoricoPanel extends JFrame{
    private JButton voltarButton;
    private JScrollPane scrollPanel;
    private JPanel mainFrame;
    private JFrame frame = this;

    private ControlCadastro cadastrolGeral = Singleton.getControlCadastroInstance();

    viewHistoricoPanel() {
        super("Sistema Bilhetagem | Página do Histórico");

        JTable table1 = new JTable(retornarTabela());
        scrollPanel.setViewportView(table1);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - 800) / 2;
        int centerY = (int) (screenSize.getHeight() - 600) / 2;

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
    }

    public DefaultTableModel retornarTabela() {
        DefaultTableModel model = new DefaultTableModel();
        String destino = new String(" ");
        model.addColumn("Rota");
        model.addColumn("Data");
        model.addColumn("Valor");

        // Adiciona linhas ao modelo de tabela
        for(HistoricoUso historicoUso : cadastrolGeral.getUsuarioAutenticado().getHistoricoUso()) {
            model.addRow(new Object[]{historicoUso.getLinha(), historicoUso.getData(), historicoUso.getValor()});
        }

        return model;
    }
}
