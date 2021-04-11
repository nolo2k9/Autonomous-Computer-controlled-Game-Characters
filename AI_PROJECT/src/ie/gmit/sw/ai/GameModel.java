package ie.gmit.sw.ai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import ie.gmit.sw.ai.Ghosts.Ghosts;
import javafx.concurrent.Task;

/*
 * [READ THIS CAREFULLY]
 * You will need to change the method addGameCharacter() below and configure each
 * instance of CharacterTask with a Command object. The implementation below uses
 * a lambda expression ()-> System.out.println("Action executing!") as the default
 * logic for the execute() method.
 *
 * [WARNING] Don't mess with anything else in this class unless you know exactly
 * what you're at... If you break it, you own it.
 */
public class GameModel {
	private static final int MAX_CHARACTERS = 10;
	private ThreadLocalRandom rand = ThreadLocalRandom.current();
	private char[][] model;
	private Ghosts ghosts;
	private static GameModel gm = new GameModel();
	private Node s;

	private final ExecutorService exec = Executors.newFixedThreadPool(MAX_CHARACTERS, e -> {
		Thread t = new Thread(e);
		t.setDaemon(true);
		return t ;
	});

	public GameModel(int dimension){
		model = new char[dimension][dimension];
		init();
		carve();
		addGameCharacters();
	}

	public GameModel() {
		s = new Node("S");
		Node t = new Node("t");
		t.setGoalNode(true);
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");
		Node node9 = new Node("9");
		Node node10 = new Node("10");
		Node node11 = new Node("11");
		Node node12 = new Node("12");
		Node node13 = new Node("13");
		Node node14 = new Node("14");

		s.addChildNode(node1);
		s.addChildNode(node6);
		s.addChildNode(node8);

		node1.addChildNode(s);
		node1.addChildNode(node2);
		node1.addChildNode(node3);

		node2.addChildNode(node1);
		node2.addChildNode(node10);
		node2.addChildNode(node11);

		node11.addChildNode(node2);

		node10.addChildNode(node2);

		node3.addChildNode(node1);
		node3.addChildNode(node12);
		node3.addChildNode(node4);

		node12.addChildNode(node3);

		node4.addChildNode(node3);
		node4.addChildNode(node13);
		node4.addChildNode(node5);

		node13.addChildNode(node4);

		node5.addChildNode(node4);
		node5.addChildNode(node6);
		node5.addChildNode(node9);

		node6.addChildNode(node5);
		node6.addChildNode(s);
		node6.addChildNode(node7);

		node8.addChildNode(s);
		node8.addChildNode(node7);
		node8.addChildNode(node14);

		node14.addChildNode(node8);

		node7.addChildNode(node6);
		node7.addChildNode(node8);
		node7.addChildNode(node9);

		node9.addChildNode(node5);
		node9.addChildNode(node7);
		node9.addChildNode(t);

		t.addChildNode(node9);

	}

	public static GameModel getInstance() {
		return gm;
	}//return model

	public void tearDown() {
		exec.shutdownNow();
	}

	/*
	 * Initialises the game model by creating an n x m array filled with hedge
	 */
	private void init(){
		for (int row = 0; row < model.length; row++){
			for (int col = 0; col < model[row].length; col++){
				model[row][col] = '\u0030'; //\u0030 = 0x30 = 0 (base 10) = A hedge
			}
		}
	}

	/*
	 * Carve paths through the hedge to create passages.
	 */
	public void carve(){
		for (int row = 0; row < model.length; row++){
			for (int col = 0; col < model[row].length - 1; col++){
				if (row == 0) {
					model[row][col + 1] = '\u0020';
				}else if (col == model.length - 1) {
					model[row - 1][col] = '\u0020';
				}else if (rand.nextBoolean()) {
					model[row][col + 1] = '\u0020';
				}else {
					model[row - 1][col] = '\u0020';
				}
			}
		}
	}

	private void addGameCharacters() {
		Collection<Task<Void>> tasks = new ArrayList<>();
		addGameCharacter(tasks, '\u0032', '0', 1); //2 is a Red Enemy, 0 is a hedge
		addGameCharacter(tasks, '\u0033', '0', 1); //3 is a Pink Enemy, 0 is a hedge
		addGameCharacter(tasks, '\u0034', '0', 1); //4 is a Blue Enemy, 0 is a hedge
		addGameCharacter(tasks, '\u0035', '0', 1); //5 is a Red Green Enemy, 0 is a hedge
		addGameCharacter(tasks, '\u0036', '0', 1); //6 is a Orange Enemy, 0 is a hedge*/
		tasks.forEach(exec::execute);
	}

	private void addGameCharacter(Collection<Task<Void>> tasks, char enemyID, char replace, int number){
		int counter = 0;
		while (counter < number){
			int row = rand.nextInt(model.length);
			int col = rand.nextInt(model[0].length);

			if (model[row][col] == replace){
				model[row][col] = enemyID;

				/*
				 * IMPORTANT! Change the following to parameterise your CharacterTask with an instance of
				 * Command. The constructor call below is only parameterised with a lambda expression.
				 */
				tasks.add(new CharacterTask(this, enemyID, row, col, ghosts));

				counter++;
			}
		}
	}

	public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, char character){
		if (toRow <= this.size() - 1 && toCol <= this.size() - 1 && this.get(toRow, toCol) == ' '){
			this.set(fromRow, fromCol, '\u0020');
			this.set(toRow, toCol, character);
			return true;
		}else{
			return false; //Can't move
		}
	}

	public char[][] getModel(){
		return this.model;
	}

	public char get(int row, int col){
		return this.model[row][col];
	}

	public void set(int row, int col, char c){
		this.model[row][col] = c;
	}

	public int size(){
		return this.model.length;
	}
	public Node getStartNode(){
		return s;
	}
}