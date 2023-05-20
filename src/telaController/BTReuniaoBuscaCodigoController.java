package telaController;

import model.Reuniao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BTReuniaoBuscaCodigoController implements ActionListener {

    private JFormattedTextField cod;

    public BTReuniaoBuscaCodigoController(JFormattedTextField cod) {
        this.cod = cod;
    }


    public void actionPerformed(ActionEvent e){
        buscar();

        cod.setText("");

    }

    private String getArquivoGrupos(){
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + "Grupos.csv";

        return caminhoArquivo;
    }



    private void buscar() {
        Reuniao reuniao= new Reuniao();

        reuniao.setCodigoGrupo(Integer.parseInt(cod.getText()));

        System.out.println(reuniao.getCodigoGrupo());
    }
}
