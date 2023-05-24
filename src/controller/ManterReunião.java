package controller;

import br.fatec.ListObject.ListObject;
import model.Grupo;
import model.Reuniao;

import java.io.*;

public class ManterReunião {


	public static Grupo pesquisarCodGrupo(ListObject grupos, int codigo) throws Exception {
		int tamanho= grupos.size();

		for (int i = 0; i < tamanho; i++) {
			String dado= (String) grupos.get(i);
			String[] dados= dado.split(";");
			if (Integer.toString(codigo).equals(dados[0])){
				Grupo grupo= new Grupo();
				grupo.setCodigo(Integer.parseInt(dados[0]));
				boolean statusGrupo = !dados[6].contains("não") && !dados[6].contains("nao");
				grupo.setStatus(statusGrupo);
				return grupo;
			}
		}
		return null;
	}


	public static Reuniao validaReuniao(ListObject reunioes, int codigo) throws Exception {
		int tamanho= reunioes.size();

		for (int i = 0; i < tamanho; i++) {
			Reuniao reuniao= (Reuniao) reunioes.get(i);
			if (reuniao.getCodigoGrupo() == codigo){
				return reuniao;
			}
		}
		return null;
	}

	public static void salvarReuniao(Reuniao reuniao, String caminhoArquivo, boolean reuniaoExiste) throws Exception {
		File dir= new File(caminhoArquivo);
		if (dir.exists() && dir.isDirectory()){
			File arq= new File(caminhoArquivo, "Reuniões.csv");
			if (!reuniaoExiste){
				boolean existe= false;
				if (arq.exists()){
					existe= true;
				}
				FileWriter fileWriter= new FileWriter(arq, existe);
				PrintWriter print= new PrintWriter(fileWriter);
				String reuniaoStatus = reuniao.isStatus()?"Concluída": "não Concluída";
				print.write(reuniao.getCodigoGrupo() +";"+ reuniao.getAssunto() +";"+ reuniao.getData() +";"+ reuniaoStatus +"\n");
				print.flush();
				print.close();
				fileWriter.close();
			}
			else {
				atualizaDados(caminhoArquivo, reuniao);
			}
		}
		else {
			throw new IOException("Arquivo inválido");
		}
	}

	private static void atualizaDados(String caminhoArquivo, Reuniao reuniao) throws Exception {
		File file= new File(caminhoArquivo, "Reuniões.csv");
		FileReader lerFlux = new FileReader(file);
		BufferedReader buffer = new BufferedReader(lerFlux);
		StringBuilder content = new StringBuilder();

		String linha = buffer.readLine();
		while(linha != null) {
			if (!linha.contains(Integer.toString(reuniao.getCodigoGrupo()))){
				content.append(linha).append("\n");
			}
			else {
				String reuniaoStatus = reuniao.isStatus()?"Concluída": "não Concluída";
				linha= reuniao.getCodigoGrupo() +";"+ reuniao.getAssunto() +";"+ reuniao.getData() +";"+ reuniaoStatus;;
				content.append(linha).append("\n");
			}
			linha= buffer.readLine();

		}
		file.delete();
		FileWriter fileWriter= new FileWriter(file, false);
		PrintWriter print = new PrintWriter(fileWriter);
		print.write(String.valueOf(content));
		print.flush();
		buffer.close();
		lerFlux.close();
		fileWriter.close();
		print.close();

	}
}
