package controller;

import br.fatec.FileLibrary.FileLibrary;
import model.Aluno;

import java.io.File;

public class ManterAluno {
	public Aluno pesquisarAluno(String[] alunos, String ra)
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

	public void salvarDados(Aluno aluno, String caminhoArquivo, boolean alunoExiste) throws Exception
	{
		FileLibrary abreArquivoAluno = new FileLibrary(caminhoArquivo);
		String conteudoArquivoAluno = abreArquivoAluno.getContentFile();
		String strAluno = aluno.toString();
		if (!alunoExiste)
			conteudoArquivoAluno += strAluno + "\n";
		else
		{
			conteudoArquivoAluno = atualizaDados(conteudoArquivoAluno, strAluno, aluno.getRa());
		}
		abreArquivoAluno.writeInFile(caminhoArquivo, conteudoArquivoAluno);
	}

	public void excluirDadosAluno(Aluno aluno, String caminhoArquivo) throws Exception {
		FileLibrary abreArquivoAluno = new FileLibrary(caminhoArquivo);
		String conteudoArquivoAluno = abreArquivoAluno.getContentFile();

		conteudoArquivoAluno = removerDado(conteudoArquivoAluno, aluno.getRa());
		abreArquivoAluno.writeInFile(caminhoArquivo, conteudoArquivoAluno);
	}

	private String atualizaDados(String conteudoArquivoAluno, String strAluno, String raAluno) {
		String[] dadosSeparados = conteudoArquivoAluno.split("\n");
		String ra;
		StringBuilder newConteudo = new StringBuilder();
		int len = dadosSeparados.length;

		for (int i = 0; i < len; i++)
		{
			String[] dados = dadosSeparados[i].split(";");
			ra = dados[0];
			String aluno;

			if (ra.equals(raAluno))
				aluno = strAluno;
			else
				aluno = dadosSeparados[i];
			newConteudo.append(aluno).append("\n");
		}
		return newConteudo.toString();
	}

	private String removerDado(String conteudoArquivoAluno, String raAluno) {
		String[] dadosSeparados = conteudoArquivoAluno.split("\n");
		String ra;
		StringBuilder newConteudo = new StringBuilder();
		int len = dadosSeparados.length;

		for (int i = 0; i < len; i++)
		{
			String[] dados = dadosSeparados[i].split(";");
			ra = dados[0];

			if (! ra.equals(raAluno))
				newConteudo.append(dadosSeparados[i]).append("\n");
		}
		return newConteudo.toString();
	}

	private boolean raValido(String ra) {
		return (ra.length() == 13);
	}
}
