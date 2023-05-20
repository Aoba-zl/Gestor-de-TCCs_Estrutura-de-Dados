package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;

import model.Aluno;

public class BotaoGrupoPesquisaController implements ActionListener
{
	
	private JFormattedTextField pesq;
	
	public BotaoGrupoPesquisaController(JFormattedTextField pesq)
	{
		this.pesq = pesq;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		buscar();
	}

	private void buscar() 
	{
		Aluno aluno = new Aluno();
		aluno.setRa(pesq.getText());
		
		System.out.println(aluno.getRa());
	}
	
	
}
