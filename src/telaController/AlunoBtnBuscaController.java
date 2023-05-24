package telaController;

import controller.ManterAluno;
import model.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AlunoBtnBuscaController implements ActionListener
{
    private JFormattedTextField campoRA;
    private JFormattedTextField campoNome;
    private JLabel mensagem;
    private String arquivoAluno;
    private ManterAluno manterAluno = new ManterAluno();
    private Aluno aluno;
    private JButton btnExcluir;

    public AlunoBtnBuscaController(JFormattedTextField campoRA, JFormattedTextField campoNome,
                                   JLabel mensagem, JButton btnExcluir)
    {
        this.campoRA = campoRA;
        this.campoNome = campoNome;
        this.mensagem = mensagem;
        this.arquivoAluno = getArquivoAluno();
        this.btnExcluir = btnExcluir;
    }

    private String getArquivoAluno()
    {
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + "Alunos.csv";

        return caminhoArquivo;
    }

    private String[] getAlunos(String arquivoAluno) throws Exception {
        File readFile = new File(arquivoAluno);
        if (!readFile .exists())
            readFile .createNewFile();
        FileReader read = new FileReader(readFile);
        BufferedReader buffer = new BufferedReader(read);

        String line;
        StringBuilder content = new StringBuilder();

        line = buffer.readLine();
        while (line != null)
        {
            content.append(line).append("\n");
            line = buffer.readLine();
        }
        return content.toString().split("\n");
    }

    private boolean validaCampoRA(JFormattedTextField campo)
    {
        if (campo.getText().length() != 13)
            mensagem.setText("RA inválido");
        return (campo.getText().length() == 13);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (!validaCampoRA(campoRA))
            return;

        try {
            String ra = campoRA.getText();

            String[] alunos = getAlunos(arquivoAluno);
            aluno = manterAluno.pesquisarAluno(alunos, ra);

            if (aluno != null) {
                mensagem.setText("<html> Aluno já está registrado no sistema." +
                        "<br> Clique em \"Salvar\" para alterar os dados." +
                        "</html>");
                campoNome.setText(aluno.getNome());
                btnExcluir.setVisible(true);
            }
            else {
                mensagem.setText("<html> RA não encontrado no sistema.<br>" +
                        "Clique em \"Salvar\" para cadastrar aluno.</html>");
                btnExcluir.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
