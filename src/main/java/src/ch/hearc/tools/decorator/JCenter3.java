
package src.ch.hearc.tools.decorator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

/**
 * idem JCenter (implementation differente)
 */
public class JCenter3 extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JCenter3(JComponent jcomponent)
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
		add(Box.createVerticalGlue());
		add(new JCenterH(this.component));
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
