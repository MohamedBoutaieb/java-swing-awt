
package src.ch.hearc.tools.animation.implementation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.Timer;

import org.junit.jupiter.api.Assertions;

import src.ch.hearc.tools.animation.Animable_I;
import src.ch.hearc.tools.animation.Animator_I;

public class AnimatorTimerSwing implements Animator_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public AnimatorTimerSwing(Animable_I animable, long sleepMS)
		{
		Assertions.assertTrue(sleepMS >= 0);
		this.animable = animable;
		this.sleepMS = new AtomicLong(sleepMS);
		}

	public AnimatorTimerSwing(Animable_I animable)
		{
		this(animable, 1);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public synchronized void start()
		{
		if (this.timer == null)
			{
			this.timer = new Timer((int)this.sleepMS.get(), createActionListener());
			this.timer.start();
			}
		}

	@Override
	public synchronized void stop()
		{
		if (this.timer != null)
			{
			this.timer.stop();
			this.timer = null;
			}
		}

	@Override
	public synchronized void setSleepMS(int sleepMS)
		{
		this.sleepMS.set(sleepMS);
		if (this.timer != null)
			{
			stop();
			start();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private ActionListener createActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				animable.animationStep();
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private Animable_I animable;
	private AtomicLong sleepMS;

	//tools
	private Timer timer;
	}
