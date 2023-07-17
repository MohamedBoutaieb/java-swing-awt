
package src.ch.hearc.tools.animation.implementation;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Assertions;

import src.ch.hearc.tools.animation.Animable_I;
import src.ch.hearc.tools.animation.Animator_I;

public class AnimatorTimerUtil implements Animator_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public AnimatorTimerUtil(Animable_I animable, int sleepMS)
		{
		Assertions.assertTrue(sleepMS >= 0);
		this.animable = animable;
		this.sleepMS = new AtomicInteger(sleepMS);
		}

	public AnimatorTimerUtil(Animable_I animable)
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
			this.timer = new Timer();
			this.timer.scheduleAtFixedRate(createTimerTask(), 0, Math.max(this.sleepMS.get(), 1));
			}
		}

	@Override
	public synchronized void stop()
		{
		if (this.timer != null)
			{
			this.timer.cancel();
			this.timer = null;
			}
		}

	@Override
	public synchronized void setSleepMS(int sleepMS)
		{
		this.sleepMS.set(sleepMS);
		if (this.timer != null)//redemarre le timer avec le nouveau sleepMS
			{
			stop();
			start();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private TimerTask createTimerTask()
		{
		return new TimerTask()
			{

			@Override
			public void run()
				{
				animable.animationStep();
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// inputs
	private Animable_I animable;
	private AtomicInteger sleepMS;

	//tools
	private Timer timer;

	}
