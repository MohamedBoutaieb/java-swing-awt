
package src.ch.hearc.tools;

import java.awt.Dimension;

import javax.swing.JComponent;

public class Sizes
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void setW(JComponent jComponent, int w)
		{
		jComponent.setMinimumSize(new Dimension(w, jComponent.getMinimumSize().height));
		jComponent.setMaximumSize(new Dimension(w, jComponent.getMaximumSize().height));
		jComponent.setPreferredSize(new Dimension(w, jComponent.getPreferredSize().height));

		}

	public static void setH(JComponent jComponent, int h)
		{
		jComponent.setMinimumSize(new Dimension(jComponent.getMinimumSize().width, h));
		jComponent.setMaximumSize(new Dimension(jComponent.getMaximumSize().width, h));
		jComponent.setPreferredSize(new Dimension(jComponent.getPreferredSize().width, h));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
