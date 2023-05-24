package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ComboBoxSubAreaConsultaController implements ActionListener
{
	private JButton btnPesquisarGrupos;

	public ComboBoxSubAreaConsultaController(JButton btnPesquisarGrupos) 
	{
		this.btnPesquisarGrupos = btnPesquisarGrupos;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Consulta();
	}

	private void Consulta() 
	{
		btnPesquisarGrupos.setEnabled(true);
	}
	

}
