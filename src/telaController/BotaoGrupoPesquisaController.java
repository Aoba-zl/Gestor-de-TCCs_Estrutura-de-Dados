package telaController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;


import br.fatec.ListString.ListString;
import controller.ManterGrupo;
import model.Aluno;
import model.Area;
import model.Grupo;

public class BotaoGrupoPesquisaController implements ActionListener
{
	
	private JFormattedTextField pesq;
	private JLabel mensagem;
	private int conf;
	private String arquivoAluno;
	private String arquivoGrupo;
	private Aluno aluno;
	private Grupo grupo;
	private ManterGrupo manterGrupo = new ManterGrupo();
	private ListString[] listaSubArea;
	private String[] areas;
	private JFormattedTextField[] RA;
	private JFormattedTextField ftTema;
	private JComboBox<String> cbArea;
	private JComboBox<String> cbSubArea;
	
	public BotaoGrupoPesquisaController(JFormattedTextField pesq, JLabel mensagem, int conf)
	{
		this.pesq = pesq;
		this.mensagem = mensagem;
		this.conf = conf;
		this.arquivoAluno = getArqDiretorio("Alunos.csv");
		this.arquivoGrupo = getArqDiretorio("Grupos.csv");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		buscar();
	}
	
	public void setList(ListString[] subArea, String[] area)
	{
		this.areas = area;
		this.listaSubArea = subArea;
	}
	
	public void setComand(JFormattedTextField[] RA, JFormattedTextField ftTema, JComboBox<String> cbArea, JComboBox<String> cbSubArea)
	{
		this.RA = RA;
		this.ftTema = ftTema;
		this.cbArea = cbArea;
		this.cbSubArea = cbSubArea;
	}
	
	public int hashCodeArea(String area)
	{
		return (Integer.parseInt(area.substring(0, 1)) - 1);
	}
	
	public int hashCodeSubArea(String area)
	{
		return (Integer.parseInt(area.substring(1, 2)));		
	}
	
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

	private boolean validaCampo(JFormattedTextField campo)
    {
        if (campo.getText().length() != 13 && conf == 0 || campo.getText().length() != 4 && conf == 1)
        {
            mensagem.setText("x");
        	mensagem.setForeground(Color.RED);
        	if (conf == 1)
        	{
        		cbSubArea.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
        		for (int i = 0; i < 4; i++)
        		{
        			RA[i].setText("");
        		}
        		ftTema.setText("");
        	}
        }
        return (campo.getText().length() == 13) && conf == 0 || (campo.getText().length() == 4) && conf == 1;
    }
	
	private void buscar() 
	{
		if (!validaCampo(pesq))
            return;
		
		try {
				mensagem.setText("");
				mensagem.setBackground(null);
				if (conf == 0)
				{
					String ra = pesq.getText();
					String[] alunos = getArq(arquivoAluno);
					
					aluno = manterGrupo.buscarAluno(alunos, ra);
					
					if (aluno == null)
					{
			            mensagem.setText("x");
			        	mensagem.setForeground(Color.RED);
					}
					else
					{
						System.out.println(aluno);
					}
					
				}
				else if (conf == 1)
				{
					String cod = pesq.getText();
					String[] procGrupo = getArq(arquivoGrupo);
					int tamProcGrupo = procGrupo.length;
					boolean test = false;
					String[] aux;
					for (int i = 1; i < tamProcGrupo; i++)
					{
						aux = procGrupo[i].split(";");
						if (cod.equals(aux[0]))
						{
							test = true;
							break;
						}
					}
					if (!test)
					{
						mensagem.setText("x");
			        	mensagem.setForeground(Color.RED);
			        	for (int i = 0; i < 4; i++)
						{
							RA[i].setText("");
						}
			        	ftTema.setText("");
			        	cbArea.setSelectedIndex(0);
			        	cbSubArea.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
			        	return;
					}
					
					grupo = manterGrupo.buscarGrupo(procGrupo, cod);
					int hash = hashCodeArea(cod);
					Area area = new Area();
					area.setNome(areas[hash]);
					area.setSubArea(listaSubArea[hash].get(hashCodeSubArea(cod)));
					grupo.setArea(area);
					Aluno[] aluno = grupo.getAlunos();
					int tamAluno = aluno.length;
					for (int i = 0; i < tamAluno; i++)
					{
						RA[i].setText(aluno[i].getRa());
					}
					for (int i = 3; i >= tamAluno; i--)
					{
						RA[i].setText("");
					}
					ftTema.setText(grupo.getTema());
					cbArea.setSelectedIndex(hash);
					cbSubArea.setSelectedIndex(hashCodeSubArea(cod));
				}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
