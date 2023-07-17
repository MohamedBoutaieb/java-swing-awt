
package src.ch.hearc.tools.decorator;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class JFrameBaseline extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameBaseline(JComponent jComponent, String title, ImageIcon icon)
		{
		this.icon = icon;
		this.jComponent = jComponent;
		geometrie();
		controle();
		apparence(title);
		}

	public JFrameBaseline(JComponent jComponent, String title)
		{
		this(jComponent, title, null);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometrie()
		{
		add(jComponent);
		}

	private void controle()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void apparence(String title)
		{
		if(icon != null)
			{
			setIconImage(this.icon.getImage());
			}
		setTitle(title);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private JComponent jComponent;
	// Input optionnel
	private ImageIcon icon;
	}
