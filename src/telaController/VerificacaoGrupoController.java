package telaController;

import javax.swing.JLabel;

import controller.ManterGrupo;
import model.Aluno;
import model.Grupo;

public class VerificacaoGrupoController 
{
	
	public boolean verificaAlunoExiste(Aluno[] aluno, JLabel mensagem)
	{
		ManterGrupo manterGrupo = new ManterGrupo();
		String arq = manterGrupo.getArqDiretorio("Alunos.csv");
		String[] content = null;
		try {
			content = manterGrupo.getArq(arq).split("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int tamContent = content.length;
		int tamAluno = aluno.length;
		
		
		for (int i = 0; i < tamAluno; i++)
		{
			for (int j = 1; j < tamContent; j++)
			{
				if (aluno[i].getRa().equals(""))
					break;
					
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
	
	public boolean verificaGrupoExiste(String arqContent, Grupo grupo, JLabel mensagem)
	{
		try {
			String[] content = arqContent.split("\n");
			Aluno[] alunos = grupo.getAlunos();
			int tam = content.length;
			
			for (int g = 1; g < tam; g++)
			{
				
				String[] formattedContent = content[g].split(";");
				
				if (grupo.getCodigo() == Integer.parseInt(formattedContent[0]))
				{ 
					mensagem.setText("O grupo ja existe!");
					return false;
				}
				for (int i = 0; i < 4; i++)
				{
					if (alunos == null || alunos[i].getRa().equals(""))
						break;
					
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
	
	

}
