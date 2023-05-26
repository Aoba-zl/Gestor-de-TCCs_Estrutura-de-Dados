package view;

import telaController.BTReuniaoBuscaCodigoController;
import telaController.BTReuniaoSalvaController;
import telaController.BTReunioesMarcadasBuscaController;
import telaController.TextFieldReuniaoDataReuniao;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaMarcarReuniao extends JFrame {

    public static void setElements(JPanel pMarcarReuniao){


        JFormattedTextField ftCodGrupoReuniao = new JFormattedTextField();
        ftCodGrupoReuniao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                char i = e.getKeyChar();
                if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
                {
                    ftCodGrupoReuniao.setEditable(true);
                }
                else
                {
                    ftCodGrupoReuniao.setEditable(false);
                }
            }
        });

        ftCodGrupoReuniao.setBounds(192, 66, 119, 20);
        pMarcarReuniao.add(ftCodGrupoReuniao);

        JFormattedTextField ftAssuntoReuniao = new JFormattedTextField();
        ftAssuntoReuniao.setBounds(192, 97, 119, 20);
        pMarcarReuniao.add(ftAssuntoReuniao);

        JFormattedTextField ftDataReuniao = new JFormattedTextField();
        ftDataReuniao.setBounds(192, 128, 119, 20);
        pMarcarReuniao.add(ftDataReuniao);

        JButton btnBuscarCodReuniao = new JButton("Buscar");
        btnBuscarCodReuniao.setBounds(321, 65, 79, 23);
        pMarcarReuniao.add(btnBuscarCodReuniao);

        JButton btnSalvaReuniao = new JButton("Salvar");
        btnSalvaReuniao.setBounds(330, 160, 100, 30);
        pMarcarReuniao.add(btnSalvaReuniao);

        JLabel lblMensagemReuniao = new JLabel("");
        lblMensagemReuniao.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensagemReuniao.setBounds(410, 11, 132, 75);
        pMarcarReuniao.add(lblMensagemReuniao);

        BTReuniaoSalvaController BTReuniaoSalva= new BTReuniaoSalvaController(ftCodGrupoReuniao, ftAssuntoReuniao, ftDataReuniao, lblMensagemReuniao);
        BTReuniaoBuscaCodigoController BTReuniaoBuscaCodigo= new BTReuniaoBuscaCodigoController(ftCodGrupoReuniao, ftAssuntoReuniao, ftDataReuniao, lblMensagemReuniao);
        TextFieldReuniaoDataReuniao ftReuniaoDataCont = new TextFieldReuniaoDataReuniao(ftDataReuniao);

        btnBuscarCodReuniao.addActionListener(BTReuniaoBuscaCodigo);
        btnSalvaReuniao.addActionListener(BTReuniaoSalva);
        ftDataReuniao.addKeyListener(ftReuniaoDataCont);

    }
}
