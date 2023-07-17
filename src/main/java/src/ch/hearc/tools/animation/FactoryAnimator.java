
package src.ch.hearc.tools.animation;

import src.ch.hearc.tools.animation.implementation.AnimatorThread;

public class FactoryAnimator
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static Animator_I create(Animable_I animable, int sleepMS)
		{
		return new AnimatorThread(animable, sleepMS);
		//return new AnimatorTimerSwing(animable, sleepMS);
		//return new AnimatorTimerUtil(animable, sleepMS);
		}

	public static Animator_I create(Animable_I animable)
		{
		return new AnimatorThread(animable);
		//return new AnimatorTimerSwing(animable);
		//return new AnimatorTimerUtil(animable);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
