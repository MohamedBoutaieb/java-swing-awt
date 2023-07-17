
package src.ch.hearc.tools.decorator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

public class JCenter extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JCenter(JComponent jcomponent)
		{
		super(BoxLayout.Y_AXIS);

		this.component = jcomponent;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		Box boxH = Box.createHorizontalBox();

		boxH.add(Box.createHorizontalGlue());
		boxH.add(this.component);
		boxH.add(Box.createHorizontalGlue());

		add(Box.createVerticalGlue());
		add(boxH);
		add(Box.createVerticalGlue());
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Input
	private JComponent component;
	}
