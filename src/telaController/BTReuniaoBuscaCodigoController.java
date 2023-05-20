package telaController;

import model.Reuniao;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BTReuniaoBuscaCodigoController {

    private JFormattedTextField cod;

    public BTReuniaoBuscaCodigoController(JFormattedTextField cod) {
        this.cod = cod;
    }


    public void actionPerformed(ActionEvent e){
        buscar();

        cod.setText("");

    }

    private void buscar() {
        Reuniao reuniao= new Reuniao();

        reuniao.setCodigoGrupo(Integer.parseInt(cod.getText()));

        System.out.println(reuniao);
    }
}
