package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import controller.ManterGrupo;
import model.Aluno;
import model.Area;
import model.Grupo;

public class BotaoGrupoSalvarControlle implements ActionListener
{
	private JFormattedTextField[] RA = new JFormattedTextField[4];
	private JFormattedTextField cod;
	private JFormattedTextField tema;
	private JComboBox<String> area;
	private JComboBox<String> subArea;
	private ManterGrupo manterGrupo = new ManterGrupo();
	private JLabel mensagem;
	
	
	public BotaoGrupoSalvarControlle(JFormattedTextField[] RA, JFormattedTextField cod, JFormattedTextField tema, JComboBox<String> cbArea, JComboBox<String> cbSubArea, JLabel lblMensagemGrupoCad) 
	{
		this.RA = RA;
		this.cod = cod;
		this.tema = tema;
		this.area = cbArea;
		this.subArea = cbSubArea;
		this.mensagem = lblMensagemGrupoCad;
	}
    
	public boolean verificaAlunoExiste(String arqContent, Aluno[] aluno)
	{
		String[] content = arqContent.split("\n");
		int tamContent = content.length;
		int tamAluno = aluno.length;
		
		for (int i = 0; i < tamAluno; i++)
		{
			for (int j = 0; j < tamContent; j++)
			{
				String[] formattedContent = content[j].split(";");
				
				if (aluno[i].getRa().equals(formattedContent[0]))
				{
					break;
				}
				if (j == tamContent - 1)
				{
					mensagem.setText("<html>O RA " + aluno[i].getRa() + "<br>não existe no sistema!</html>");
					return false;
				}
			}
		}
		
		return true;
		
		
	}
	
	public boolean verificaGrupoExiste(String arqContent, Grupo grupo)
	{
		try {
			String[] content = arqContent.split("\n");
			Aluno[] alunos = grupo.getAlunos();
			
			for (String eachContent: content)
			{
				String[] formattedContent = eachContent.split(";");
				
				if (grupo.getCodigo().equals(formattedContent[0]))
				{
					mensagem.setText("O grupo ja existe!");
					return false;
				}
				for (int i = 0; i < 4; i++)
				{
					int tamContent = formattedContent.length;
					
					for (int j = 2; j < tamContent; j++)
					{
						if (alunos[i].getRa().equals(formattedContent[j]))
						{
							mensagem.setText("<html>O RA " + alunos[i].getRa() + "<br>já está em um grupo.</html>");
							return false;
						}						
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		salvar();
	}

	private void salvar() {
		if (this.subArea.getSelectedItem().equals("") || this.RA[0].getText().equals("") && this.RA[1].getText().equals("")
				&& this.RA[2].getText().equals("") && this.RA[3].getText().equals(""))
		{
			return;
		}
		
		String arqGrupo = manterGrupo.getArqDiretorio("Grupos.csv");
		String arqAlunos = manterGrupo.getArqDiretorio("Alunos.csv");
		try {
			arqGrupo = manterGrupo.getArq(arqGrupo);
			arqAlunos = manterGrupo.getArq(arqAlunos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Grupo grupo = new Grupo();
		Aluno[] aluno = new Aluno[4];
		Area area = new Area();
		int tam = aluno.length;
		for (int i = 0; i < tam; i++)
		{
			aluno[i] = new Aluno();
			aluno[i].setRa(RA[i].getText());
		}
		
		area.setNome(this.area.getSelectedItem().toString());
		area.setSubArea(this.subArea.getSelectedItem().toString());
		grupo.setCodigo(cod.getText());
		grupo.setTema(tema.getText());
		grupo.setAlunos(aluno);
		grupo.setArea(area);
		
		if (!verificaGrupoExiste(arqGrupo, grupo))
			return;
			
		if (!verificaAlunoExiste(arqAlunos, grupo.getAlunos()))
			return;
		
		try {
			manterGrupo.salvarDados(grupo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(grupo);
	}
	
	
	

}
