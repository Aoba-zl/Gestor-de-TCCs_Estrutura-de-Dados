package controller;

import br.fatec.ListObject.ListObject;
import model.Reuniao;

import java.io.*;

public class ManterPassos {



	public void buscarGrupo()
	{
		
	}
	
	public void buscarReuniao()
	{
		
	}

	public ListObject getReunioes(String arquivoReuniao) throws Exception {
		File readFile = new File(arquivoReuniao);
		if (!readFile .exists())
			readFile .createNewFile();
		FileReader read = new FileReader(readFile);
		BufferedReader buffer = new BufferedReader(read);

		String line;
		StringBuilder content = new StringBuilder();

		line = buffer.readLine();
		while (line != null)
		{
			content.append(line).append("\n");
			line = buffer.readLine();
		}

		String[] linhasArquivo = content.toString().split("\n");
		int quantidadeReunioes = linhasArquivo.length;
		ListObject reunioes = new ListObject();

		if (quantidadeReunioes == 0)
			return null;

		for (int index = 1; index < quantidadeReunioes; index++)
		{
			String[] dadosReuniao = linhasArquivo[index].split(";");
			Reuniao reuniao = montarReuniao(dadosReuniao);

			if (reunioes.isEmpty())
				reunioes.addFirst(reuniao);
			else
				reunioes.addLast(reuniao);
		}

		return reunioes;
	}

	private Reuniao montarReuniao (String[] dadosReuniao)
	{
		Reuniao reuniao = new Reuniao();

		reuniao.setCodigoGrupo(Integer.parseInt(dadosReuniao[0]));
		reuniao.setAssunto(dadosReuniao[1]);
		reuniao.setData(dadosReuniao[2]);
		boolean status = dadosReuniao[3].contains("não") ? false : true;
		reuniao.setStatus(status);
		return reuniao;
	}

	public void salvarDados(String strCodigo, String assuntoReuniao, String passos,
							boolean trabalhoFinalizado, ListObject reunioes)
			throws Exception
	{
		Reuniao ultimaReuinaoFeita = (Reuniao) reunioes.get(0);
		String data = ultimaReuinaoFeita.getData().replace("/", "-");
		String divisor = " - ";
		String tccConcluido = trabalhoFinalizado? "TCC Concluido" : "";
		String nomeArquivo = "Grupo: " + strCodigo + divisor + data + divisor +
				assuntoReuniao + ".csv";
		if (!tccConcluido.isEmpty())
			nomeArquivo += divisor + tccConcluido;
		String caminhoArquivo = System.getProperty("user.home") + File.separator +
				"TEMP" + File.separator;
		divisor = ";";
		String primeiraLinha = strCodigo + divisor + data + divisor + assuntoReuniao;
		if (!tccConcluido.isEmpty())
			primeiraLinha += divisor + tccConcluido;

		String segundaLinha = "Passos:\n";
		String conteudoArquivo = primeiraLinha + "\n" + segundaLinha + passos;


		File file = new File(caminhoArquivo, nomeArquivo);
		FileWriter write = new FileWriter(file);
		PrintWriter fileWriter = new PrintWriter(write);

		fileWriter.write(conteudoArquivo);
		fileWriter.flush();
		fileWriter.close();
		write.close();
	}

}
