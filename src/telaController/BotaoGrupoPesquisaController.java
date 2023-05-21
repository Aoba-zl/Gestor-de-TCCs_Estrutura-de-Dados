package telaController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import br.fatec.FileLibrary.FileLibrary;
import controller.ManterAluno;
import model.Aluno;
import model.Grupo;

public class BotaoGrupoPesquisaController implements ActionListener
{
	
	private JFormattedTextField pesq;
	private JLabel mensagem;
	private int conf;
	private String arquivoAluno;
	private Aluno aluno;
	private ManterAluno manterAluno = new ManterAluno();
	
	public BotaoGrupoPesquisaController(JFormattedTextField pesq, JLabel mensagem, int conf)
	{
		this.pesq = pesq;
		this.mensagem = mensagem;
		this.conf = conf;
		this.arquivoAluno = getArquivoAluno();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		buscar();
	}
	
	private String[] getAlunos(String arquivoAluno) throws Exception
	{
		FileLibrary openFile = new FileLibrary(arquivoAluno);
		return openFile.getContentFile().split("\n");
	}
	
    private String getArquivoAluno()
    {
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + "Alunos.csv";

        return caminhoArquivo;
    }

	private boolean validaCampo(JFormattedTextField campo)
    {
        if (campo.getText().length() != 13 && conf == 0 || campo.getText().length() != 4 && conf == 1)
        {
            mensagem.setText("x");
        	mensagem.setBackground(Color.RED);
        }
        return (campo.getText().length() == 13) && conf == 0 || (campo.getText().length() == 4) && conf == 1;
    }
	
	private void buscar() 
	{
		if (!validaCampo(pesq))
            return;
		
		try {
				mensagem.setText("");
				mensagem.setBackground(null);
				if (conf == 0)
				{
					String ra = pesq.getText();
					String [] alunos = getAlunos(arquivoAluno);
					
					aluno = manterAluno.pesquisarAluno(alunos, ra);
					
					if (aluno == null)
					{
			            mensagem.setText("x");
			        	mensagem.setBackground(Color.RED);
					}
					else
					{
						System.out.println(aluno);
					}
					
				}
				else if (conf == 1)
				{
					Grupo grupo = new Grupo();
					grupo.setCodigo(pesq.getText());
					System.out.println(grupo);
				}
		} catch (Exception e)
		{
			
		}
	}
	
	
}
