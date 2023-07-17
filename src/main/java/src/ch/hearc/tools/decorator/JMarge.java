
package src.ch.hearc.tools.decorator;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import src.ch.hearc.tools.Sizes;

public class JMarge extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JMarge(JComponent jComponent, int dw, int dh, String title)
		{
		this.jComponent = jComponent;
		this.dw = dw;
		this.dh = dh;
		this.title = title;

		geometry();
		control();
		appearance();
		}

	public JMarge(JComponent jComponent, int marge, String title)
		{
		this(jComponent, marge, marge, title);
		}

	public JMarge(JComponent jComponent, int dw, int dh)
		{
		this(jComponent, dw, dh, null);
		}

	public JMarge(JComponent jComponent, int marge)
		{
		this(jComponent, marge, marge);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.jPanelEast = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();

		this.setLayout(new BorderLayout());

		this.add(this.jComponent, BorderLayout.CENTER);
		this.add(this.jPanelEast, BorderLayout.EAST);
		this.add(this.jPanelWest, BorderLayout.WEST);
		this.add(this.jPanelNorth, BorderLayout.NORTH);
		this.add(this.jPanelSouth, BorderLayout.SOUTH);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// border
			{
			if (this.title != null)
				{
				this.setBorder(BorderFactory.createTitledBorder(this.title));
				}
			}

		// size
			{
			// width
				{
				Sizes.setW(this.jPanelEast, this.dw);
				Sizes.setW(this.jPanelWest, this.dw);
				}

			// height
				{
				Sizes.setH(this.jPanelNorth, this.dh);
				Sizes.setH(this.jPanelSouth, this.dh);
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JComponent jComponent;
	private int dw;
	private int dh;
	private String title;

	// Tools
	private JPanel jPanelEast;
	private JPanel jPanelWest;
	private JPanel jPanelNorth;
	private JPanel jPanelSouth;

	}
