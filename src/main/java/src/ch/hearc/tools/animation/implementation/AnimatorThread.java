
package src.ch.hearc.tools.animation.implementation;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.Assertions;

import src.ch.hearc.tools.Threads;
import src.ch.hearc.tools.animation.Animable_I;
import src.ch.hearc.tools.animation.Animator_I;

public class AnimatorThread implements Animator_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public AnimatorThread(Animable_I animable, long sleepMS)
		{
		Assertions.assertTrue(sleepMS >= 0);
		this.animable = animable;
		this.sleepMS = new AtomicLong(sleepMS);
		this.isFini = new AtomicBoolean(true);
		}

	public AnimatorThread(Animable_I animable)
		{
		this(animable, 1);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public synchronized void start()
		{
		if (this.thread == null)
			{
			this.isFini.set(false);
			this.thread = new Thread(createRunnable());
			this.thread.setName("Animation Bidule");
			this.thread.start();
			}
		}

	@Override
	public synchronized void stop()
		{
		if (this.thread != null)
			{
			//			this.thread.stop();
			this.isFini.set(true);
			while(this.thread.isAlive())
				{
				Threads.sleep(100);
				}
			this.thread = null;
			}
		}

	@Override
	public void setSleepMS(int sleepMS)
		{
		Assertions.assertTrue(sleepMS >= 0);
		this.sleepMS = new AtomicLong(sleepMS);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private Runnable createRunnable()
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				while(!isFini.get())
					{
					animable.animationStep();
					Threads.sleep(sleepMS.get());
					}
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
	private Thread thread;
	private AtomicBoolean isFini;
	}
