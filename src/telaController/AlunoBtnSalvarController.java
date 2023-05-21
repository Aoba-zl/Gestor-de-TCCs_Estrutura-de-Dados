package telaController;

import br.fatec.FileLibrary.FileLibrary;
import controller.ManterAluno;
import model.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AlunoBtnSalvarController implements ActionListener
{
    private JFormattedTextField campoRA;
    private JFormattedTextField campoNome;
    private JLabel mensagem;
    private String arquivoAluno;
    private ManterAluno manterAluno = new ManterAluno();

    public AlunoBtnSalvarController(JFormattedTextField campoRA, JFormattedTextField campoNome,
                                    JLabel mensagem)
    {
        this.campoRA = campoRA;
        this.campoNome = campoNome;
        this.mensagem = mensagem;
        this.arquivoAluno = getArquivoAluno();
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

    private boolean validaCampoRA(JFormattedTextField campo)
    {
        if (campo.getText().length() != 13)
            mensagem.setText("RA inválido");
        return (campo.getText().length() == 13);
    }

    private boolean validaCampoNome(JFormattedTextField campo)
    {
        if (campo.getText().length() == 0)
            mensagem.setText("Insira um nome");
        return (campo.getText().length() > 0);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (!validaCampoRA(campoRA))
            return;
        if (!validaCampoNome(campoNome))
            return;

        try {
            String ra = campoRA.getText();

            String[] alunos = getAlunos(arquivoAluno);
            Aluno aluno = manterAluno.pesquisarAluno(alunos, ra);
            boolean alunoExiste;

            if (aluno != null)
            {
                alunoExiste = true;
                aluno.setNome(campoNome.getText());
            }
            else
            {
                alunoExiste = false;
                aluno = new Aluno();
                aluno.setNome(campoNome.getText());
                aluno.setRa(campoRA.getText());
            }

            manterAluno.salvarDados(aluno, arquivoAluno, alunoExiste);
            mensagem.setText("Dados salvos no systema!");
        } catch (Exception e) {
            mensagem.setText("Ocorreu Algum erro.");
            System.out.println(e);
        }
    }
}
