package telaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class ComboBoxSubAreaController implements ActionListener
{
	private JComboBox<String> area;
	private JComboBox<String> subArea;
	private JFormattedTextField cod;
	
	public ComboBoxSubAreaController(JComboBox<String> area, JComboBox<String> subArea, JFormattedTextField cod) 
	{
		this.area = area;
		this.subArea = subArea;
		this.cod = cod;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String selectArea = area.getSelectedItem().toString();
		String selectSubArea = subArea.getSelectedItem().toString();
		
		String codSelecao = selectArea.substring(0, 1) + selectSubArea.substring(0, 1);
		
		cod.setText(codSelecao);
		
		
		
	}
	
	
}
