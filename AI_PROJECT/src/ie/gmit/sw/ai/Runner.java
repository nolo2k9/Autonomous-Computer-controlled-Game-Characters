package ie.gmit.sw.ai;

import ie.gmit.sw.ai.Ghosts.Ghosts;
import ie.gmit.sw.ai.nn.EncogGhost;
import javafx.application.Application;
import org.encog.neural.networks.BasicNetwork;
import org.encog.util.obj.SerializeObject;

import java.io.File;
import java.io.IOException;

public class Runner {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		 * PLEASE READ CAREFULLY
		 * ---------------------
		 * If you need to load FCL functions to the application or
		 * train, configure and load a neural network, then it is 
		 * best to do all of this before loading the UI. Launching
		 * a UI in any language or framework and then starting a 
		 * long running task in the same thread is guaranteed to
		 * freeze the screen and crash the programme.
		 * 
		 * NB: you can assume that the JavaFX 15 API is already
		 * available and configured on the MODULE-PATH (NOT THE 
		 * CLASSPATH). 
		 */
		
		  //Add long-running initialisation instructions here.
		
		
		
		/*
		 * Launch the JavaFX UI only when all the long-running AI 
		 * configuration tasks have been completed. Use the arrow 
		 * keys to move the player character and the 'Z' key to 
		 * toggle the zoom in / out.
		 */

		System.out.println("****************************************************************************");
		System.out.println("*       GMIT- Dept. Computer Science and applied Physics                   *");
		System.out.println("*                                                                          *");
		System.out.println("*                          GHOST BUSTER                                    *");
		System.out.println("*  You wake up in a strange maze with no recollection of how you got there *");
		System.out.println("*                You have one objective SURVIVE !!!!!                      *");
		System.out.println("****************************************************************************");
		System.out.println("***************************** CONTROLS *************************************");
		System.out.println("*                         Press A to Attack                                *");
		System.out.println("*                   Directional buttons to move                            *");
		System.out.println("*                                                                          *");
		System.out.println("****************************************************************************");
		System.out.println("\n");

		//anew EncogGhost().networkInit();
		new EncogGhost().neuralNetwork();
		Application.launch(GameWindow.class, args);
	}
}