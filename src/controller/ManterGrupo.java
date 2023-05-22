package controller;

import model.Aluno;
import model.Area;
import model.Grupo;

import java.io.*;
import java.util.Arrays;

public class ManterGrupo {
	
	private String[] getArq(String arquivoAluno) throws Exception
	{
		File arq = new File(arquivoAluno);
		
		if (arq.exists() && arq.isFile())
		{
			
	        FileReader lerFlux = new FileReader(arq);
			BufferedReader buffer = new BufferedReader(lerFlux);
			String linha = buffer.readLine();
			StringBuilder content = new StringBuilder();
			
			while(linha != null)
			{
				content.append(linha).append("\n");
	            linha = buffer.readLine();
			}
			buffer.close();
            lerFlux.close();
			return content.toString().split("\n");
		}
		return null;
	}
	
    private String getArqDiretorio(String nomeArq)
    {
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + nomeArq;

        return caminhoArquivo;
    }
	
	public Aluno buscarAluno(String[] alunos, String ra) throws IOException
	{
		if (raValido(ra))
		{
			for (String dadosAluno: alunos) {
				Aluno aluno = new Aluno();
				String[] dados = dadosAluno.split(";");
				if (dados.length == 2)
				{
					aluno.setRa(dados[0]);
					aluno.setNome(dados[1]);

					if (aluno.getRa().equals(ra))
						return aluno;
				}
			}
		}
		return null;
	}
	
	public Grupo buscarGrupo(String[] grupos, String cod)
	{
		
		if (codValido(cod))
		{
			String arqAluno = getArqDiretorio("Alunos.csv");
			String[] alunos = null;
			try {
				alunos = getArq(arqAluno);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int tamGrupo = grupos.length;
			
			Grupo grupo = new Grupo();
			
			for (int g = 1; g < tamGrupo; g++)
			{
				String[] dados = grupos[g].split(";");
				
				if (dados[0].equals(cod))
				{
					int tam = dados.length;
					grupo.setCodigo(dados[0]);
					grupo.setTema(dados[1]);
					Aluno[] aluno = new Aluno[tam - 2];
					for (int i = 2; i < tam; i++)
					{
						aluno[i - 2] = new Aluno();
						for (String getAluno: alunos)
						{
							String[] aux = getAluno.split(";");
							if (aux[0].equals(dados[i]))
							{
								String[] auxAluno = getAluno.split(";");
								aluno[i - 2].setRa(auxAluno[0]);
								aluno[i - 2].setNome(auxAluno[1]);
								break;
							}
						}
					}
					grupo.setAlunos(aluno);
					return grupo;
				}
			}
		}
		
		
		return null;
	}
	
	private boolean codValido(String cod)
	{
		return (cod.length() == 4);
	}
	
	private boolean raValido(String ra)
	{
		return (ra.length() == 13);
	}
	
	public void selecaoArea1() throws Exception
	{
		
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
//					grupo.setArea(area.getNome());  // Não está pronto
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
//			grupo.setCodigo(geraCodigo(String.valueOf(grupo.getArea()), grupo.getArea().getSubArea()));
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
