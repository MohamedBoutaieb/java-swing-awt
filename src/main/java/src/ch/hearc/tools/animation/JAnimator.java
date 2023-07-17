
package src.ch.hearc.tools.animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JAnimator extends JPanel
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JAnimator(Animator_I animator, int maxSleepMS, int currentMS)
		{
		this.animator = animator;
		this.maxSleepMS = maxSleepMS;
		this.currentMS=currentMS;

		geometry();
		control();
		appearance();

		this.animator.setSleepMS(currentMS);
		}

	public JAnimator(Animator_I animator)
		{
		this(animator, 10,10);
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
		this.boutonStart = new JButton("Start");
		this.boutonStop = new JButton("Stop");
		this.sliderSleep = new JSlider(0, maxSleepMS,currentMS);

		this.add(boutonStart);
		this.add(boutonStop);
		this.add(sliderSleep);
		}

	private void control()
		{
		this.boutonStart.addActionListener(createActionListenerStart());
		this.boutonStop.addActionListener(createActionListenerStop());
		this.sliderSleep.addChangeListener(createChangeListener());
		}

	private ChangeListener createChangeListener()
		{
		return new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				int value = sliderSleep.getValue();

				sliderSleep.setBorder(BorderFactory.createTitledBorder(createTitleSlider()));

				animator.setSleepMS(value);
				}
			};
		}

	private void appearance()
		{
		this.boutonStop.setEnabled(false);
		this.sliderSleep.setBorder(BorderFactory.createTitledBorder(createTitleSlider()));
		}

	private String createTitleSlider()
		{
		return "Sleep " + sliderSleep.getValue() + "/" + sliderSleep.getMaximum() + " [ms]";
		}

	private ActionListener createActionListenerStart()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				animator.start();
				inverserEtatBouton();
				}

			};
		}

	private ActionListener createActionListenerStop()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				animator.stop();
				inverserEtatBouton();
				}
			};
		}

	private void inverserEtatBouton()
		{
		boutonStart.setEnabled(!boutonStart.isEnabled());
		boutonStop.setEnabled(!boutonStop.isEnabled());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Animator_I animator;
	private int maxSleepMS;
	private int currentMS;

	// Tools
	private JButton boutonStart;
	private JButton boutonStop;
	private JSlider sliderSleep;
	}
