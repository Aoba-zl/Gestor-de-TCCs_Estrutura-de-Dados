package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.fatec.StackObject.StackObject;
import controller.ManterGrupo;
import model.Aluno;
import model.Grupo;

public class BotaoConsultaGrupoController implements ActionListener
{

	private JComboBox<String> cbArea;
	private JComboBox<String> cbSubArea;
	private JTable tableGrupoCad;
	private JLabel lblMensagemGrupoCad;

	public BotaoConsultaGrupoController(JComboBox<String> cbArea, JComboBox<String> cbSubArea, JTable tableGrupoCad, JLabel lblMensagemGrupoCad) 
	{
		this.cbArea = cbArea;
		this.cbSubArea = cbSubArea;
		this.tableGrupoCad = tableGrupoCad;
		this.lblMensagemGrupoCad = lblMensagemGrupoCad;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		pesquisar();
	}
	
	public String hashCode(int area)
	{
		String posit = Integer.toString(area).substring(0, 2);
		
		return posit;
	}

	private void pesquisar() 
	{
		
		
		ManterGrupo manterGrupo = new ManterGrupo();
		String content = null;
		try {
			content = manterGrupo.getArq(manterGrupo.getArqDiretorio("Grupos.csv"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (content.equals("false"))
		{
			lblMensagemGrupoCad.setText("O arquivo de grupo não existe!");
			tableGrupoCad.setModel(new DefaultTableModel(
					new Object[0][0],
					new String[] {
							"C\u00F3digo", "Tema", "\u00DAltima Reuniao"
					}));
			tableGrupoCad.getColumnModel().getColumn(0).setPreferredWidth(30);
			tableGrupoCad.getColumnModel().getColumn(1).setPreferredWidth(180);
			tableGrupoCad.getColumnModel().getColumn(2).setPreferredWidth(60);
			return;
		}
		lblMensagemGrupoCad.setText("");
		
		StackObject pilha = new StackObject();
		
		StringTokenizer stPilha = new StringTokenizer(content, "\n");
		
		stPilha.nextToken();
		
		while(stPilha.hasMoreElements())
		{
			Grupo grupo = new Grupo();
			String[] stGrupo = stPilha.nextToken().split(";");
			
			grupo.setCodigo(Integer.parseInt(stGrupo[0]));
			grupo.setTema(stGrupo[1]);
			pilha.push(grupo);
		}
		
		Object[][] tabela = null;
		
		int tamPilha = pilha.size();
		
		int tamTabela = 0;
		for (int i = 0; i < tamPilha; i++)
		{
			Grupo grupo = new Grupo();
			grupo = (Grupo) pilha.pop();
			if (hashCode(grupo.codigo).substring(0, 1).equals(cbArea.getSelectedItem().toString().substring(0, 1))
					&& hashCode(grupo.codigo).substring(1, 2).equals(cbSubArea.getSelectedItem().toString().substring(0, 1)))
			{
				tamTabela++;
				Object[][] saveTabela = tabela;
				tabela = new Object[tamTabela][3];
				for (int j = 0; j < tamTabela - 1; j++)
				{
					tabela[j][0] = saveTabela[j][0];
					tabela[j][1] = saveTabela[j][1];
				}
				tabela[tamTabela-1][0] = grupo.getCodigo();
				tabela[tamTabela-1][1] = grupo.getTema();
			}
		}
		tableGrupoCad.setModel(new DefaultTableModel(
				tabela,
				new String[] {
					"C\u00F3digo", "Tema", "\u00DAltima Reuniao"
				}
			));
		tableGrupoCad.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableGrupoCad.getColumnModel().getColumn(1).setPreferredWidth(180);
		tableGrupoCad.getColumnModel().getColumn(2).setPreferredWidth(60);
		
		
	}
	
	
}
