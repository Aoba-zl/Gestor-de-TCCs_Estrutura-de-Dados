package telaController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import model.Aluno;
import model.Grupo;

public class BotaoGrupoPesquisaController implements ActionListener
{
	
	private JFormattedTextField pesq;
	private JLabel mensagem;
	private int conf;
	
	public BotaoGrupoPesquisaController(JFormattedTextField pesq, JLabel mensagem, int conf)
	{
		this.pesq = pesq;
		this.mensagem = mensagem;
		this.conf = conf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		buscar();
	}
	
    private String getArquivoAluno()
    {
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + "Alunos.csv";

        return caminhoArquivo;
    }

	private boolean validaCampoRA(JFormattedTextField campo)
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
		if (!validaCampoRA(pesq))
            return;
		mensagem.setText("");
		mensagem.setBackground(null);
		if (conf == 0)
		{
			Aluno aluno = new Aluno();
			aluno.setRa(pesq.getText());
			System.out.println(aluno.getRa());
		}
		else if (conf == 1)
		{
			Grupo grupo = new Grupo();
			grupo.setCodigo(pesq.getText());
			System.out.println(grupo);
		}
	}
	
	
}
