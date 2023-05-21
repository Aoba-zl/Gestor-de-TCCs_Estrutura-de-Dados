package telaController;

import br.fatec.FileLibrary.FileLibrary;
import br.fatec.ListObject.ListObject;
import controller.ManterGrupo;
import controller.ManterReunião;
import model.Grupo;
import model.Reuniao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BTReuniaoBuscaCodigoController implements ActionListener {

    private JFormattedTextField cod;
    private JLabel mensagem;
    private Grupo grupo;

    public BTReuniaoBuscaCodigoController(JFormattedTextField cod, JLabel mensagem) {
        this.cod = cod;
        this.mensagem= mensagem;
    }


    public void actionPerformed(ActionEvent e){
        if (!validaCampoCod(cod)){
            return;
        }

        try {
            int codigo= Integer.parseInt(cod.getText());
            ListObject grupos= getGrupos();

            grupo= ManterReunião.pesquisarCodGrupo(grupos, codigo);

            if (grupo == null){
                mensagem.setText("<html> Grupo não encontrado no Sistema" +
                        "<br> Por favor, digite novamente." +
                        "</html>");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    private boolean validaCampoCod(JFormattedTextField campo){
        if (campo.getText().length() == 0) {
            mensagem.setText("Digite o codigo");
        }
        else if (campo.getText().length() < 4){
            mensagem.setText("Codigo inválido");
        }
        else if (campo.getText().length() > 4){
            mensagem.setText("Codigo inválido");
        }
        return (campo.getText().length() > 0 && campo.getText().length() < 5);
    }



    private String getArquivoGrupos(){
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + "Grupos.csv";

        return caminhoArquivo;
    }

    public ListObject getGrupos() throws Exception {
        String arquivoGrupos= getArquivoGrupos();
        FileLibrary openFile = new FileLibrary(arquivoGrupos);
        ListObject lista= new ListObject();
        String[] vet= openFile.getContentFile().split("\n");
        int tamanho= vet.length;
        for (int i = 0; i < tamanho; i++) {
            if (lista.isEmpty()){
                lista.addFirst(vet[i]);
            }
            else {
                lista.addLast(vet[i]);
            }
        }
        return lista;
    }
}
