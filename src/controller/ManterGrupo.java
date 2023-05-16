package controller;

import model.Aluno;
import model.Area;
import model.Grupo;

import java.io.*;
import java.util.Arrays;

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
			throw new IOException("Arquivo Alunos.csv inválido");
		}
	}

	private int geraCodigo(String area, String subArea){

	}
	
	public void selecaoArea(Area area, Grupo grupo) throws IOException
	{
		File file= new File("C:\\Users\\T-GAMER\\OneDrive - Fatec Centro Paula Souza\\Desktop 1\\Coisinhas\\codigos\\Java\\Gestor-de-TCCs_Estrutura-de-Dados", "Areas.csv");
		if (file.exists() && file.isFile()){
			FileInputStream abreFluxoArq = new FileInputStream(file);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha= buffer.readLine();
			while (linha != null){
				if (linha.contains(area.getNome())){
					String[] vet= linha.split(";");
					area.setNome(vet[1]);
					grupo.setArea(area.getNome());  // Não está pronto
				}
			}
		}
		else {
			throw new IOException("Arquivo Areas.csv Inválido!");
		}
	}
	
	public void salvarDados(Grupo grupo) throws IOException
	{
		File dir= new File("C:\\Users\\T-GAMER\\OneDrive - Fatec Centro Paula Souza\\Desktop 1\\Coisinhas\\codigos\\Java\\Gestor-de-TCCs_Estrutura-de-Dados");
		if (dir.exists() && dir.isDirectory()){
			grupo.setCodigo(geraCodigo(String.valueOf(grupo.getArea()), grupo.getArea().getSubArea()));
			File file= new File("C:\\Users\\T-GAMER\\OneDrive - Fatec Centro Paula Souza\\Desktop 1\\Coisinhas\\codigos\\Java\\Gestor-de-TCCs_Estrutura-de-Dados", "Grupos.csv");
			boolean existe= false;
			if (file.exists()){
				existe= true;
			}
			FileWriter fileWriter= new FileWriter(file, existe);
			PrintWriter print= new PrintWriter(fileWriter);
			StringBuffer buffer= new StringBuffer();
			String GrupoArquivo= "";
			if (existe == false){
				print.write("Código;Tema;Subárea;Integrantes \n");
			}
			print.write(grupo.getCodigo() +";"+ grupo.getTema() +";"+ grupo.getArea().getSubArea() +";"+ Arrays.toString(grupo.getAlunos()));
			print.flush();
			print.close();
			fileWriter.close();
		}
		else {
			throw new IOException("Diretorio Inválido!");
		}
	}
	
}
