package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import br.fatec.ListString.ListString;

public class ComboBoxGrupoController implements ActionListener
{

	private JComboBox<String> selecao;
	private String[] area;
	private ListString[] subArea;
	
	
	public ComboBoxGrupoController(JComboBox<String> selecao, String[] area, ListString[] subArea) 
	{
		this.selecao = selecao;
		this.area = area;
		this.subArea = subArea;
	}

	public int hashCode(String area)
	{
		int posit = Integer.parseInt(area.substring(0, 1));
		return posit;
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String areas = selecao.getSelectedItem().toString();
		
		
		if (areas.equals(area[1]))
		{
			System.out.println("ok");
		}
		
	}
}
