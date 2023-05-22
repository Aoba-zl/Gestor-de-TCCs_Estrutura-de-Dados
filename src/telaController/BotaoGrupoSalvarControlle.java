package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import controller.ManterGrupo;
import model.Aluno;
import model.Area;
import model.Grupo;

public class BotaoGrupoSalvarControlle implements ActionListener
{
	private JFormattedTextField[] RA = new JFormattedTextField[4];
	private JFormattedTextField cod;
	private JFormattedTextField tema;
	private JComboBox<String> area;
	private JComboBox<String> subArea;
	private ManterGrupo manterGrupo = new ManterGrupo();
	
	
	public BotaoGrupoSalvarControlle(JFormattedTextField[] RA, JFormattedTextField cod, JFormattedTextField tema, JComboBox<String> cbArea, JComboBox<String> cbSubArea) 
	{
		this.RA = RA;
		this.cod = cod;
		this.tema = tema;
		this.area = cbArea;
		this.subArea = cbSubArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		salvar();
	}

	private void salvar() {
		if (this.subArea.getSelectedItem().equals("") || this.RA[0].getText().equals("") && this.RA[1].getText().equals("")
				&& this.RA[2].getText().equals("") && this.RA[3].getText().equals(""))
		{
			return;
		}
		
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
		grupo.setCodigo(cod.getText());
		grupo.setTema(tema.getText());
		grupo.setAlunos(aluno);
		grupo.setArea(area);
		
		try {
			manterGrupo.salvarDados(grupo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(grupo);
	}
	
	
	

}
