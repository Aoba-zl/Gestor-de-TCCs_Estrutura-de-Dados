package controller;

import br.fatec.FileLibrary.FileLibrary;
import br.fatec.ListObject.ListObject;
import model.Grupo;
import model.Reuniao;

public class ManterReunião {


	public static Grupo pesquisarCodGrupo(ListObject grupos, int codigo) throws Exception {
		int tamanho= grupos.size();

		for (int i = 0; i < tamanho; i++) {
			String dado= (String) grupos.get(i);
			String[] dados= dado.split(";");
			if (dados[0].equals(codigo)){
				Grupo grupo= new Grupo();
				grupo.setCodigo(Integer.parseInt(dados[0]));
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
		FileLibrary abreArquivoReuniao= new FileLibrary(caminhoArquivo);
		String conteudoArquivoReuniao= abreArquivoReuniao.getContentFile();
		String strReuniao= reuniao.toString();
		if (!reuniaoExiste){
			conteudoArquivoReuniao+= strReuniao + "\n";
		}
		else {
			conteudoArquivoReuniao= autalizaDados(conteudoArquivoReuniao, strReuniao, reuniao.getCodigoGrupo());
		}
		abreArquivoReuniao.writeInFile(caminhoArquivo, conteudoArquivoReuniao);
	}

	private static String autalizaDados(String conteudoArquivoReuniao, String strReuniao, int codigoGrupo) {
		String[] reunioes= conteudoArquivoReuniao.split("\n");
		int codigo;
		StringBuilder newConteudo= new StringBuilder();
		int tamanho= reunioes.length;
		for (int i = 0; i < tamanho; i++) {
			String[] dados= reunioes[i].split(";");
			codigo= Integer.parseInt(dados[0]);
			String reuniao;

			if (codigo == codigoGrupo){
				reuniao= strReuniao;
			}
			else {
				reuniao = reunioes[i];
			}
			newConteudo.append(reuniao).append("\n");
		}
		return newConteudo.toString();
	}
}
