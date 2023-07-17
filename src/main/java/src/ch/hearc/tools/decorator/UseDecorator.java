
package src.ch.hearc.tools.decorator;

import javax.swing.JButton;

public class UseDecorator
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		new JFrameBaseline(new JCenter(new JButton("centrer")), "center");
		new JFrameBaseline(new JCenterH(new JButton("centrerH")), "centerH");
		new JFrameBaseline(new JCenterV(new JButton("centrerV")), "centerV");

		// autre versions
			{
			new JFrameBaseline(new JCenter2(new JButton("centrer2")), "center2");
			new JFrameBaseline(new JCenter3(new JButton("centrer3")), "center3");
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
