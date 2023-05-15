package controller;

import model.Aluno;
import model.Area;

import java.io.*;

public class ManterGrupo {

	
	
	public String buscarAluno(Aluno aluno) throws IOException
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
				if (linha.contains(aluno.getRa()))
				{
					return aluno.getRa();
				}
				linha= buffer.readLine();
			}
			return "RA não cadastrado"; //exemplo
		}
		else
		{
			throw new IOException("Arquivo inválido");
		}
	}

	private int geraCodigo(Area area, Area subArea){

	}
	
	public void selecaoArea()
	{
		
	}
	
	public void salvarDados()
	{
		
	}
	
}
