package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import controller.ManterGrupo;
import model.Aluno;
import model.Area;
import model.Grupo;

public class BotaoGrupoSalvarController implements ActionListener
{
	private JFormattedTextField[] RA = new JFormattedTextField[4];
	private JFormattedTextField cod;
	private JFormattedTextField tema;
	private JComboBox<String> area;
	private JComboBox<String> subArea;
	private ManterGrupo manterGrupo = new ManterGrupo();
	private JLabel mensagem;
	private VerificacaoGrupoController verifica = new VerificacaoGrupoController();
	private JButton btnSalvaAlteraGrupos;
	private JButton btnExcluirGrupos;
	
	
	public BotaoGrupoSalvarController(JFormattedTextField[] RA, JFormattedTextField cod, JFormattedTextField tema, JComboBox<String> cbArea, JComboBox<String> cbSubArea, JLabel lblMensagemGrupoCad) 
	{
		this.RA = RA;
		this.cod = cod;
		this.tema = tema;
		this.area = cbArea;
		this.subArea = cbSubArea;
		this.mensagem = lblMensagemGrupoCad;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cmd = e.getActionCommand();
		if(cmd.equals("Salvar"))
			salvar();
		if(cmd.equals("Alterar"))
			alterar();
	}
	
	public void setCommands(JButton btnSalvaAlteraGrupos, JButton btnExcluirGrupos)
	{
		this.btnSalvaAlteraGrupos = btnSalvaAlteraGrupos;
		this.btnExcluirGrupos = btnExcluirGrupos;
	}

	private Grupo setGrupo()
	{
		Grupo grupo = new Grupo();
		Aluno[] aluno = new Aluno[4];
		Area area = new Area();
		int tam = aluno.length;
		
		for (int i = 0; i < tam; i++)
		{
			
			
			aluno[i] = new Aluno();
			aluno[i].setRa(RA[i].getText());
			
		}
		
		area.setNome(this.area.getSelectedItem().toString());
		area.setSubArea(this.subArea.getSelectedItem().toString());
		grupo.setCodigo(Integer.parseInt(cod.getText()));
		grupo.setTema(tema.getText());
		grupo.setAlunos(aluno);
		grupo.setArea(area);
		
		return grupo;
	}
	
	private Boolean verificacao()
	{
		if (this.RA[0].getText().equals("") && this.RA[1].getText().equals("")
				&& this.RA[2].getText().equals("") && this.RA[3].getText().equals(""))
		{
			this.mensagem.setText("Digite pelo menos 1 RA!");
			return false;
		}
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if(this.RA[j].getText().equals(""))
				{
					break;
				}
				if(i != j && this.RA[i].getText().equals(this.RA[j].getText()))
				{
					this.mensagem.setText("<html>Um RA não <br>pode ser igual ao outro!</html>");
					return false;
				}
			}
		}
		if (this.subArea.getSelectedItem().equals("") )
		{
			this.mensagem.setText("Selecione uma subArea!");
			return false;
		}
		if (this.tema.getText().equals("") )
		{
			this.mensagem.setText("Digite o tema do grupo!");
			return false;
		}
		if (!this.cod.getText().toString().substring(0, 2).equals(this.area.getSelectedItem().toString().substring(0, 1)
				+ this.subArea.getSelectedItem().toString().substring(0, 1)))
		{
			this.mensagem.setText("<html>Os dois primeiros digitos tem <br>que ser igual a área e a subárea!");
			return false;
		}
		if (this.cod.getText().toString().length() != 4)
		{
			this.mensagem.setText("O codigo tem quer 4 digitos.");
			return false;
		}
		
		return true;
	}
	
	private void salvar() {
		
		if (!verificacao())
			return;
		
		if (!this.cod.getText().toString().substring(0, 2).equals(this.area.getSelectedItem().toString().substring(0, 1)
			+ this.subArea.getSelectedItem().toString().substring(0, 1)))
		{
			this.mensagem.setText("<html>Os dois primeiros digitos tem <br>que ser igual a área e a subárea!");
			return;
		}
		
		String arqGrupo = manterGrupo.getArqDiretorio("Grupos.csv");
		String arqAlunos = manterGrupo.getArqDiretorio("Alunos.csv");
		try {
			arqGrupo = manterGrupo.getArq(arqGrupo);
			arqAlunos = manterGrupo.getArq(arqAlunos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Grupo grupo = setGrupo();
		
		if (!verifica.verificaGrupoExiste(arqGrupo, grupo, this.mensagem))
			return;
			
		if (!verifica.verificaAlunoExiste(grupo.getAlunos(), this.mensagem))
			return;
		
		try {
			manterGrupo.salvarGrupo(grupo);
			this.mensagem.setText("O grupo foi salvo no banco!");
			btnSalvaAlteraGrupos.setText("Alterar");
			btnExcluirGrupos.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void alterar() 
	{
		if (!verificacao())
			return;
		
		String arqGrupo = manterGrupo.getArqDiretorio("Grupos.csv");
		String arqAlunos = manterGrupo.getArqDiretorio("Alunos.csv");
		try {
			arqGrupo = manterGrupo.getArq(arqGrupo);
			arqAlunos = manterGrupo.getArq(arqAlunos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Grupo grupo = new Grupo();
		grupo = setGrupo();	
		
			
		if (!verifica.verificaAlunoExiste(grupo.getAlunos(), this.mensagem))
			return;
		
		manterGrupo.excluirGrupo(grupo);
		
		
		manterGrupo.salvarGrupo(grupo);
		this.mensagem.setText("Grupo alterado!");
		
	}
	
	
	
}