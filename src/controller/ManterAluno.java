package controller;

import br.fatec.ListObject.ListObject;
import model.Aluno;

import java.io.*;

public class ManterAluno {

	
	public void salvarDados(String ra, String nome) throws IOException
	{
		if (ra.length() == 13)
		{
			File dir= new File("C:\\Users\\T-GAMER\\OneDrive - Fatec Centro Paula Souza\\Desktop 1\\Coisinhas\\codigos\\Java\\Gestor-de-TCCs_Estrutura-de-Dados");
			if (dir.exists() && dir.isDirectory())
			{
				File file= new File("C:\\Users\\T-GAMER\\OneDrive - Fatec Centro Paula Souza\\Desktop 1\\Coisinhas\\codigos\\Java\\Gestor-de-TCCs_Estrutura-de-Dados", "Alunos.csv");
				boolean existe= false;
				if (file.exists()){
					existe= true;
					verificarAluno(ra);
				}
				FileWriter fileWriter= new FileWriter(file, existe);
				PrintWriter print= new PrintWriter(fileWriter);
				String alunoArquivo= (ra +";"+ nome +"\n");
				print.write(alunoArquivo);
				print.flush();
				print.close();
				fileWriter.close();

			}
			else
			{
				throw new IOException("Diretorio Inválido");
			}
		}
		else
		{
			throw new IOException("RA Inválido");
		}
	}

	private void verificarAluno(String ra) throws IOException
	{
		File file= new File("C:\\Users\\T-GAMER\\OneDrive - Fatec Centro Paula Souza\\Desktop 1\\Coisinhas\\codigos\\Java\\Gestor-de-TCCs_Estrutura-de-Dados", "Alunos.csv");
		if (file.exists() && file.isFile())
		{
			FileInputStream abreFluxoArq = new FileInputStream(file);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null)
			{
				if (linha.contains(ra)){
					throw new IOException("RA já registrado");
				}
			}
		}
		else
		{
			throw new IOException("Arquivo inválido");
		}
	}
	
	public void pesquisarAluno()
	{
		
	}

}
