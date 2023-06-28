import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class viewHorariosPanel extends JFrame{
    private JPanel mainFrame;
    private JButton voltarButton;
    private JTextField origem1;
    private JTextField destino1;
    private JScrollPane scrollPanel;
    private JButton carregaInformaçõesSelecionadasButton;
    private JButton atualizarRotaButton;
    private JTextField origem2;
    private JTextField origem3;
    private JTextField origem4;
    private JTextField origem5;
    private JTextField origem6;
    private JTextField destino2;
    private JTextField destino3;
    private JTextField destino4;
    private JTextField destino5;
    private JTextField destino6;
    private ControlRotas controlRotas = Singleton.getControlRotas();
    private ControlCadastro cadastroGeral = Singleton.getControlCadastroInstance();
    private JFrame frame = this;

    viewHorariosPanel() {
        super("Sistema Bilhetagem | Página de Horarios");

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

        if(cadastroGeral.getUsuarioAutenticado().getPermissao() == enumTipo.MOTORISTA || cadastroGeral.getUsuarioAutenticado().getPermissao() == enumTipo.USUARIO) {
            atualizarRotaButton.setVisible(false);
        }

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(cadastroGeral.getUsuarioAutenticado().getPermissao() == enumTipo.MOTORISTA) {
                    viewMotoristaPanel view = new viewMotoristaPanel();
                    return;
                }
                if(cadastroGeral.getUsuarioAutenticado().getPermissao() == enumTipo.USUARIO) {
                    viewUsuarioPanel view = new viewUsuarioPanel();
                    return;
                }
                viewAdministradorPanel view = new viewAdministradorPanel();
            }
        });

        carregaInformaçõesSelecionadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(table1.getSelectedRow() == -1 ) return;

                String[] destinos = new String[6];
                String [] origems = new String[6];
                int index = 0;
                Rotas rota = controlRotas.readRotas().get(table1.getSelectedRow());
                for (Horario horario : rota.getHorarios()) {
                    destinos[index] = horario.getChegada();
                    origems[index] = horario.getOrigem();
                    index++;
                }
                origem1.setText(origems[0]);
                origem2.setText(origems[1]);
                origem3.setText(origems[2]);
                origem4.setText(origems[3]);
                origem5.setText(origems[4]);
                origem6.setText(origems[5]);
                destino1.setText(destinos[0]);
                destino2.setText(destinos[1]);
                destino3.setText(destinos[2]);
                destino4.setText(destinos[3]);
                destino5.setText(destinos[4]);
                destino6.setText(destinos[5]);
            }
        });

        atualizarRotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(table1.getSelectedRow() == -1 ) return;

                String[] destinos = new String[6];
                String [] origems = new String[6];
                ArrayList<Horario> horarios = new ArrayList<>();

                origems[0] = origem1.getText();
                origems[1] = origem2.getText();
                origems[2] = origem3.getText();
                origems[3] = origem4.getText();
                origems[4] = origem5.getText();
                origems[5] = origem6.getText();
                destinos[0] = destino1.getText();
                destinos[1] = destino2.getText();
                destinos[2] = destino3.getText();
                destinos[3] = destino4.getText();
                destinos[4] = destino5.getText();
                destinos[5] = destino6.getText();

                for (int i = 0; i < 6; i++) {
                    horarios.add(new Horario(origems[i], destinos[i]));
                }

                controlRotas.readRotas().get(table1.getSelectedRow()).setHorarios(horarios);
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
