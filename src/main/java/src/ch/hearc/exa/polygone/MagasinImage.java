
package src.ch.hearc.exa.polygone;

import javax.swing.ImageIcon;

import src.ch.hearc.tools.image.ImageLoader;

/**
* <pre>
* Les images doivent se trouver dans un jar, et le jar dans le classapth!
* Le jar doit contenir le folder ressources/cours.
* A l'interieur du folder cours doit se trouver les images aux formats (jpg, voir mieux png pour la transparance)
* </pre>
*/
public class MagasinImage
	{

	private static final String PATH_IN_JAR="images/cours_java/"; // conseil : specifier toujours le nom du projet, pour garantir l'uniciter!

	/*------------------------------------------------------------------*\
	|*		 Version Synchrone (bloquant)								*|
	\*------------------------------------------------------------------*/

	public static final ImageIcon WARNING = ImageLoader.loadSynchroneJar(PATH_IN_JAR+"warning.png");
	public static final ImageIcon JAVA = ImageLoader.loadSynchroneJar(PATH_IN_JAR+"java.png");
	public static final ImageIcon LINUX = ImageLoader.loadSynchroneJar(PATH_IN_JAR+"linux.png");
	public static final ImageIcon CERVIN = ImageLoader.loadSynchroneJar(PATH_IN_JAR+"cervin.png");



	/*------------------------------------------------------------------*\
	|*		Version Assynchrone	(non bloquant)							*|
	\*------------------------------------------------------------------*/

	//public static final ImageIcon WARNING = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"warning.png");
	//public static final ImageIcon JAVA = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"java.png");
	//public static final ImageIcon LINUX = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"linux.png");
	//public static final ImageIcon CERVIN = ImageLoader.loadAsynchroneJar(PATH_IN_JAR+"cervin.png");



	}
