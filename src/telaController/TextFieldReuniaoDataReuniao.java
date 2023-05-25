package telaController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;

public class TextFieldReuniaoDataReuniao implements KeyListener
{

	private JFormattedTextField ftDataReuniao;

	public TextFieldReuniaoDataReuniao(JFormattedTextField ftDataReuniao) 
	{
		this.ftDataReuniao = ftDataReuniao;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		char i = e.getKeyChar();
		if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
		{
			ftDataReuniao.setEditable(true);
		}
		else
		{
			ftDataReuniao.setEditable(false);
			return;
		}
		
		if(ftDataReuniao.getText().length() == 2)
		{
			ftDataReuniao.setText(ftDataReuniao.getText() + "/");
		}
		if (ftDataReuniao.getText().length() == 5)
		{
			ftDataReuniao.setText(ftDataReuniao.getText() + "/");
		}
		if (ftDataReuniao.getText().length() >= 10)
		{
			ftDataReuniao.setEditable(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		{
			ftDataReuniao.setEditable(true);
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}
	
}
