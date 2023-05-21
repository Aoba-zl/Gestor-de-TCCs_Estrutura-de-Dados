package telaController;

import br.fatec.FileLibrary.FileLibrary;
import br.fatec.ListObject.ListObject;
import controller.ManterReunião;
import model.Grupo;
import model.Reuniao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BTReuniaoSalvaController implements ActionListener {

    private JFormattedTextField cod;
    private JFormattedTextField assunto;
    private JFormattedTextField data;
    private JLabel mensagem;


    public BTReuniaoSalvaController(JFormattedTextField cod, JFormattedTextField assunto, JFormattedTextField data, JLabel mensagem) {
        this.cod = cod;
        this.assunto = assunto;
        this.data = data;
        this.mensagem = mensagem;
    }

    public void actionPerformed(ActionEvent e){

        if (!validaCampoCod(cod)){
            return;
        }
        if (!validaCampoData(data)){
            return;
        }


        try {
            Grupo grupoCod;
            Reuniao reuniao= new Reuniao();

            reuniao.setCodigoGrupo(Integer.parseInt(cod.getText()));
            reuniao.setAssunto(assunto.getText());
            reuniao.setData(data.getText());

            grupoCod= ManterReunião.pesquisarCodGrupo(getGrupos(), reuniao.getCodigoGrupo());
            reuniao= ManterReunião.validaReuniao(getReunioes(), reuniao.getCodigoGrupo());

            boolean reuniaoExiste;
            if (grupoCod == null){
                mensagem.setText("<html> Grupo não encontrado no Sistema" +
                        "<br> Por favor, digite novamente." +
                        "</html>");
            }
            else if (reuniao != null){
                mensagem.setText("<html> Grupo já possuí uma Reunião marcada" +
                        "<br> Clique em \"Salvar\" para alterar os dados" +
                        "</html>");
                assunto.setText(reuniao.getAssunto());
                data.setText(reuniao.getData());
                reuniaoExiste= true;
                ManterReunião.salvarReuniao(reuniao, getArquivoReunioes(), reuniaoExiste);
            }
            else {
                reuniaoExiste= false;
                ManterReunião.salvarReuniao(reuniao, getArquivoReunioes(), reuniaoExiste);
            }



        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }finally {

            cod.setText("");
            assunto.setText("");
            data.setText("");
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

    private boolean validaCampoData(JFormattedTextField campo){
        if (campo.getText().length() == 0){
            mensagem.setText("Digite a data");
        }
        else if (campo.getText().length() < 10){
            mensagem.setText("Data inválida");
        }
        else if(campo.getText().length() > 10){
            mensagem.setText("Data inválida");
        }
        return (campo.getText().length() > 0 && campo.getText().length() < 11);
    }


    private String getArquivoReunioes(){
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + "Reuniões.csv";

        return caminhoArquivo;
    }

    public ListObject getReunioes() throws Exception{
        String arquivoReunioes= getArquivoReunioes();
        FileLibrary openFile= new FileLibrary(arquivoReunioes);
        ListObject lista= new ListObject();
        String[] vet= openFile.getContentFile().split("\n");
        int tamanho= vet.length;
        for (int i = 0; i < tamanho; i++) {
            Reuniao reuniao= new Reuniao();
            String[] dados= vet[i].split(";");
            reuniao.setCodigoGrupo(Integer.parseInt(dados[0]));
            reuniao.setAssunto(dados[1]);
            reuniao.setData(dados[2]);
            if (lista.isEmpty()){
                lista.addFirst(reuniao);
            }
            else {
                lista.addLast(reuniao);
            }
        }
        return lista;
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
