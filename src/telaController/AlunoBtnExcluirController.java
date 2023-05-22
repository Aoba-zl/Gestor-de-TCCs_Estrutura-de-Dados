package telaController;

import br.fatec.FileLibrary.FileLibrary;
import controller.ManterAluno;
import model.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AlunoBtnExcluirController implements ActionListener
{
    private JFormattedTextField campoRA;
    private JFormattedTextField campoNome;
    private JLabel mensagem;
    private String arquivoAluno;
    private ManterAluno manterAluno = new ManterAluno();
    private JButton btnExcluir;

    public AlunoBtnExcluirController (JFormattedTextField campoRA, JFormattedTextField campoNome,
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
        FileLibrary openFile = new FileLibrary(arquivoAluno);
        return openFile.getContentFile().split("\n");
    }

    private Aluno procuraAluno(String[] alunos, String ra) throws Exception {
        Aluno aluno = manterAluno.pesquisarAluno(alunos, ra);

        if (aluno == null)
            throw new Exception("Aluno não encontrado");
        return aluno;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        try {
            String ra = campoRA.getText();

            String[] alunos = getAlunos(arquivoAluno);
            Aluno aluno = procuraAluno(alunos, ra);

            manterAluno.excluirDadosAluno(aluno, arquivoAluno);
            campoRA.setText("");
            campoNome.setText("");
            btnExcluir.setVisible(false);
            mensagem.setText("Aluno " + aluno.getNome() + " removido do sistema!");
        } catch (Exception e) {
            mensagem.setText("Ocorreu Algum erro.");
            System.out.println(e);
        }
    }
}
