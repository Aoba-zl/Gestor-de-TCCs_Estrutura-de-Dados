package telaController;

import model.Grupo;
import model.Reuniao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BTReuniaoSalvaController implements ActionListener {

    private JFormattedTextField cod;
    private JFormattedTextField assunto;
    private JFormattedTextField data;

    public BTReuniaoSalvaController(JFormattedTextField cod, JFormattedTextField assunto, JFormattedTextField data) {
        this.cod = cod;
        this.assunto = assunto;
        this.data = data;
    }

    public void actionPerformed(ActionEvent e){
        salvar();

        cod.setText("");
        assunto.setText("");
        data.setText("");
    }

    private void salvar() {
        Reuniao reuniao= new Reuniao();

        reuniao.setCodigoGrupo(Integer.parseInt(cod.getText()));
        reuniao.setAssunto(assunto.getText());
        reuniao.setData(data.getText());

        System.out.println(reuniao);

    }
}
